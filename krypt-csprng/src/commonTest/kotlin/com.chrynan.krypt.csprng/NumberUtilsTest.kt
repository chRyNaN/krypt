package com.chrynan.krypt.csprng

import kotlin.test.Test
import kotlin.test.assertEquals

class NumberUtilsTest {

    @Test
    fun bytesPerBitCount_returns_0_for_a_value_of_zero() {
        assertEquals(expected = 0, actual = 0.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_1_for_a_value_of_one() {
        assertEquals(expected = 1, actual = 1.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_1_for_a_value_of_7() {
        assertEquals(expected = 1, actual = 7.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_1_for_a_value_of_8() {
        assertEquals(expected = 1, actual = 8.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_2_for_a_value_of_9() {
        assertEquals(expected = 2, actual = 9.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_2_for_a_value_of_16() {
        assertEquals(expected = 2, actual = 16.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_3_for_a_value_of_17() {
        assertEquals(expected = 3, actual = 17.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_result_of_divide_8_for_0_remainder() {
        assertEquals(expected = 1, actual = 8.bytesPerBitCount())
    }

    @Test
    fun bytesPerBitCount_returns_result_of_divide_8_plus_1_for_non_0_remainder() {
        assertEquals(expected = 2, actual = 9.bytesPerBitCount())
    }
}
