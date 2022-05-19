package com.chrynan.krypt.pkce

enum class CodeChallengeMethod(val typeName: String) {

    PLAIN(typeName = "plain"),
    S256(typeName = "S256");

    companion object {

        fun getByName(name: String, ignoreCase: Boolean): CodeChallengeMethod? =
            values().firstOrNull { it.typeName.equals(name, ignoreCase) }
    }
}
