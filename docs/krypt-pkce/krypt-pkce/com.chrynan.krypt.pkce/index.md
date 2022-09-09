//[krypt-pkce](../../index.md)/[com.chrynan.krypt.pkce](index.md)

# Package com.chrynan.krypt.pkce

## Types

| Name | Summary |
|---|---|
| [CodeChallengeMethod](-code-challenge-method/index.md) | [common]<br>enum [CodeChallengeMethod](-code-challenge-method/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[CodeChallengeMethod](-code-challenge-method/index.md)&gt; <br>Represents the supported transformation methods in the PKCE protocol. Currently, the only supported methods are [PLAIN](-code-challenge-method/-p-l-a-i-n/index.md) and [S256](-code-challenge-method/-s256/index.md). The [PLAIN](-code-challenge-method/-p-l-a-i-n/index.md) method performs no operation, while the [S256](-code-challenge-method/-s256/index.md) performs an SHA-256 hash. |
| [Pkce](-pkce/index.md) | [common]<br>class [Pkce](-pkce/index.md)(base64Encoder: [Base64Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-base64-encoder/index.md) = Base64UrlEncoder(isWithPadding = false), random: [SecureRandom](../../../krypt-csprng/krypt-csprng/com.chrynan.krypt.csprng/-secure-random/index.md) = SecureRandom())<br>A class implementing the Proof Key for Code Exchange (PKCE, pronounced &quot;pixy&quot;), [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636), protocol. This class contains functions that can be used to perform the protocol. However, note that the communication of the values between the parties involved is not handled by this class and must be handled out-of-band. |
