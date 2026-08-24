# License Check

This project uses the `org.codehaus.mojo:license-maven-plugin` (configured via the `LICENSE_CHECK` Maven profile
in the root `pom.xml`) to enforce that every compile/runtime dependency's declared license is one this project is
allowed to redistribute.

## Running it locally

From the root of the project:

```shell
mvn clean install -DskipTests
mvn -PLICENSE_CHECK license:aggregate-add-third-party
```

The first command installs all reactor modules so the aggregate goal can resolve them. The second collects the
licenses of every module's dependencies, writes them to `target/generated-sources/license/THIRD-PARTY.txt`, and
fails the build (`There are N forbidden licenses used:`) if any dependency's license is not in the allowlist below.

Only `compile` and `runtime` scoped dependencies are checked; `test` and `provided` dependencies are ignored.

## Policy

Whitelists are license names permitted for use within this project. This project uses an Apache 2.0 license, and
follows the rule that a selection of dependencies with copyleft licenses can be included in the project as
binaries, but shouldn't appear in the source release. https://www.apache.org/legal/resolved.html#weak-copyleft-licenses

This list includes:

* Common Development and Distribution Licenses: CDDL 1.0 and CDDL 1.1
* Common Public License: CPL 1.0
* Eclipse Public License: EPL 1.0
* IBM Public License: IPL 1.0
* Mozilla Public Licenses: MPL 1.0, MPL 1.1, and MPL 2.0
* Sun Public License: SPL 1.0
* Open Software License 3.0
* Erlang Public License
* UnRAR License (only for unarchiving)
* SIL Open Font License
* Ubuntu Font License Version 1.0
* IPA Font License Agreement v1.0
* Ruby License (including the older version when GPLv2 was a listed alternative Ruby 1.9.2 license)
* Eclipse Public License 2.0: EPL 2.0

## Allowlist

The allowlist is the `<includedLicenses>` block of the `LICENSE_CHECK` profile in the root `pom.xml`. It's a flat
list of license name strings, repeated in multiple spellings, because license names in a dependency's POM don't
have a single canonical text representation (example: `Apache Software License 2.0`, `The Apache License, Version
2.0`, `The Apache Software License, Version 2.0`) and the plugin matches by exact string equality.

Dependencies that declare more than one license (e.g. `(EPL-2.0) (LGPL-2.1-only) Logback Classic Module`) pass
automatically as soon as **any one** of their licenses is on the allowlist — no override entry is needed for these.

## Overrides

`src/license/override-THIRD-PARTY.properties` overrides the license the plugin uses for a specific dependency
version, for cases the allowlist can't handle on its own: a dependency with no license declared in its POM, or a
single (non dual-licensed) dependency whose exact license string isn't in the allowlist despite being an
acceptable license. This file's path is the plugin's own default (`src/license/override-THIRD-PARTY.properties`
resolved against `${basedir}`), so the `LICENSE_CHECK` profile does not need to configure `overrideFile`/`overrideUrl`
explicitly.

Format: `groupId--artifactId--version=License Name`, where `License Name` should be a name already present in the
allowlist above.

Every entry must have a comment immediately above it giving an explicit reason, to prevent unnecessarily
re-evaluating overrides on review, e.g.:

```properties
# No license declared in the pom. Is GNU Lesser GPL. See: https://code.google.com/archive/p/javaparser/
com.google.code.javaparser--javaparser--1.0.11=GNU Lesser General Public License
```

Because overrides are keyed by exact version, bumping a dependency's version drops its override — if the new
version still lacks a resolvable license, the check will fail with `failOnMissing` until the entry is updated.
Several exemptions from before this check was ported no longer matched a dependency actually in the tree (either
because the version changed, or the dependency was removed entirely) — check first whether an override is really
needed before adding one, and remove it once the dependency it names is gone.
