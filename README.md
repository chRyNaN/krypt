# krypt

Kotlin multi-platform cryptographic utility library. <br/>
<img alt="GitHub tag (latest by date)" src="https://img.shields.io/github/v/tag/chRyNaN/krypt">

## Usage

This library provides independent modules that handle specific cryptographic tasks. For instance,
the [krypt-csprng](krypt-csprng) module provides a `SecureRandom` implementation which is a cryptographically strong
psuedo-random number generator. Each module contains a `README` file with more information on usage.

## Building

The library is provided through [Repsy.io](https://repsy.io/). Checkout
the [releases page](https://github.com/chRyNaN/krypt/releases) to get the latest version.

### Repository

```kotlin
repositories {
    maven { url = uri("https://repo.repsy.io/mvn/chrynan/public") }
}
```

### Dependencies

#### ore:

```kotlin
implementation("com.chrynan.krypt:krypt-core:$VERSION")
```

#### csprng:

```kotlin
implementation("com.chrynan.krypt:krypt-csprng:$VERSION")
```

#### encoding:

```kotlin
implementation("com.chrynan.krypt:krypt-encoding:$VERSION")
```

#### hash:

```kotlin
implementation("com.chrynan.krypt:krypt-hash:$VERSION")
```

#### hash-argon:

```kotlin
implementation("com.chrynan.krypt:krypt-hash-argon:$VERSION")
```

#### hash-sha:

```kotlin
implementation("com.chrynan.krypt:krypt-hash-sha:$VERSION")
```

#### srp:

```kotlin
implementation("com.chrynan.krypt:krypt-srp:$VERSION")
```

## Status

This project is in early development stages and is not yet considered production ready.

## Documentation

More detailed documentation is available in the [docs](docs) folder. The entry point to the documentation can be
found [here](docs/index.md).

## Security

For security vulnerabilities, concerns, or issues, please responsibly disclose the information either by opening a
public GitHub Issue or reaching out to the project owner.

## License

```
Copyright 2022 chRyNaN

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
