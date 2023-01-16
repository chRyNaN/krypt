//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[compact](compact.md)

# compact

[common]\
fun &lt;[H](compact.md) : [Header](-header/index.md), [P](compact.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](compact.md), [P](compact.md)&gt;.[compact](compact.md)(json: Json = Json, headerSerializer: KSerializer&lt;[H](compact.md)&gt;, payloadSerializer: KSerializer&lt;[P](compact.md)&gt;, encoder: [Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

A convenience function for invoking the [JWT.format](-j-w-t/format.md) function. The &quot;compact&quot; name is used in other JWT library implementations, and IIRC the specification itself, but I prefer the &quot;format&quot; name, so I include both for personal preference.

[common]\
inline fun &lt;[H](compact.md) : [Header](-header/index.md), [P](compact.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t/index.md)&lt;[H](compact.md), [P](compact.md)&gt;.[compact](compact.md)(json: Json = Json, encoder: [Encoder](../../../krypt-encoding/krypt-encoding/com.chrynan.krypt.encoding/-encoder/index.md) = Base64UrlEncoder()): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

A convenience function for invoking the [format](format.md) function. The &quot;compact&quot; name is used in other JWT library implementations, and IIRC the specification itself, but I prefer the &quot;format&quot; name, so I include both for personal preference.
