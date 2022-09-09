//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[hash](hash.md)

# hash

[common]\
suspend fun &lt;[Input](hash.md), [Output](hash.md)&gt; [HashFunction](-hash-function/index.md)&lt;[Input](hash.md), [Output](hash.md)&gt;.[hash](hash.md)(source: [Input](hash.md)): [Output](hash.md)

A convenience function that delegates to the [invoke](invoke.md) function of the [HashFunction](-hash-function/index.md) interface. This is provided for preference, as it may be preferable to use &quot;hash&quot; instead of &quot;invoke&quot; at the call-site.
