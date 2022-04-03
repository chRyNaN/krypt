package com.chrynan.auth.core

/**
 * A wrapper class for any type that needs to be redacted when calling toString so that it doesn't output sensitive
 * data. Note that the underlying [value] can still be accessed and any direct call to toString on that property will
 * not be redacted.
 */
abstract class RedactedProperty<T>(
    private val redactedString: String = "█",
    private val repeatCount: Int = 3
) {

    protected abstract val value: T

    override fun equals(other: Any?): Boolean {
        if (other !is RedactedProperty<*>) return false

        return value == other.value
    }

    override fun hashCode(): Int = value.hashCode()

    final override fun toString(): String = buildString {
        if (repeatCount <= 0) {
            append("")
        } else {
            for (i in 0 until repeatCount) {
                append(redactedString)
            }
        }
    }

    companion object
}

/**
 * A [RedactedProperty] that allows for the underlying [value] to be accessed publicly.
 */
class PublicRedactedProperty<T>(
    override val value: T,
    redactedString: String = "█",
    repeatCount: Int = 3
) : RedactedProperty<T>(
    redactedString = redactedString,
    repeatCount = repeatCount
)
