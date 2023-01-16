//[krypt-core](../../index.md)/[com.chrynan.krypt.core](index.md)/[HashFunction](-hash-function.md)

# HashFunction

[common]\
fun &lt;[Input](-hash-function.md), [Output](-hash-function.md)&gt; [HashFunction](-hash-function.md)(algorithmName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, hash: suspend (source: [Input](-hash-function.md)) -&gt; [Output](-hash-function.md)): [HashFunction](-hash-function/index.md)&lt;[Input](-hash-function.md), [Output](-hash-function.md)&gt;

Creates a [HashFunction](-hash-function/index.md) implementation using the provided [algorithmName](-hash-function.md) and [hash](-hash-function.md) function block.
