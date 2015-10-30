package com.example

class Books {

    String bookTitle
    Integer noOfPages
    static hasMany = [author:Author]
    static belongsTo = Author
    static constraints = {
        bookTitle blank: false
    }
}


