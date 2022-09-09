//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[SignatureAlgorithm](index.md)

# SignatureAlgorithm

[common]\
enum [SignatureAlgorithm](index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SignatureAlgorithm](index.md)&gt; 

Representation of standard JWT signature algorithm names as defined in the [JSON Web Algorithms Specification](https://tools.ietf.org/html/draft-ietf-jose-json-web-algorithms-31).

Note that this class was adapted from the open source [JJWT library](https://github.com/jwtk/jjwt/blob/master/api/src/main/java/io/jsonwebtoken/SignatureAlgorithm.java).

## See also

common

| | |
|---|---|
|  | [jjwt library](https://github.com/jwtk/jjwt/blob/master/api/src/main/java/io/jsonwebtoken/SignatureAlgorithm.java) |

## Parameters

common

| | |
|---|---|
| value | The JWA algorithm name constant. |
| description | The JWA algorithm description. |
| family | The cryptographic family name of the signature algorithm. |
| jcaName | The name of the JCA algorithm used to compute the signature. |
| jdkStandard | Returns `true` if the algorithm is supported by standard JDK distributions or `false` if the algorithm implementation is not in the JDK and must be provided by a separate runtime JCA Provider (like BouncyCastle for example). This is useful for the JVM platform. |
| minKeyLength | Returns the minimum key length in bits (not bytes) that may be used with this algorithm according to the [JWT JWA Specification (RFC 7518)](https://tools.ietf.org/html/rfc7518). |

## Entries

| | |
|---|---|
| [NONE](-n-o-n-e/index.md) | [common]<br>[NONE](-n-o-n-e/index.md)<br>JWA name for {@code No digital signature or MAC performed} |
| [HS256](-h-s256/index.md) | [common]<br>[HS256](-h-s256/index.md)<br>JWA algorithm name for {@code HMAC using SHA-256} |
| [HS384](-h-s384/index.md) | [common]<br>[HS384](-h-s384/index.md)<br>JWA algorithm name for {@code HMAC using SHA-384} |
| [HS512](-h-s512/index.md) | [common]<br>[HS512](-h-s512/index.md)<br>JWA algorithm name for {@code HMAC using SHA-512} |
| [RS256](-r-s256/index.md) | [common]<br>[RS256](-r-s256/index.md)<br>JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-256} |
| [RS384](-r-s384/index.md) | [common]<br>[RS384](-r-s384/index.md)<br>JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-384} |
| [RS512](-r-s512/index.md) | [common]<br>[RS512](-r-s512/index.md)<br>JWA algorithm name for {@code RSASSA-PKCS-v1_5 using SHA-512} |
| [ES256](-e-s256/index.md) | [common]<br>[ES256](-e-s256/index.md)<br>JWA algorithm name for {@code ECDSA using P-256 and SHA-256} |
| [ES384](-e-s384/index.md) | [common]<br>[ES384](-e-s384/index.md)<br>JWA algorithm name for {@code ECDSA using P-384 and SHA-384} |
| [ES512](-e-s512/index.md) | [common]<br>[ES512](-e-s512/index.md)<br>JWA algorithm name for {@code ECDSA using P-521 and SHA-512} |
| [PS256](-p-s256/index.md) | [common]<br>[PS256](-p-s256/index.md)<br>JWA algorithm name for {@code RSASSA-PSS using SHA-256 and MGF1 with SHA-256}.  <b>This algorithm requires Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or earlier, BouncyCastle will be used automatically if found in the runtime classpath. |
| [PS384](-p-s384/index.md) | [common]<br>[PS384](-p-s384/index.md)<br>JWA algorithm name for {@code RSASSA-PSS using SHA-384 and MGF1 with SHA-384}.  <b>This algorithm requires Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or earlier, BouncyCastle will be used automatically if found in the runtime classpath. |
| [PS512](-p-s512/index.md) | [common]<br>[PS512](-p-s512/index.md)<br>JWA algorithm name for {@code RSASSA-PSS using SHA-512 and MGF1 with SHA-512}. <b>This algorithm requires Java 11 or later or a JCA provider like BouncyCastle to be in the runtime classpath.</b>  If on Java 10 or earlier, BouncyCastle will be used automatically if found in the runtime classpath. |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Family](-family/index.md) | [common]<br>enum [Family](-family/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[SignatureAlgorithm.Family](-family/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [description](description.md) | [common]<br>val [description](description.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [digestLength](digest-length.md) | [common]<br>val [digestLength](digest-length.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [family](family.md) | [common]<br>val [family](family.md): [SignatureAlgorithm.Family](-family/index.md) |
| [jcaName](jca-name.md) | [common]<br>val [jcaName](jca-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [jdkStandard](jdk-standard.md) | [common]<br>val [jdkStandard](jdk-standard.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [minKeyLength](min-key-length.md) | [common]<br>val [minKeyLength](min-key-length.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [name](-p-s512/index.md#-372974862%2FProperties%2F1517416856) | [common]<br>val [name](-p-s512/index.md#-372974862%2FProperties%2F1517416856): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ordinal](-p-s512/index.md#-739389684%2FProperties%2F1517416856) | [common]<br>val [ordinal](-p-s512/index.md#-739389684%2FProperties%2F1517416856): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [pkcsName](pkcs-name.md) | [common]<br>val [pkcsName](pkcs-name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [value](value.md) | [common]<br>val [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Extensions

| Name | Summary |
|---|---|
| [isEllipticCurve](../is-elliptic-curve.md) | [common]<br>fun [SignatureAlgorithm](index.md).[isEllipticCurve](../is-elliptic-curve.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if the enum instance represents an Elliptic Curve ECDSA signature algorithm, `false` otherwise. |
| [isHmac](../is-hmac.md) | [common]<br>fun [SignatureAlgorithm](index.md).[isHmac](../is-hmac.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if the enum instance represents an HMAC signature algorithm, `false` otherwise. |
| [isRsa](../is-rsa.md) | [common]<br>fun [SignatureAlgorithm](index.md).[isRsa](../is-rsa.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns `true` if the enum instance represents an RSA public/private key pair signature algorithm, `false` otherwise. |
