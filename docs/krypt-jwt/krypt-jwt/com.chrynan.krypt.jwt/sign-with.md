//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[signWith](sign-with.md)

# signWith

[common]\
suspend fun &lt;[H](sign-with.md) : [Header](-header/index.md), [P](sign-with.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;.[signWith](sign-with.md)(key: [Key](../../../krypt-core/krypt-core/com.chrynan.krypt.core/-key/index.md), algorithm: [SignatureAlgorithm](-signature-algorithm/index.md)): [JWS](-j-w-s/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;

suspend fun &lt;[H](sign-with.md) : [Header](-header/index.md), [P](sign-with.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;.[signWith](sign-with.md)(key: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), algorithm: [SignatureAlgorithm](-signature-algorithm/index.md)): [JWS](-j-w-s/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;

suspend fun &lt;[H](sign-with.md) : [Header](-header/index.md), [P](sign-with.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;.[signWith](sign-with.md)(signer: suspend (jwt: [JWT](-j-w-t/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;) -&gt; [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [JWS](-j-w-s/index.md)&lt;[H](sign-with.md), [P](sign-with.md)&gt;
