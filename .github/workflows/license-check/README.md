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

There are two Whitelist files, necessitated by the sometimes inconsistent formatting of `THIRD-PARTY.txt`.

`license-whitelist.txt` contains individual licenses that are permitted in the project. Note that these are repeated in multiple formats, as these are a strict string match, and licenses names do not have a single canonical format (example: 'Apache Software License 2.0',
'The Apache License, Version 2.0',
'The Apache Software License, Version 2.0')

'license-special-cases.txt' contains entire lines from the `THIRD-PARTY.txt` to account for cases where the license name itself may be problematic to whitelist, such as `(Unknown License)`:

```text
# Is not included in the dependency but is GNU Lesser GPL. See: https://code.google.com/archive/p/javaparser/
(Unknown license) javaparser (com.google.code.javaparser:javaparser:1.0.11 - http://code.google.com/p/javaparser/)
```

Note that for each of these there should be an explicit reason for the special case in a comment, or else we may end up re-evaluating special cases further down the road.