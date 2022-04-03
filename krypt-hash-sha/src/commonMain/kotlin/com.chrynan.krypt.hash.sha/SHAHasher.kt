@file:Suppress("unused")

package com.chrynan.krypt.hash.sha

import com.chrynan.krypt.core.SecureString
import com.chrynan.krypt.core.toSecureString
import com.chrynan.krypt.hash.Hasher
import okio.ByteString.Companion.encodeUtf8

interface SHAHasher : Hasher<SHAHashAlgorithm, SecureString, SHAHashResult> {

    companion object
}

suspend fun SHAHasher.hash(source: CharSequence): SHAHashResult = hash(source = source.toSecureString())

internal class OkioSHAHasher(
    override val algorithm: SHAHashAlgorithm
) : SHAHasher {

    override suspend fun hash(source: SecureString): SHAHashResult {
        val insecureUtf8String = source.toInsecureString().encodeUtf8()

        val hashedByteString = when (algorithm.type) {
            SHAType.SHA_1 -> insecureUtf8String.sha1()
            SHAType.SHA_256 -> insecureUtf8String.sha256()
            SHAType.SHA_512 -> insecureUtf8String.sha512()
        }

        val hashedString = when (algorithm.outputFormat) {
            SHAOutputFormat.UTF_8 -> hashedByteString.utf8()
            SHAOutputFormat.HEX -> hashedByteString.hex()
            SHAOutputFormat.BASE64 -> hashedByteString.base64()
            SHAOutputFormat.BASE64_URL -> hashedByteString.base64Url()
        }

        return SHAHashResult(
            algorithm = algorithm,
            hash = hashedString.toSecureString()
        )
    }

    override suspend fun matches(source: SecureString, result: SHAHashResult): Boolean {
        val sourceResult = hash(source = source)

        return sourceResult.hash == result.hash
    }
}

fun Hasher.Companion.sha1(outputFormat: SHAOutputFormat = SHAOutputFormat.UTF_8): SHAHasher {
    val algorithm = SHAHashAlgorithm(
        type = SHAType.SHA_1,
        outputFormat = outputFormat
    )

    return OkioSHAHasher(algorithm = algorithm)
}

fun Hasher.Companion.sha256(outputFormat: SHAOutputFormat = SHAOutputFormat.UTF_8): SHAHasher {
    val algorithm = SHAHashAlgorithm(
        type = SHAType.SHA_256,
        outputFormat = outputFormat
    )

    return OkioSHAHasher(algorithm = algorithm)
}

fun Hasher.Companion.sha512(outputFormat: SHAOutputFormat = SHAOutputFormat.UTF_8): SHAHasher {
    val algorithm = SHAHashAlgorithm(
        type = SHAType.SHA_512,
        outputFormat = outputFormat
    )

    return OkioSHAHasher(algorithm = algorithm)
}
