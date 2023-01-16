//[krypt-jwt](../../../index.md)/[com.chrynan.krypt.jwt](../index.md)/[SignatureAlgorithm](index.md)/[jdkStandard](jdk-standard.md)

# jdkStandard

[common]\
val [jdkStandard](jdk-standard.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

#### Parameters

common

| | |
|---|---|
| jdkStandard | Returns `true` if the algorithm is supported by standard JDK distributions or `false` if the algorithm implementation is not in the JDK and must be provided by a separate runtime JCA Provider (like BouncyCastle for example). This is useful for the JVM platform. |
