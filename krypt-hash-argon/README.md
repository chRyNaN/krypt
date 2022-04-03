# argon

Argon2 hash function implementations. This module currently only targets the JVM and Android.

To obtain an `Argon2Hasher`:

```kotlin
val hasher = Hasher.argon2(type = Argon2Type.ID)
```

Then simply call the `hash` or `invoke` function to perform the hash on a provided value:

```kotlin
val result = hasher.hash(myStringInput)
```
