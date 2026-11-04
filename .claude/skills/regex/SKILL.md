---
name: regex
description: Uses locally installed regex tools to test regular expressions for common issues such as catastrophic backtracking. Use when a regex is mentioned in a prompt or modified in the current branch.
---

# Regex Skill

Regexes need to be both safe and correct. They should not be vulnerable to catastrophic backtracking, and care should be taken to ensure that if they need to match entire strings, they are designed to match the entire string. Several useful tools for this are included in the subsections of this skill.

## OpenSSF guide

The following guide should be used to evaluate regular expressions from a security standpoint: https://best.openssf.org/Correctly-Using-Regular-Expressions

## Owasp description of Catastrophic Backtracking

The following guide should be used to evaluate regular expressions for catastrophic backtracking:
https://owasp.org/www-community/attacks/Regular_expression_Denial_of_Service_-_ReDoS

## safe-regex2 command line

Use the following command line command to evaluate a regex for possible catastrophic backtracking:

```shell
npx safe-regex2 'myregex'
```

Note that the safe-regex2 tool has the following warning, and keep it in mind when using it:

```
WARNING: This module has both false positives and false negatives. It is not meant as a full checker, but it detects basic cases.
```

## safe_regex.xml

[safe_regex.xml](./safe_regex.xml) contains a list of regexes that are known to be safe from catastrophic backtracking that can be used for some common validation purposes.

These were sourced from https://owasp.org/www-community/OWASP_Validation_Regex_Repository. If the user asks, compare this file with that page and suggest updates.

## SonarQube rule for catastrophic backtracking

SonarQube evaluates regexs using the following project: https://github.com/SonarSource/sonar-java/ 

In particular, the logic in java-checks/src/main/java/org/sonar/java/checks/regex/RegexStackOverflowCheck.java is used to evaluate if a regex is potentially vulnerable.

## Java-specific checks in this repo

- Prefer the existing `org.hl7.fhir.utilities.regex.RegexTimeout` helper when evaluating a regex that comes from user content, such as a CodeSystem or profile. Check whether the timeout applies per call, and how many times the regex is evaluated per input.
- `String.split(regex)` drops trailing empty strings. Use `split(regex, -1)` when an empty last field matters.
- `matches()` anchors the whole string; `find()` doesn't. Check which one the code needs.
