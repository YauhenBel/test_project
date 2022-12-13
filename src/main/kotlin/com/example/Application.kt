package com.example

import io.micronaut.runtime.Micronaut.*
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(info = Info(title = "Всем на колени!"))
object Application {
	@JvmStatic
	fun main(args: Array<String>) {
		try {
		    build(*args)
				.eagerInitSingletons(true)
				.mainClass(Application.javaClass).start()
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
}

