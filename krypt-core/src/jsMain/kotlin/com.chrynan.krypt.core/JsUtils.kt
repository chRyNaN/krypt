package com.chrynan.krypt.core

fun isNodeJs(): Boolean =
    js("typeof process !== 'undefined' && process.versions != null && process.versions.node != null") as Boolean
