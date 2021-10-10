package com.chrynan.auth.api

import io.ktor.http.*

fun headersOf(vararg pairs: Pair<String, String>): Headers =
    io.ktor.http.headersOf(*pairs.map { it.first to listOf(it.second) }.toTypedArray())
