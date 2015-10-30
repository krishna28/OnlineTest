package com.example

class Question {

    String questionName

    static hasMany = [options:Options]

    String toString(){
        return questionName
    }

    static constraints = {
    }
}
