package com.example.fruits

import com.mongodb.client.model.Filters.eq
import com.mongodb.client.model.Updates.set
import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import io.micronaut.context.annotation.Context
import io.micronaut.context.annotation.Property
import io.micronaut.core.annotation.NonNull
import org.bson.conversions.Bson
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import javax.validation.Valid

@Context
open class MongoDbFruitRepository(
    private val mongoClient: MongoClient,
    @Property(name = "mongodb.dbName") private val dbName: String,

    ) : FruitRepository {
    private val db: MongoDatabase = mongoClient.getDatabase(dbName)

    override fun save(@Valid fruit: Fruit): Mono<Boolean> =
        Mono.from(collection.insertOne(fruit)).map { true }.onErrorReturn(false)

    override fun delete(name: String): Mono<Boolean> {
        val query: Bson = eq("name", name)
        return Mono.from(collection.deleteOne(query)).map { true }.onErrorReturn(false)
    }

    override fun update(name: String, description: String): Mono<Boolean> {
        val filter: Bson = eq("name", name)
        val newValue: Bson = set("description", description)

        return Mono.from(collection.findOneAndUpdate(filter, newValue)).map { true }
            .onErrorReturn(false)


    }

    @NonNull
    override fun list(): Publisher<Fruit> = collection.find()

    private val collection: MongoCollection<Fruit>
        get() = db.getCollection("test", Fruit::class.java)
}