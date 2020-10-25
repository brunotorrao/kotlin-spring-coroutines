package com.github.brunotorrao.kotlinspringcoroutines.controller

import com.github.brunotorrao.kotlinspringcoroutines.domain.User
import com.github.brunotorrao.kotlinspringcoroutines.repository.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@RestController
class UserController(
        private val repository: UserRepository,
        private val webClient: WebClient
) {
    
    @PostMapping("/users")
    @ResponseStatus(CREATED)
    suspend fun create(@RequestBody user: User): User {
        val userWithDetails = getUserWithDetails(user.name)
        
        return repository.save(userWithDetails)
    }
    
    @PostMapping("/users", params = ["multi"])
    suspend fun saveAll(@RequestBody users: List<User>): List<User> = coroutineScope {
        users
                .map { async { getUserWithDetails(it.name) } }
                .map { repository.save(it.await()) }
    }
    
    suspend fun getUserWithDetails(name: String): User {
        val age = webClient.get()
                .uri("/details/$name")
                .header("content-type", "application/json")
                .retrieve()
                .awaitBody<Int>()
        
        return User(name = name, age = age)
    }
    
    @GetMapping("/users/{id}")
    suspend fun getById(@PathVariable id: Int) : User? {
        return repository.findById(id)
    }
}