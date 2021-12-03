package com.chrynan.auth.core

interface KeyGenerator<Output> {

    suspend fun generate(): Output
}
