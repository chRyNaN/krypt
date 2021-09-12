@file:Suppress("unused")

package com.chrynan.auth.core

actual typealias SecureRandom = java.security.SecureRandom

actual fun SecureRandom(algorithmName: String?): SecureRandom =
    algorithmName?.let { java.security.SecureRandom.getInstance(it) } ?: java.security.SecureRandom.getInstanceStrong()
