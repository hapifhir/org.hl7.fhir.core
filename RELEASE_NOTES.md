## Validator Changes

* Support authentication for terminology servers (see https://confluence.hl7.org/display/FHIR/Using+fhir-settings.json)
* Fix issue where valdiator not retaining extension context when checking constraint expressions in profiles
* Validate min-length when found in extension
* Correct bug parsing json-property-key values with meant validation failed
* Fix problem validating json-property-key value pairs
* Fix special case r5 loading of terminology to fix validation error on ExampleScenario
* Improve handling of JSON format errors
* Fix slicing by type and profile to allow multiple options per slice
* Fix bug where extension slices defined in other profiles are not found when processing slices based on extension
* Validate fhirpath expression in slice discriminators
* List measure choices when a match by version can't be found

## Other code changes

* More work on code generation for profiles
* Render min-length extension on profiles
* Clone SQL on FHIR engine to R4, and update FHIRPath engine based on R5 current code
* Update SQL on FHIR engine to allow push as well as pull
* Change R5 tx server to use http://tx.fhir.org/r5 (instead of /r4)
* Update output from tx-tester to include release ready statement
* Fix rendering of Logical Models for polymorphic elements, and rendering target profiles with versions
* Render contained resources in List resource
* #1790 - Fix versionFromCanonical returns system instead and systemFromCanonical returns version
