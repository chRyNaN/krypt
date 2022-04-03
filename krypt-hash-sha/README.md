# SHA

SHA hash function implementations.

To obtain a `SHAHasher`:

```kotlin
val hasher = SHAHasher.sha256(outputFormat = SHAOutputFormat.UTF_8)
```

Then simply call the `hash` or `invoke` function to perform the hash on a provided value:

```kotlin
val result = hasher.hash(myStringInput)
```
