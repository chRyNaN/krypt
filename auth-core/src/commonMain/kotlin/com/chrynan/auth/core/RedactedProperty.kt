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

class SimpleRedactedProperty<T>(public override val value: T) : RedactedProperty<T>()
