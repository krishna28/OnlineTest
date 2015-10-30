package com.example

class Options {

    String optionName

    static belongsTo = [question:Question]

    String toString(){
        return optionName
    }
    static constraints = {
    }
}
