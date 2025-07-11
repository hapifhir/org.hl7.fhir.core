## Validator Changes

* New Feature: HTTP server mode for pipeline/dedicated server support
* FHIRPath improvements - see https://github.com/hapifhir/org.hl7.fhir.core/pull/2080
* Don't require vitals signs profile for BMI code: 59574-4
* Fix error in tx error processing where some errors were being lost when validating codes
* Matchetype validation improvements
* More work on signature validation
* Fix NPE validating concept maps
* Fixed issue with Parameter/Profile alignment validation when validating OperationDefinitions
* Don't check URL in Coding.system when checking defined URLs - it's already fixed
* Add urn:ietf:bcp:13 to known definitions
* Update Narrative validation for FHIR-I changes to language control extension
* Fix bugs with implicit value set handling
* Fix bugs validating extension context: nested elements and profiles
* Use batch validation when validating ValueSets and ConceptMaps but only if the server supports it
* Allow new target types when specializing in logical models
* Add warnings for unexpected all codes bindings on LOINC, SNOMED CT, and CPT
* Improve value set validation for ValueSet.compose.include.filter.value
* Fix wrong return value for attachment validation (wrongly causing profile validation to fail)

## Other code changes

* HAPI Significant fix: parsing issue associated with extensions on Reference.reference (was ignoring Reference.reference.extension if only extensions present)
* Add VCLParser
* Remove Deprecated code (round 1)
* Fix up invalid XHTML generation in renderers 
* Add testing support for batch code validation
* Improve suppressedMappings set consistency in ContextUtilities
* Fix rendering for some multi-line strings
* Fix supplement rendering for value sets
* update tests for not sorting messages
