//[krypt-jwt](../../index.md)/[com.chrynan.krypt.jwt](index.md)/[JWT](-j-w-t.md)

# JWT

[common]\
fun &lt;[H](-j-w-t.md) : [Header](-header/index.md), [P](-j-w-t.md) : [Payload](-payload/index.md)&gt; [JWT](-j-w-t.md)(header: [H](-j-w-t.md), payload: [P](-j-w-t.md)): [DefaultJWT](-default-j-w-t/index.md)&lt;[H](-j-w-t.md), [P](-j-w-t.md)&gt;

Creates an instance of a [JWT](-j-w-t/index.md) with the provided [header](-j-w-t.md) and [payload](-j-w-t.md). The returned type is [DefaultJWT](-default-j-w-t/index.md), which is an immutable data class.

Note that no validation is performed by this function when creating a [JWT](-j-w-t/index.md) instance.
