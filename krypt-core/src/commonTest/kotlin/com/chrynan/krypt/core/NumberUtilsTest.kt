package com.chrynan.krypt.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class NumberUtilsTest {

    @Test
    fun byte_array_to_int_throws_exception_when_start_is_greater_than_end() {
        val bytes = ByteArray(4)

        assertFails {
            bytes.toInt(
                startInclusive = 1,
                endExclusive = 0
            )
        }
    }

    @Test
    fun byte_array_to_int_throws_exception_when_start_equals_end() {
        val bytes = ByteArray(4)

        assertFails {
            bytes.toInt(
                startInclusive = 1,
                endExclusive = 1
            )
        }
    }

    @Test
    fun byte_array_to_int_throws_exception_when_range_size_is_greater_than_four() {
        val bytes = ByteArray(6)

        assertFails {
            bytes.toInt(
                startInclusive = 0,
                endExclusive = 6
            )
        }
    }

    @Test
    fun byte_array_to_int_throws_exception_when_start_inclusive_is_out_of_range() {
        val bytes = ByteArray(4)

        assertFails {
            bytes.toInt(
                startInclusive = -1,
                endExclusive = 4
            )
        }
        assertFails {
            bytes.toInt(
                startInclusive = 5,
                endExclusive = 4
            )
        }
    }

    @Test
    fun byte_array_to_int_throws_exception_when_end_exclusive_is_out_of_range() {
        val bytes = ByteArray(4)

        assertFails {
            bytes.toInt(
                startInclusive = 0,
                endExclusive = -1
            )
        }
        assertFails {
            bytes.toInt(
                startInclusive = 0,
                endExclusive = 6
            )
        }
    }

    @Test
    fun conversion_between_int_and_byte_array_works_for_min_int() {
        val value = Int.MIN_VALUE

        val bytesInBigEndian = value.toByteArray(order = Endian.Big)
        val bytesInLittleEndian = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = value,
            actual = bytesInBigEndian.toInt(order = Endian.Big)
        )
        assertEquals(
            expected = value,
            actual = bytesInLittleEndian.toInt(order = Endian.Little)
        )
    }

    @Test
    fun conversion_between_int_and_byte_array_works_for_max_int() {
        val value = Int.MAX_VALUE

        val bytesInBigEndian = value.toByteArray(order = Endian.Big)
        val bytesInLittleEndian = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = value,
            actual = bytesInBigEndian.toInt(order = Endian.Big)
        )
        assertEquals(
            expected = value,
            actual = bytesInLittleEndian.toInt(order = Endian.Little)
        )
    }

    @Test
    fun int_to_byte_array_converts_values_to_expected_format_for_big_endian() {
        val value = Int.MAX_VALUE

        val bytes = value.toByteArray(order = Endian.Big)

        assertEquals(
            expected = ((value shr 24) and 0xFF).toByte(),
            actual = bytes[0]
        )
        assertEquals(
            expected = ((value shr 16) and 0xFF).toByte(),
            actual = bytes[1]
        )
        assertEquals(
            expected = ((value shr 8) and 0xFF).toByte(),
            actual = bytes[2]
        )
        assertEquals(
            expected = (value and 0xFF).toByte(),
            actual = bytes[3]
        )
    }

    @Test
    fun int_to_byte_array_converts_values_to_expected_format_for_little_endian() {
        val value = Int.MAX_VALUE

        val bytes = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = (value and 0xFF).toByte(),
            actual = bytes[0]
        )
        assertEquals(
            expected = ((value shr 8) and 0xFF).toByte(),
            actual = bytes[1]
        )
        assertEquals(
            expected = ((value shr 16) and 0xFF).toByte(),
            actual = bytes[2]
        )
        assertEquals(
            expected = ((value shr 24) and 0xFF).toByte(),
            actual = bytes[3]
        )
    }

    @Test
    fun byte_array_to_long_throws_exception_when_start_is_greater_than_end() {
        val bytes = ByteArray(8)

        assertFails {
            bytes.toLong(
                startInclusive = 1,
                endExclusive = 0
            )
        }
    }

    @Test
    fun byte_array_to_long_throws_exception_when_start_equals_end() {
        val bytes = ByteArray(8)

        assertFails {
            bytes.toLong(
                startInclusive = 1,
                endExclusive = 1
            )
        }
    }

    @Test
    fun byte_array_to_long_throws_exception_when_range_size_is_greater_than_eight() {
        val bytes = ByteArray(8)

        assertFails {
            bytes.toLong(
                startInclusive = 0,
                endExclusive = 9
            )
        }
    }

    @Test
    fun byte_array_to_long_throws_exception_when_start_inclusive_is_out_of_range() {
        val bytes = ByteArray(8)

        assertFails {
            bytes.toInt(
                startInclusive = -1,
                endExclusive = 4
            )
        }
        assertFails {
            bytes.toInt(
                startInclusive = 8,
                endExclusive = 4
            )
        }
    }

    @Test
    fun byte_array_to_long_throws_exception_when_end_exclusive_is_out_of_range() {
        val bytes = ByteArray(8)

        assertFails {
            bytes.toInt(
                startInclusive = 0,
                endExclusive = -1
            )
        }
        assertFails {
            bytes.toInt(
                startInclusive = 0,
                endExclusive = 9
            )
        }
    }

    @Test
    fun conversion_between_long_and_byte_array_works_for_min_long() {
        val value = Long.MIN_VALUE

        val bytesInBigEndian = value.toByteArray(order = Endian.Big)
        val bytesInLittleEndian = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = value,
            actual = bytesInBigEndian.toLong(order = Endian.Big)
        )
        assertEquals(
            expected = value,
            actual = bytesInLittleEndian.toLong(order = Endian.Little)
        )
    }

    @Test
    fun conversion_between_long_and_byte_array_works_for_max_long() {
        val value = Long.MAX_VALUE

        val bytesInBigEndian = value.toByteArray(order = Endian.Big)
        val bytesInLittleEndian = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = value,
            actual = bytesInBigEndian.toLong(order = Endian.Big)
        )
        assertEquals(
            expected = value,
            actual = bytesInLittleEndian.toLong(order = Endian.Little)
        )
    }

    @Test
    fun long_to_byte_array_converts_values_to_expected_format_for_big_endian() {
        val value = Long.MAX_VALUE

        val bytes = value.toByteArray(order = Endian.Big)

        assertEquals(
            expected = ((value shr 56) and 0xFF).toByte(),
            actual = bytes[0]
        )
        assertEquals(
            expected = ((value shr 48) and 0xFF).toByte(),
            actual = bytes[1]
        )
        assertEquals(
            expected = ((value shr 40) and 0xFF).toByte(),
            actual = bytes[2]
        )
        assertEquals(
            expected = ((value shr 32) and 0xFF).toByte(),
            actual = bytes[3]
        )
        assertEquals(
            expected = ((value shr 24) and 0xFF).toByte(),
            actual = bytes[4]
        )
        assertEquals(
            expected = ((value shr 16) and 0xFF).toByte(),
            actual = bytes[5]
        )
        assertEquals(
            expected = ((value shr 8) and 0xFF).toByte(),
            actual = bytes[6]
        )
        assertEquals(
            expected = (value and 0xFF).toByte(),
            actual = bytes[7]
        )
    }

    @Test
    fun long_to_byte_array_converts_values_to_expected_format_for_little_endian() {
        val value = Long.MAX_VALUE

        val bytes = value.toByteArray(order = Endian.Little)

        assertEquals(
            expected = (value and 0xFF).toByte(),
            actual = bytes[0]
        )
        assertEquals(
            expected = ((value shr 8) and 0xFF).toByte(),
            actual = bytes[1]
        )
        assertEquals(
            expected = ((value shr 16) and 0xFF).toByte(),
            actual = bytes[2]
        )
        assertEquals(
            expected = ((value shr 24) and 0xFF).toByte(),
            actual = bytes[3]
        )
        assertEquals(
            expected = ((value shr 32) and 0xFF).toByte(),
            actual = bytes[4]
        )
        assertEquals(
            expected = ((value shr 40) and 0xFF).toByte(),
            actual = bytes[5]
        )
        assertEquals(
            expected = ((value shr 48) and 0xFF).toByte(),
            actual = bytes[6]
        )
        assertEquals(
            expected = ((value shr 56) and 0xFF).toByte(),
            actual = bytes[7]
        )
    }
}
