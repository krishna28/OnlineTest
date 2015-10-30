package com.example

class Author {

    String authorName
    Integer noOfBooks
    Integer yearOfExp
    static hasMany = [book:Books]


    static constraints = {
    }
}
