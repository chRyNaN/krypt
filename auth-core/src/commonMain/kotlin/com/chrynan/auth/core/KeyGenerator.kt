package com.chrynan.auth.core

interface KeyGenerator {

    suspend fun generate(): String
}
