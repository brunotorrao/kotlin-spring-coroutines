package com.github.brunotorrao.kotlinspringcoroutines.controller

import com.github.brunotorrao.kotlinspringcoroutines.domain.User
import kotlinx.coroutines.delay
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class UserDetailsController {
    
    @GetMapping("/details/{name}", produces = [APPLICATION_JSON_VALUE], consumes = [APPLICATION_JSON_VALUE])
    suspend fun getDetails(@PathVariable name: String): Int {
        delay(2_000)
        return Random(0).nextInt(1, 88)
    }
}