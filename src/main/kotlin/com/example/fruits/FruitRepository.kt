package com.example.fruits

import io.micronaut.core.annotation.NonNull
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import javax.validation.Valid

interface FruitRepository {

    fun list(): Publisher<Fruit>

    fun save(@Valid fruit: Fruit): Mono<Boolean>

    fun delete(@NonNull name: String): Mono<Boolean>

    fun update(@NonNull name: String, @NonNull description: String): Mono<Boolean>
}