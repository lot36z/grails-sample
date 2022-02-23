package grails.sample

import grails.gorm.transactions.Transactional
import java.sql.Timestamp
import java.time.LocalDateTime
import org.springframework.transaction.annotation.Propagation

class HelloService {

    @Transactional
    def serviceMethod() {
        println "serviceMethod"
        Person person = new Person(name:"Tom Brown", age:5, time: Timestamp.valueOf(LocalDateTime.now()))
        println "id: ${person.id}, isAttached: ${person.isAttached()}, isDirty: ${person.isDirty()}"
        person.save(flush: true, validation: true, failOnError: true)
        println "id: ${person.id}, isAttached: ${person.isAttached()}, isDirty: ${person.isDirty()}"
        Person newPerson = Person.find({ id == person.id })
        println "newPerson: ${newPerson}, isEqual: ${newPerson == person}"
        try{
            subTransaction(person)
        }catch (Exception e) {
            println e
            // throw e
        }
        person.age = 50
        println "id: ${person.id}, isAttached: ${person.isAttached()}, isDirty: ${person.isDirty()}"
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    def subTransaction(Person person) {
        println "  ===  "
        println "id: ${person.id}, isAttached: ${person.isAttached()}, isDirty: ${person.isDirty()}"
        person.age = 10
        // person.save(flush: true, validation: true, failOnError: true)
        // person.save(validation: true, failOnError: true)
        // println "id: ${person.id}, isAttached: ${person.isAttached()}, isDirty: ${person.isDirty()}"
        Book book = new Book(title: "The Neverending Story", page: 500, time: Timestamp.valueOf(LocalDateTime.now()))
        book.save(flush: true, validation: true, failOnError: true)
        println "  ===  "
        throw new Exception("happ")
    }
}
