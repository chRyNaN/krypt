package com.chrynan.krypt.srp

import com.chrynan.krypt.core.KeyPairGenerator
import com.chrynan.krypt.core.PublicRedactedProperty

/**
 * An interface representing a component that can generate a [SrpKeyPair] value.
 */
interface SrpKeyPairGenerator<T : Any> : KeyPairGenerator<PublicRedactedProperty<T>, PublicRedactedProperty<T>> {

    override val algorithm: String?
        get() = null

    override suspend fun invoke(): SrpKeyPair<T>
}
