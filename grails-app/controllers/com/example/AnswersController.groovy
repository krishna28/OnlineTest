package com.example



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnswersController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Answers.list(params), model:[answersInstanceCount: Answers.count()]
    }

    def show(Answers answersInstance) {
        respond answersInstance
    }

    def create() {
        respond new Answers(params)
    }

    @Transactional
    def save(Answers answersInstance) {
        if (answersInstance == null) {
            notFound()
            return
        }

        if (answersInstance.hasErrors()) {
            respond answersInstance.errors, view:'create'
            return
        }

        answersInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'answersInstance.label', default: 'Answers'), answersInstance.id])
                redirect answersInstance
            }
            '*' { respond answersInstance, [status: CREATED] }
        }
    }

    def edit(Answers answersInstance) {
        respond answersInstance
    }

    @Transactional
    def update(Answers answersInstance) {
        if (answersInstance == null) {
            notFound()
            return
        }

        if (answersInstance.hasErrors()) {
            respond answersInstance.errors, view:'edit'
            return
        }

        answersInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Answers.label', default: 'Answers'), answersInstance.id])
                redirect answersInstance
            }
            '*'{ respond answersInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Answers answersInstance) {

        if (answersInstance == null) {
            notFound()
            return
        }

        answersInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Answers.label', default: 'Answers'), answersInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'answersInstance.label', default: 'Answers'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
