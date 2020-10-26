package com.github.brunotorrao.kotlinspringcoroutines

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringCoroutinesApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringCoroutinesApplication>(*args)
}
