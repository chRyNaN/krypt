package com.chrynan.krypt.jwt

internal fun SignatureAlgorithm.toAndroidSignatureAlgorithm(): io.jsonwebtoken.SignatureAlgorithm =
    when (this) {
        SignatureAlgorithm.HS256 -> io.jsonwebtoken.SignatureAlgorithm.HS256
        SignatureAlgorithm.HS384 -> io.jsonwebtoken.SignatureAlgorithm.HS384
        SignatureAlgorithm.HS512 -> io.jsonwebtoken.SignatureAlgorithm.HS512
        SignatureAlgorithm.RS256 -> io.jsonwebtoken.SignatureAlgorithm.RS256
        SignatureAlgorithm.RS384 -> io.jsonwebtoken.SignatureAlgorithm.RS384
        SignatureAlgorithm.RS512 -> io.jsonwebtoken.SignatureAlgorithm.RS512
        SignatureAlgorithm.ES256 -> io.jsonwebtoken.SignatureAlgorithm.ES256
        SignatureAlgorithm.ES384 -> io.jsonwebtoken.SignatureAlgorithm.ES384
        SignatureAlgorithm.ES512 -> io.jsonwebtoken.SignatureAlgorithm.ES512
        SignatureAlgorithm.PS256 -> io.jsonwebtoken.SignatureAlgorithm.PS256
        SignatureAlgorithm.PS384 -> io.jsonwebtoken.SignatureAlgorithm.PS384
        SignatureAlgorithm.PS512 -> io.jsonwebtoken.SignatureAlgorithm.PS512
        SignatureAlgorithm.NONE -> io.jsonwebtoken.SignatureAlgorithm.NONE
    }
