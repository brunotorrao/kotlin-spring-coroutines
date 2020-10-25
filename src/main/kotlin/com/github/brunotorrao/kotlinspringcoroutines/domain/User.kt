package com.github.brunotorrao.kotlinspringcoroutines.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class User(
        @Id
        val id: Int? = null,
        val name: String,
        val age: Int? = null
)