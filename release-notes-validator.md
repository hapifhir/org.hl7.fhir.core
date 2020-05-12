---
title: FHIR Validator Release Notes
---

# FHIR Validator Release Notes

## Current (not released yet)

* fix fatal NPE validating bundles when resource is missing
* fix tests for R5 changes 

## v4.2.30 (2020-05-12)

* Allow mailto: urls as absolute URIs 

## v4.2.29 (2020-05-11)

* Upgrade to R4.4.0 internally

## v4.2.28 (2020-05-10)

* Change to use different secondary package server

## v4.2.27 (2020-05-08)

* Release to support Publisher

## v4.2.26 (2020-05-06)

* Check proper use of urn:ietf:rfc:3986 identifiers
* Support new version of R5 extensions

## v4.2.25 (2020-05-02)

* Bump version for new preview release of R5

## v4.2.24 (2020-05-02)


* Update ConceptMap relationship terminology for main build support

## v4.2.23 (2020-05-01)

* Add better provenance support for Publisher 

## v4.2.22 (2020-04-29)


* Fix problem evaluating "type" discriminators ending with .resolve()
* Fix link to Publisher in QA report now that publisher has moved

## v4.2.21 (2020-04-29)

* Validator: add icd-9-cm to list of known URIs

## v4.2.20 (2020-04-28)

* Release to support Publisher

## v4.2.19 (2020-04-23)


* Allow validation of codes in code system fragments
* Fix validation of uri/url types with extensible bindings
* add the parameter -no-extensible-binding-warnings
* Suppress errors associated with http://hl7.org/fhir/StructureDefinition/structuredefinition-normative-version in R4
* fix error processing command line parameters (ArrayIndexOutOfBoundsException)
* check codeSystem kind when checking all valuesets URL

## v4.2.18 (2020-04-21)

* Package Manager: Fix Accept header when using package server
* Fix using a FHIRPath context in an extension in a Bundle
* Add support for R5 extensions validating cross-version extensions
* Better URL validation
* Better handling of Bas64 errors

## v4.2.17 (2020-04-12)

* No changes to validator (all functional changes for the publisher)

## v4.2.16 (2020-04-12)

* No changes to validator (all functional changes for the publisher)

## v4.2.15 (2020-04-09)


* Better error for wrong text in XML instance
* fix to validate using UTG terminology correctly 

## v4.2.14 (2020-04-06)


* More work validating Measure & MeasureReport 
* fix NPE when element mapping is "" (illegal, but still shouldn't cause an NPE)
* Add type to path statement when validating bundles for easier human understanding
* Change validator so root resource id is not in the same space as all other ids
* Fix bug determining ssytem for a bound code where there is an exclude

## v4.2.13 (2020-04-02)

* Add a warning if a coding has a code but no system
* Add check for duplicate ids 
* Validate MeasureReport against it's Measure
* Check that Canonical URLs are absolute 

## v4.2.12 (2020-03-31)

* Fix problem validation questionnaire items 
* fix problem validating bundles in references 

## v4.2.11 (2020-03-28)


* Fix for R3 extension context of Any
* Better error message when encountering ```null``` in json format


## v4.2.10 (2020-03-26)

* More validation of XML syntax + encoding + version
* More validation of URL charaters in XHTML ```a``` and ```img```

## v4.2.9 (2020-03-17)

* fix problems generating v1.4.0 snapshots
* More work on internationalization

## v4.2.8 (2020-03-13)

* Add missing java class for publisher release

## v4.2.7 (2020-03-13)

* Package Manager: check version before checking cache if no version specified when loading a package
* Version Conversion: Fix issue with processing R4 concept maps with relationship type = relatedto
* Check that a Json Primitive is actually a list when it should be

## v4.2.6 (2020-03-05)

* Support for criteria on exists() in invariants
* Do not omit invariants that have a stated source

## v4.2.5 (2020-03-03)

* Add -to-version parameter and support for easier version conversion
* `ValidatorOptions.guessSystem()` method did not actually set this flag

## v4.2.4 (2020-02-28)

* Support for slicing by patternCoding

## v4.2.3 (2020-02-25)

* Release for new functionality for Publishing

## v4.2.2 (2020-02-22)

* NPM sub-system: fix package subsystem for challenge with hl7.fhir.au.base setup

## v4.2.1 (2020-02-19)

* NPM sub-system: Change to use http://packages.fhir.org
* Validator: Allow search references in transactions

## v4.1.63 (2020-02-13)

* Java Core: fix but accessing security labels (Coding getSecurity(system, code))
* Version Conversion: Fix the OperationDefinition conversion

## v4.1.62 (2020-02-13)

* NPM sub-system: Fix IHE template to work
* NPM sub-system: Enforce that package versions can only contain the characters a-zA-Z0-9-. or else start with file: followed by a valid local file system reference
* Snap-shot generator: Fix a bug where a differential caused an NPE in the snapshot-generator
* Snap-shot generator: Improve handling of circular dependencies in profiles (better error reporting, less errors)
* Version Conversion: Restructure the version conversion routines to convert extensions more faithfully (and be easier to manage)
* Validator: Fix warnings around xhtml language to cover both lang and xml:lang (see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues)
* Validator: Questionnaire.item.enableWhen validation - stop producing spurious warnings about errors, and check enableWhen in descendent questions (was being ignored)

## v4.1.61 (2020-02-07)

* Snapshot generation: handle profiles on Bundle.entry.resource properly
* Internal: Fix bug accessing a null object

## v4.1.60 (2020-02-02)

* This re