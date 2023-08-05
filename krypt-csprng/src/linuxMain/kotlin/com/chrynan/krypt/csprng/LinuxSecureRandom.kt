package com.chrynan.krypt.csprng

actual class SecureRandom actual constructor() : AbstractSecureRandom() {

    actual override fun nextBytes(array: ByteArray, fromIndex: Int, toIndex: Int): ByteArray =
        if (GetRandomSecureRandom.isAvailable()) {
            GetRandomSecureRandom.nextBytes(array = array, fromIndex = fromIndex, toIndex = toIndex)
        } else {
            URandom.nextBytes(array = array, fromIndex = fromIndex, toIndex = toIndex)
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
