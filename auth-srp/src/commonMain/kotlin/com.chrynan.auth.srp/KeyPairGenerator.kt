package com.chrynan.auth.srp

interface KeyPairGenerator<T : Any> {

    suspend fun generateKeyPair(): KeyPair<T>
}
