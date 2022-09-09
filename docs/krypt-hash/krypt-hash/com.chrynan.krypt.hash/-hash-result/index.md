//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[HashResult](index.md)

# HashResult

[common]\
interface [HashResult](index.md)&lt;[Algorithm](index.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Hash](index.md)&gt;

Represents the result of a [HashEncoder](../-hash-encoder/index.md). This result interface contains the [hash](hash.md) and the [algorithm](algorithm.md) information.

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [Algorithm](index.md) |
| [hash](hash.md) | [common]<br>abstract val [hash](hash.md): [Hash](index.md) |

## Inheritors

| Name |
|---|
| [PBKDF2HashResult](../../com.chrynan.krypt.hash.pbkdf/-p-b-k-d-f2-hash-result/index.md) |
| [SHA2HashResult](../../com.chrynan.krypt.hash.sha/-s-h-a2-hash-result/index.md) |
