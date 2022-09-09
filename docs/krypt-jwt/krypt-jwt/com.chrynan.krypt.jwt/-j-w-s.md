//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[JWS](-j-w-s.md)

# JWS

[common]\
fun &lt;[H](-j-w-s.md) : [Header](-header/index.md), [P](-j-w-s.md) : [Payload](-payload/index.md)&gt; [JWS](-j-w-s.md)(header: [H](-j-w-s.md), payload: [P](-j-w-s.md), signature: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [DefaultJWS](-default-j-w-s/index.md)&lt;[H](-j-w-s.md), [P](-j-w-s.md)&gt;

Creates an instance of a [JWS](-j-w-s/index.md) with the provided [header](-j-w-s.md), [payload](-j-w-s.md), and signature. The returned type is [DefaultJWS](-default-j-w-s/index.md), which is an immutable data class.

Note that no validation is performed by this function when creating a [JWS](-j-w-s/index.md) instance.
