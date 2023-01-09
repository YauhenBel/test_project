package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController {
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