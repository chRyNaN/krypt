//[krypt-pkce](../../../index.md)/[com.chrynan.krypt.pkce](../index.md)/[Pkce](index.md)/[createCodeChallenge](create-code-challenge.md)

# createCodeChallenge

[common]\
suspend fun [createCodeChallenge](create-code-challenge.md)(verifier: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), method: [CodeChallengeMethod](../-code-challenge-method/index.md) = CodeChallengeMethod.S256): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Creates a &quot;code_challenge&quot;, specified in the PKCE protocol, from the provided [verifier](create-code-challenge.md), using the provided transformation [method](create-code-challenge.md). If the provided [method](create-code-challenge.md) is [CodeChallengeMethod.PLAIN](../-code-challenge-method/-p-l-a-i-n/index.md), then the [verifier](create-code-challenge.md) is simply returned, otherwise, if the provided [method](create-code-challenge.md) is [CodeChallengeMethod.S256](../-code-challenge-method/-s256/index.md), an SHA-256 hash opertaion is performed and the result is returned.

## See also

common

| | |
|---|---|
|  | [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.2) |
