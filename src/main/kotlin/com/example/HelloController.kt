package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule
import java.security.Security

@Controller("/")
class HelloController {


    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/hello", produces = [MediaType.TEXT_PLAIN])
    fun sayHello(): String {
        return "Hello World!"
    }

    @Get("/testDb", produces = [MediaType.TEXT_PLAIN])
    fun testDb(): String {
        println("Database test Starting")

        return "Database test Finished"
    }
}