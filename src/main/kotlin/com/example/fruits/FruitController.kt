package com.example.fruits

import io.micronaut.core.annotation.NonNull
import io.micronaut.http.HttpStatus
import io.micronaut.http.HttpStatus.CONFLICT
import io.micronaut.http.HttpStatus.CREATED
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import javax.validation.Valid

@Controller("/fruits")
open class FruitController(private val fruitService: FruitRepository) {

    @Get
    fun list(): Publisher<Fruit> {
        return fruitService.list()
    }

    @Post
    open fun save(@Valid fruit: Fruit): Mono<HttpStatus> {
        return fruitService.save(fruit)
            .map { added: Boolean -> if (added) CREATED else CONFLICT }
    }

    @Delete
    open fun delete(@NonNull name: String): Mono<Boolean> =
        fruitService.delete(name)

    @Post("/update")
    open fun update(@NonNull name: String, @NonNull description: String): Mono<Boolean> =
        fruitService.update(name, description)

}