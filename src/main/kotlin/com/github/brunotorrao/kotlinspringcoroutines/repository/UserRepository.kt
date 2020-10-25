package com.github.brunotorrao.kotlinspringcoroutines.repository

import com.github.brunotorrao.kotlinspringcoroutines.domain.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CoroutineCrudRepository<User, Int> {

}