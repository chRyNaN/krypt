# hash

Core components and utilities used for one-way hashing algorithms.

## SHA

To create a Secure Hash Function, [SHA](https://datatracker.ietf.org/doc/html/rfc4634), use one of the extension
functions on the `Hasher` object.

```kotlin
val hasher = Hasher.sha256()

val outputBytes = hasher(inputBytes)
```
