## Validator Changes

* change URL wording in warning about unknown URLS after discussion in committee and fix error validating URLs + don't check Attachment.url + Bundle.entry.request.url + QuestionnaireResponse.item.definition
* implement new agreement about how IPS narrative linking works
* Check extension contexts are valid paths
* Properly handle not-present code systems in yet another place
* fix bug when validation an operation definition that has parameters with parts and profiles
* fix slicing bug in pre-process
* fix bug in path handling in snapshot preprocessing
* Fix extension URL for value set parameter 
* Add support for NPM aliases
* Fix terminology cache hashing (#2006) and Add fhir-types entries to txCache
* improve tx log performance and readability, and avoid logging excessively large requests
* Fix early processing of markdown in definition status checks (#2004)
* Add check for headless mode before accessing desktop features (#2000)
* fix outsize batch validation request problem
* fix: ensure non-null return for slices and handle missing slicing details for extensions
* fix loading issue for openEHR IG

## I18nWork

* A huge set of changes to support multi-lingual IGs being published by the IG publisher
* A complete rewrite or refresh of all the i18n features

## Other code changes

* Convert DocumentReference.date/indexed/created conform fhir specs (#2013)
* support fuzzy in lang
* rework presentation of elements with no computable binding
* update table generator to add filter and view controller
* Clean up extensions in version conversion code
* Fix http param formatting using apache utils
* fix null locale in RenderingContext
* finish work on code generation
* finish updates to vsac importer
* add openEHR classes
* vsac subsumes work for CDC Rec
* Structural replace of this != null conditions
* Add aliases and alternates to make cliContext fields deserialize
* Add rendering Concept Domain
* Fix incorrect language code for Czech (#2020)
* Fix parsing bug in html (comment before html couldn't contain a '<')
* Fix rendering phrase support for multi-byte characters (#2023)
* Remove generated narrative header in IG pages
* fix type heirarchy for XhtmlType (#1800)

