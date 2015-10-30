package com.example

class HomeController {

    def index() {

        def listOfQuestion = Question.findAll();

        def questionOptionsMap = [:]

        listOfQuestion.each { ins ->

            questionOptionsMap[ins] = ins.options.sort({ a, b -> a.id <=> b.id })

        }
        [questionAnswer: questionOptionsMap]

    }


    def submit() {

        def testPass = false;

        def answers = [:]

        def listOfQuestionWithAnswer = [:]

        def answersList = Answers.findAll();

        answersList.each({ ins ->

            listOfQuestionWithAnswer[ins.questionInstance.id.toString()] = ins.optionsInstance.id.toString()

        })

        params.each { par ->


            if (!(par.key == "action" || par.key == "format" || par.key == "controller")) {
                answers[par.key] = listOfQuestionWithAnswer[par.key.toString()]?.contains(par.value.toString())
            }

        }


        def total = answers.size()

        def passPercentage = 60

        def correctCount = 0

        def percentage = 0

        answers.each({
            if (it.value)
                correctCount++
        })

        percentage = (correctCount / total) * 100

        if (percentage >= passPercentage) {
            testPass = true
        }

        [result: testPass, passPercentage: percentage]
    }


    def query() {

        def question = Question.executeQuery("from Question");
        println question


    }
}

