## Validator Changes

* no changes
* Add ability to [compile a map file to a StructureDefinition](https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Mapping+Language#UsingtheFHIRMappingLanguage-runtransformsjavavalidator)
* Add knowledge of additional R5 extensions for StructureDefinitions
* Fix problem validating extension context on choice types
* Add hint when binding found on element with multiple types
* Fix validator to guess system on all uses of code (not just most)

## Other code changes

* Use cached terminology server responses for unit and integration tests.
* Add more HTTP logging
* Clean up various issues with graphQL and polymorphic elements
* Add better support for date/time rendering 
* Significant speed improvement for terminology caching
