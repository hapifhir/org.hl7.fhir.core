## Validator Changes

* Rework bundle references validation for R4+ - this is a *significant* change - many existing bundles that were previously erroneously passing will now fail
* #1488 - don't fail on erroneously repeating elements
* Fix problem creating CDA type discriminators
* Fix problem with R3 expansion
* Add support for CCDA .hasTemplateIdOf(canonical)
* Add support for NZ IPS


## Other code changes

* Start work on making IWorkerContext a versioned API
  * Add fhirVersion to R5 Base and IWorkerContext methods
  * move IContextResourceLoader, ValidationResult and CodingValidationRequest out of IWorkerContext to their own clasess
* Fix up VSAC import for large value sets
* fix FHIRPath cda tests for empty package cache
* Fix issue where markdown with multiple characters was being cut off sometimes when rendering profiles
