package com.chrynan.auth.api

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.routing.*

fun Route.login() {
    post("/login") {
        // Basic Auth:
        // https://en.wikipedia.org/wiki/Basic_access_authentication
        // Authorization: Basic ${base64Encode("$email:$password")}
        val base64EncodedCredentials = call.request.headers[HeaderKeys.AUTH]
    }
}

fun Route.logout() {
    post("/logout") {

    }
}
