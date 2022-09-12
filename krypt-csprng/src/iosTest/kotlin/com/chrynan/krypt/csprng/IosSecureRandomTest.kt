package com.chrynan.krypt.csprng

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class IosSecureRandomTest {
    @Test
    fun `SecureRandom returns a value on iOS`() {
        val bytes = SecureRandom().nextBytes(32)
        assertNotNull(bytes)
        assertEquals(32, bytes.size)
    }
}
