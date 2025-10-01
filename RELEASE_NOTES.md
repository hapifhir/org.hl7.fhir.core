## Validator Changes

* Major upgrade to terminology functionality:
  * Rework handling of version references between value sets and codesystem based on extensive tests in tx-ecosystem test suite 
  * Handle versions in ValueSet.compose.include.version and expansion parameters properly
  * Remove Version Parameter in expansions (long deprecated)
  * Handle wildcard version dependencies
  * Deprecated codes are not inactive
  * Improved warning messages when value set concepts are not validated
  * Improve Error Message about missing value set binding
* Add support for scoring profiles
* Validation changes to support Additional Resources (resourceDefinition property)
* Fix issue where extensions can have either value or sub-extensions but this was not allowed by the validator
* No unknown url errors for CapabilityStatement.implementation.url
* Prevent duplicate messages from validator (still happened in a few circumstances)
* Suppress irrelevant binaries from the comparison folders (bye bye donald duck)
* Fix bug where version wildcards cause errors processing some already published packages
* Update sql-on-fhir package name

## Other code changes

* refactor IWorkerContext (no new functionality, but code moved to IWorkerContextManager, so bump minor version)
* Fix Concurrency issue in CanonicalResourceManager (#2166)
* More work on cross-version extensions (not released yet)
* Rendering and definition improvements to support Additional Resources
* Update OWASP check for OSS Index Usage (#2188)
* Improved rendering of bindings and constraints
* Clean up inherited element representation for Additional Resources
* Fix bug not resetting type manager properly
* Fix up internal handling of expansion parameters: no duplicates, route to internal terminology server
* Give all SCT codes value set a web path
* fix rendering issue in CS rendering where versions shown wrongly
* Invest in better xhtml -> markdown work to support AI publication of IGs
* Add support for converting VersionAlgorithm on CodeSystems
* Ongoing internal refactoring of the validation command line parameters to support client/server mode 
* Refactor for faster ValidationServiceTests
* Fix problems in generated Excel spreadsheets for profiles
* Updated NLM launcher to use URL and parameters that actually work when rendering questionnaires
* Fix handling of multi-language narrative so that hand-coded narrative doesn't get overridden
* Fix up missing post-validation info (wasn't consistently populated)
* Add support for xhtml to markdown in IG publisher - track generated html better
* fix use of wrong element name in CDA IGs for extensions when rendering CDA content
* don't map EXT_CS_PROFILE when converting r4 back to dstu3
* SonarQube: Add at least one assertion to various test cases
