package com.chrynan.krypt.srp

import com.chrynan.krypt.core.KeyPairGenerator
import com.chrynan.krypt.core.PublicRedactedProperty
import com.chrynan.krypt.csprng.SecureRandom
import com.ionspin.kotlin.bignum.integer.BigInteger

/**
 * An interface representing a component that can generate a [SrpKeyPair] value.
 */
interface SrpKeyPairGenerator<T : Any> : KeyPairGenerator<PublicRedactedProperty<T>, PublicRedactedProperty<T>> {

    override val algorithm: String?
        get() = null

    override suspend fun invoke(): SrpKeyPair<T>

    companion object
}

/**
 * Creates a default [SrpKeyPairGenerator] instance using the provided [secureRandom] and [group] parameter values.
 */
@Suppress("FunctionName")
fun SrpKeyPairGenerator.Companion.Default(
    secureRandom: SecureRandom = SecureRandom(),
    group: Group = Group.N2048
): SrpKeyPairGenerator<BigInteger> =
    DefaultSrpKeyPairGenerator(
        secureRandom = secureRandom,
        group = group
    )

private class DefaultSrpKeyPairGenerator(
    private val secureRandom: SecureRandom,
    private val group: Group
) : SrpKeyPairGenerator<BigInteger> {

    @OptIn(ExperimentalUnsignedTypes::class)
    override suspend fun invoke(): SrpKeyPair<BigInteger> {
        val privateKey = secureRandom.nextBigInteger()
        val publicKey = calculateA(group = group, a = privateKey)

        return SrpKeyPair(privateKey = privateKey, publicKey = publicKey)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is DefaultSrpKeyPairGenerator) return false

        if (secureRandom != other.secureRandom) return false
        return group == other.group
    }

    override fun hashCode(): Int {
        var result = secureRandom.hashCode()
        result = 31 * result + group.hashCode()
        return result
    }

    override fun toString(): String =
        "DefaultSrpKeyPairGenerator(secureRandom=$secureRandom, group=$group)"
}
