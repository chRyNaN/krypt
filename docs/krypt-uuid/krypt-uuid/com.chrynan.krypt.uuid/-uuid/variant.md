//[krypt-uuid](../../../index.md)/[com.chrynan.krypt.uuid](../index.md)/[Uuid](index.md)/[variant](variant.md)

# variant

[common]\
val [variant](variant.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

The variant number of this [Uuid](index.md) instance. The [variant](variant.md) describes the layout of the UUID:

- 
   **0** - Reserved for NCS backward compatibility and a null UUID
- 
   **2** - Leach-Salz, as defined in [RFC 4122](https://tools.ietf.org/html/rfc4122) and used by this class
- 
   **6** - Reserved, Microsoft Corporation backward compatibility
- 
   **7** - Reserved for future definition
