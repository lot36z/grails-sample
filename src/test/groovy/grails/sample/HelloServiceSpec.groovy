package grails.sample

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class HelloServiceSpec extends Specification implements ServiceUnitTest<HelloService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
