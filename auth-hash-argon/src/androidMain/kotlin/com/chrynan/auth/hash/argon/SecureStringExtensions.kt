package com.chrynan.auth.hash.argon

import com.chrynan.auth.core.SecureString

fun SecureString.toJavaSecureString(eraseSource: Boolean = true): com.password4j.SecureString {
    val tempCharArray = CharArray(this.length)

    for (i in this.indices) {
        tempCharArray[i] = this[i]
    }

    val javaSecureString = com.password4j.SecureString(tempCharArray, true)

    if (eraseSource) {
        this.clear()
    }

    return javaSecureString
}
