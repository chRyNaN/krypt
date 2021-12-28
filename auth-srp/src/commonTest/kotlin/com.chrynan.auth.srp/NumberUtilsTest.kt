package com.chrynan.auth.srp

import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalUnsignedTypes::class)
class NumberUtilsTest {

    @Test
    fun ubytearray_clear_replaces_all_values_in_the_array() {
        val array = ubyteArrayOf(0u, 1u, 2u, 3u, 4u, 5u, 6u, 7u, 8u, 9u, 10u)
        val size = array.size

        array.clear(value = 0u)

        assertEquals(expected = size, actual = array.size)

        array.forEach {
            assertEquals(expected = 0u, actual = it)
        }

        array.clear(value = 1u)

        assertEquals(expected = size, actual = array.size)

        array.forEach {
            assertEquals(expected = 1u, actual = it)
        }
    }
}
