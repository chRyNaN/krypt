//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[generate](generate.md)

# generate

[common]\
suspend fun &lt;[K](generate.md) : [Key](-key/index.md)&gt; [KeyGenerator](-key-generator/index.md)&lt;[K](generate.md)&gt;.[generate](generate.md)(): [K](generate.md)

A convenience function that calls the [KeyGenerator.invoke](-key-generator/invoke.md) function. Which function is used is up to preference.

[common]\
suspend fun &lt;[PublicKey](generate.md), [PrivateKey](generate.md)&gt; [KeyPairGenerator](-key-pair-generator/index.md)&lt;[PublicKey](generate.md), [PrivateKey](generate.md)&gt;.[generate](generate.md)(): [KeyPair](-key-pair/index.md)&lt;[PublicKey](generate.md), [PrivateKey](generate.md)&gt;

A convenience function that calls the [invoke](invoke.md) function. Which function is used is up to preference.
