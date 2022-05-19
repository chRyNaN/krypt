package com.chrynan.krypt.pkce

/**
 * Represents the supported transformation methods in the PKCE protocol. Currently, the only supported methods are
 * [PLAIN] and [S256]. The [PLAIN] method performs no operation, while the [S256] performs an SHA-256 hash.
 */
enum class CodeChallengeMethod(val typeName: String) {

    PLAIN(typeName = "plain"),
    S256(typeName = "S256");

    companion object {

        /**
         * Retrieves the [CodeChallengeMethod] from the provided [name], or `null` if a match did not occur.
         */
        fun getByName(name: String, ignoreCase: Boolean): CodeChallengeMethod? =
            values().firstOrNull { it.typeName.equals(name, ignoreCase) }
    }
}
