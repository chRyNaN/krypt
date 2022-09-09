//[krypt-uuid](../../../index.md)/[com.chrynan.krypt.uuid](../index.md)/[Uuid](index.md)/[version](version.md)

# version

[common]\
val [version](version.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The version number of this [Uuid](index.md) instance. The [version](version.md) specifies how this UUID was generated:

- 
   **0** - Special case for a null UUID
- 
   **1** - Time-based
- 
   **2** - DCE Security
- 
   **3** - Name-based using MD5 hashing
- 
   **4** - Random or Pseudo-random
- 
   **5** - Name-based using SHA-1 hashing
- 
   **6-15** - Reserved for future definition

Note that the version returned by this function is only meaningful if the [Uuid.variant](variant.md) is [RFC 4122](https://tools.ietf.org/html/rfc4122).
