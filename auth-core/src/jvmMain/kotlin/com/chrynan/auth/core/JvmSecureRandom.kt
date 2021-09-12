@file:Suppress("unused")

package com.chrynan.auth.core

import com.benasher44.uuid.Uuid

actual typealias SecureRandom = java.security.SecureRandom

actual fun SecureRandom(algorithmName: String?): SecureRandom =
    algorithmName?.let { java.security.SecureRandom.getInstance(it) } ?: java.security.SecureRandom.getInstanceStrong()

actual fun SecureRandom.nextUuid(): Uuid = Uuid.randomUUID()
