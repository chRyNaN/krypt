@file:Suppress("unused")

package com.chrynan.krypt.hash.argon

enum class Argon2Type(val typeName: String) {

    I(typeName = "Argon2I"),
    D(typeName = "Argon2D"),
    ID(typeName = "Argon2ID")
}
