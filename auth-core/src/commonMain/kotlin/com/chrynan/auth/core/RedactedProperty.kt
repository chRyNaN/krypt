package com.chrynan.auth.core

/**
 * A wrapper class for any type that needs to be redacted when calling toString so that it doesn't output sensitive
 * data.
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

abstract class PublicRedactedProperty<T>(
    redactedString: String = "█",
    repeatCount: Int = 3
) : RedactedProperty<T>(
    redactedString = redactedString,
    repeatCount = repeatCount
) {

    public abstract override val value: T
}

class SimpleRedactedProperty<T>(override val value: T) : PublicRedactedProperty<T>()
