//[krypt-pkce](../../../index.md)/[com.chrynan.krypt.pkce](../index.md)/[Pkce](index.md)

# Pkce

[common]\
class [Pkce](index.md)(base64Encoder: [Base64Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder/index.md) = Base64UrlEncoder(isWithPadding = false), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom())

A class implementing the Proof Key for Code Exchange (PKCE, pronounced &quot;pixy&quot;), [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains functions that can be used to perform the protocol. However, note that the communication of the values between the parties involved is not handled by this class and must be handled out-of-band.

## See also

common

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636) |

## Constructors

| | |
|---|---|
| [Pkce](-pkce.md) | [common]<br>fun [Pkce](-pkce.md)(base64Encoder: [Base64Encoder](../../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder/index.md) = Base64UrlEncoder(isWithPadding = false), random: [SecureRandom](../../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom()) |

## Functions

| Name | Summary |
|---|---|
| [createCodeChallenge](create-code-challenge.md) | [common]<br>suspend fun [createCodeChallenge](create-code-challenge.md)(verifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a &quot;code_challenge&quot;, specified in the PKCE protocol, from the provided [verifier](create-code-challenge.md), using the provided transformation [method](create-code-challenge.md). If the provided [method](create-code-challenge.md) is [CodeChallengeMethod.PLAIN](../-code-challenge-method/-p-l-a-i-n/index.md), then the [verifier](create-code-challenge.md) is simply returned, otherwise, if the provided [method](create-code-challenge.md) is [CodeChallengeMethod.S256](../-code-challenge-method/-s256/index.md), an SHA-256 hash opertaion is performed and the result is returned. |
| [generateCodeVerifier](generate-code-verifier.md) | [common]<br>fun [generateCodeVerifier](generate-code-verifier.md)(byteLength: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 32): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Generates a &quot;code_verifier&quot; specified in the PKCE protocol. This value is considered a secure key. |
| [isValid](is-valid.md) | [common]<br>suspend fun [isValid](is-valid.md)(verifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), challenge: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Verifies that the provided [verifier](is-valid.md) equals the provied [challenge](is-valid.md) after it is transformed using the provided [method](is-valid.md). Returns `true` if the values are equal, `false` otherwise. |
