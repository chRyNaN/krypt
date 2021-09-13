package com.chrynan.auth.core

@Suppress("FunctionName")
expect fun AlphaNumericKeyGenerator(bitCount: Int = 128): KeyGenerator
