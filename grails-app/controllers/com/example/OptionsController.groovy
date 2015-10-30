package com.example



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class OptionsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Options.list(params), model:[optionsInstanceCount: Options.count()]
    }

    def show(Options optionsInstance) {
        respond optionsInstance
    }

    def create() {
        respond new Options(params)
    }

    @Transactional
    def save(Options optionsInstance) {
        if (optionsInstance == null) {
            notFound()
            return
        }

        if (optionsInstance.hasErrors()) {
            respond optionsInstance.errors, view:'create'
            return
        }

        optionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'optionsInstance.label', default: 'Options'), optionsInstance.id])
                redirect optionsInstance
            }
            '*' { respond optionsInstance, [status: CREATED] }
        }
    }

    def edit(Options optionsInstance) {
        respond optionsInstance
    }

    @Transactional
    def update(Options optionsInstance) {
        if (optionsInstance == null) {
            notFound()
            return
        }

        if (optionsInstance.hasErrors()) {
            respond optionsInstance.errors, view:'edit'
            return
        }

        optionsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Options.label', default: 'Options'), optionsInstance.id])
                redirect optionsInstance
            }
            '*'{ respond optionsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Options optionsInstance) {

        if (optionsInstance == null) {
            notFound()
            return
        }

        optionsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Options.label', default: 'Options'), optionsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'optionsInstance.label', default: 'Options'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
