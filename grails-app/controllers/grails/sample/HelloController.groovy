package grails.sample

import org.springframework.beans.factory.annotation.Autowired
import grails.converters.JSON
import java.time.LocalDateTime

class HelloController {

    @Autowired
    HelloService helloService

    def index() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~")
        helloService.serviceMethod()
        Map res = [message: LocalDateTime.now().toString()]
        render res as JSON
        System.out.println("~~~~~~~~~~~~~~~~~~~~")
    }
}
