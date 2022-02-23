package grails.sample

import java.sql.Timestamp

class Book {

    static constraints = {
    }

    String title
    Integer page
    Timestamp time
}
