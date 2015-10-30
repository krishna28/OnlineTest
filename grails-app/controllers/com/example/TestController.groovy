package com.example

import java.sql.SQLException

class TestController {

    def index() {

 render "welcome to the home page";



    }


    def save(){

        def author = new Author(authorName: "baiju",noOfBooks: 5,yearOfExp: 25).save();

       author.addToBook(bookTitle: "machine design",noOfPages: 233).save();

        render ("book saved successfully");
    }

    def trans(){
       def foo =new Foo()
        foo.ba = new Bar()
        foo.ba.barName = 300
        foo.save()
    }

    def remove() {
        try {
            def author = Author.get(1);
            author.delete();
            render "Author deleted successfully";
        }catch (Exception e){
            render (e.stackTrace);
        }

    }

    def handleIOException(IOException ioex){
        /*
           This method will be executed if any IO Exception occurs .
        */
        render "Something Went Wrong in io"
    }


    def handleSQLException(SQLException sqlex){
        /*
           This method will be executed if any IO Exception occurs .
        */
        render "Something Went Wrong in sql"
    }



}
