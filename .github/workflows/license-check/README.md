# License Check

The license check script is a basic bash script that consumes the output from maven license checks, and throws errors if any are found that are not in specified whitelists.

## Pre-requisite Maven commands

The following two maven commands, executed in the root of the project, will generate license files in the target locations: `target/generated-sources/license/THIRD-PARTY.txt` 

This command will generate all the license files for each module:

```shell
mvn license:add-third-party
```

This command will generate all the license files for the whole project (must be run after the first command, or it will have no licenses to aggregate):

```shell
mvn license:aggregate-add-third-party
```

## Bash script

From the root of the project, execute the following:

```shell
./.github/workflows/license-check/license-check.sh 
```

Note that this requires a recent version of bash.

## Whitelists

Whitelists are license names permitted for use within this project. This project uses an Apache 2.0 license. and follows the rule that a selection of dependencies with copyleft licenses can be included in the project as binaries, but shouldn't appear in the source release. https://www.apache.org/legal/resolved.html#weak-copyleft-licenses

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

There are two Whitelist files, necessitated by the sometimes inconsistent formatting of `THIRD-PARTY.txt`.

`license-whitelist.txt` contains individual licenses that are permitted in the project. Note that these are repeated in multiple formats, as these are a strict string match, and licenses names do not have a single canonical text representation (example: 'Apache Software License 2.0',
'The Apache License, Version 2.0',
'The Apache Software License, Version 2.0')

'license-special-cases.txt' contains entire lines from the `THIRD-PARTY.txt` to account for cases where the license name itself may be problematic to whitelist, such as `(Unknown License)`:

```text
# Is not included in the dependency but is GNU Lesser GPL. See: https://code.google.com/archive/p/javaparser/
(Unknown license) javaparser (com.google.code.javaparser:javaparser:1.0.11 - http://code.google.com/p/javaparser/)
```

Note that for each of these there should be an explicit reason for the special case in a comment, to prevent unnecessarily re-evaluating of special cases.