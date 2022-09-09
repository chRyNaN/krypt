# krypt-uuid

Kotlin
multi-platform [Universally Unique Identifier (UUID)](https://en.wikipedia.org/wiki/Universally_unique_identifier)
utility. Currently, this module wraps the [uuid](https://github.com/benasher44/uuid) Kotlin multi-platform library, but
may eventually provide its own implementation. One of the reasons for providing a new UUID Kotlin multi-platform library
was opinionated views of the API, for instance, instead of exposing globally scoped constructor functions for UUIDs,
this library prefers those functions scoped to the UUID model.

Note that the [uuid](https://github.com/benasher44/uuid) library is licensed under
the [MIT License](https://github.com/benasher44/uuid/blob/master/LICENSE).
