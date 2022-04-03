package com.chrynan.krypt.encoding

internal fun Base64Type.toAndroidType(isWithPadding: Boolean = true): Int =
    when {
        !isWithPadding -> android.util.Base64.NO_PADDING
        this == Base64Type.URL -> android.util.Base64.URL_SAFE
        else -> android.util.Base64.DEFAULT
    }
