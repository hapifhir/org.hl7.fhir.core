## Validator Changes

* Validation by templateId for CDA
* Fix NPE validating concept maps
* Update ViewDefinition validator for change (alias -> name)
* Fix for NPE validating sql-on-fhir ViewDefinition
* Fix for index out of bounds error when extension uses itself
* Fix issue where .resolve() in FHIRPath didn't work with URL values (and fix typo in i18n system)
* Implement FHIRPath slice() function in validator
* Fix bug where Snapshot generation can run off the end of the differential 

## Other code changes

* Breaking API Change: Revise FHIRPath API so hosts can evaluate expressions in custom functions
* Add package use tracking to FHIR cache for validator.fhir.org
* Support for instance-name and instance-description in IG publisher
* Element.removeExtension (support for instance-name and instance-description extensions in IG publisher)
* Split terminology service tests
* Hack for wrong URLs in subscriptions backport
* Remove dependencies for unused UI experiment
* More improvements to profile code generation
