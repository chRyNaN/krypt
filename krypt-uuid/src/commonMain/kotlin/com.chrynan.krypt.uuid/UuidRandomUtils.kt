@file:Suppress("unused")

package com.chrynan.krypt.uuid

import com.chrynan.krypt.csprng.SecureRandom
import kotlin.experimental.and
import kotlin.experimental.or

/**
 * Retrieves the next random [Uuid].
 */
fun SecureRandom.nextUuid(): Uuid {
    var randomBytes = ByteArray(16)
    randomBytes = nextBytes(randomBytes)

    randomBytes[6] = randomBytes[6] and 0x0f /* clear version        */
    randomBytes[6] = randomBytes[6] or 0x40 /* set to version 4     */
    randomBytes[8] = randomBytes[8] and 0x3f /* clear variant        */
    randomBytes[8] = randomBytes[8] or 0x80.toByte() /* set to IETF variant  */

    return Uuid.from(randomBytes)
}

/**
 * Retrieves the next random [Uuid].
 *
 * @see [nextUuid]
 */
fun Uuid.Companion.random(): Uuid {
    val secureRandom = SecureRandom()

    return secureRandom.nextUuid()
}
