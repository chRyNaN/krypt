# PKCE - Proof Key for Code Exchange

Proof Key for Code Exchange (PKCE, pronounced "pixy")
, [RFC-7636](https://datatracker.ietf.org/doc/html/rfc7636#section-4.1), is a cryptographic challenge protocol used to
mitigate issues with the OAuth 2.0 specification. In particular, it prevents an attacker from intercepting an
authorization code from a redirect URI on a public client, such as a smartphone, and using it to obtain an access token
from an OAuth 2.0 compliant authorization server.

The protocol defines a way for a client to generate a cryptographically secure key ("code_verifier"), and transform it
into a challenge ("code_challenge") which is sent to the authorization server, along with the transformation method, in
the authorization code request. When the client obtains the authorization code, it will send it along with the key ("
code_verifier"). The server then transforms the key, using the previously provided transformation method, and compares
it with the previously provided challenge value ("code_challenge"). If the values are equal then the server can provide
the client the access token, otherwise an error is returned as the client cannot be trusted. These values are generated
for every authorization code request.

This module provides Kotlin multi-platform utilities to easily support and extend this protocol.

## Usage

TBD
