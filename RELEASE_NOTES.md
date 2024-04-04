## Validator Changes

* Validate fixed/pattern values are not changed in derived profiles
* Fix NPE validating some profiles
* FHIRPath validation: consider sub-extensions when checking extension($) use
* Fix validation of concept maps containing SCT
* Preserve message id from terminology service so editors can use it to remove hints and warnings

## Other code changes

* Fix ConceptMap.group.target conversion from R3 to R5
* Fix NPE in list renderer
* fix bug showing 'required' instead of 'current' rendering additional bindings
* Fix bad references generating narratives in bundles
* Fix bug showing extension binding twice
* Various improvements to structure map validation to support cross-version mappings
* Add rendering for UsageContext and ContactDetail
* Fix broken link in xver IG for R2
* Fix bug rendering resources in Parameters resource
* Not-pretty xhtml gets line breaks before block tags to keep line length down (work around a jekyll issue)
* Improved ConceptMap rendering for cross-version IG
* Handle xhtml:div type for old FHIR version
* FML: strip '-' from rules names when parsing
* Update FML parsers to accept R5 metadata in R4 FML format
* Break out helper classes for Terminology Service Tester

## Security

* Add start of security notes
* Start moving file access to all go through ManagedFileAccess

## WHO Internationalization work:

* Add library to parse IETF Language definitions
* Move message translations to .po files as the master source & write convertor
* Much work making rendering i18n-able
* i18n for Patient renderer
* Refactor language handling in R5 renderers
