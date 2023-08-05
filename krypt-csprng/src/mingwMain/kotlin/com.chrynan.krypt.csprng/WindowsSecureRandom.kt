@file:Suppress("unused")

package com.chrynan.krypt.csprng

import kotlinx.cinterop.Pinned
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.reinterpret
import org.kotlincrypto.SecRandomCopyException
import platform.windows.BCRYPT_USE_SYSTEM_PREFERRED_RNG
import platform.windows.BCryptGenRandom
import platform.windows.STATUS_INVALID_HANDLE
import platform.windows.STATUS_INVALID_PARAMETER

actual class SecureRandom actual constructor() : AbstractSecureRandom() {

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray {
        // https://learn.microsoft.com/en-us/windows/win32/api/bcrypt/nf-bcrypt-bcryptgenrandom
        array.usePinned { pinned ->
            BCryptGenRandom(
                null,
                pinned.addressOf(0).reinterpret(),
                array.size.toULong().convert(),
                BCRYPT_USE_SYSTEM_PREFERRED_RNG,
            )
        }

        return array.copyOfRange(fromIndex = fromIndex, toIndex = toIndex)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return other is SecureRandom
    }

    override fun hashCode(): Int =
        this::class.hashCode()

    override fun toString(): String =
        "SecureRandom()"

    actual companion object
}
