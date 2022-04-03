@file:Suppress("unused")

package com.chrynan.auth.core

/**
 * An interface representing a Key Derivation Function (KDF).
 *
 * @see [Wikipedia Explanation](https://en.wikipedia.org/wiki/Key_derivation_function)
 */
interface KeyDerivationFunction<Input : Any, Result : DerivedKeyResult> {

    suspend fun deriveKey(source: Input): Result

    companion object
}

/**
 * An interface representing the result of a [KeyDerivationFunction].
 */
interface DerivedKeyResult {

    companion object
}
