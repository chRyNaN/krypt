//[krypt-hash](../../../index.md)/[com.chrynan.krypt.hash](../index.md)/[HashEncoder](index.md)

# HashEncoder

[common]\
interface [HashEncoder](index.md)&lt;[Algorithm](index.md) : [HashAlgorithm](../-hash-algorithm/index.md), [Input](index.md), [Hash](index.md), [Result](index.md) : [HashResult](../-hash-result/index.md)&lt;[Algorithm](index.md), [Hash](index.md)&gt;&gt; : [HashFunction](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md)&lt;[Input](index.md), [Result](index.md)&gt; 

A [HashFunction](../../../../krypt-core/krypt-core/com.chrynan.krypt.core/-hash-function/index.md) that works for the defined [Algorithm](index.md), takes in an input of type [Input](index.md), and returns a [Result](index.md) containing the resulting hash value and its related [Algorithm](index.md) information for ease of use.

## Functions

| Name | Summary |
|---|---|
| [invoke](../-hasher/index.md#1807890646%2FFunctions%2F-1850566401) | [common]<br>abstract suspend operator fun [invoke](../-hasher/index.md#1807890646%2FFunctions%2F-1850566401)(source: [Input](index.md)): [Result](index.md) |

## Properties

| Name | Summary |
|---|---|
| [algorithm](algorithm.md) | [common]<br>abstract val [algorithm](algorithm.md): [Algorithm](index.md)<br>The algorithm this [HashEncoder](index.md) uses. |

## Inheritors

| Name |
|---|
| [Hasher](../-hasher/index.md) |
