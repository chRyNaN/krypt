# csprng (Cryptographically strong psuedo-random number generator)

This module provides the `SecureRandom` class which is a CSPRNG implementation. The implementation of the class depends
on the target platform, for instance, on the JVM and Android targets,
the [java.security.SecureRandom class](https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html) is
used. This `SecureRandom` class implements the `kotlin.random.Random` abstract class, making it interoperable with
existing utilities.

To obtain a `SecureRandom` simply use the available constructor:

```kotlin
val secureRandom = SecureRandom()
```

Then the object can be used just like a `kotlin.random.Random` instance, or one of the extra extension functions could
be used:

```kotlin
val randomInt = secureRandom.nextInt()
val randomString = secureRandom.nextString(length = 64)
val randomSalt = secureRandom.nextSalt()
```
