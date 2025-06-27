## Validator Changes

* Add more structural validation of XHTML
* Add validating ECL filters
* Improve error message for missing extensions
* Fix always on warning about UTF-8 encoding
* Fixed error with OperationDefinition Parameter cross-validation:
  * Can't have target profiles if the type is Element due to existing OperationDefinition invariant
  * Old code was sticking profiles into targetProfiles, which generated spurious errors
  * Make messages clearer
* Provisional support for validating Bundle signatures in validator
  * `-cert` parameter for certificate sources, and add certificates folder to fhir-settings.json
* Allow subclassing in structureMaps
* Adjust errors for broken internal links in Resource.meta.source for HAPI users
* Improved validation for attachments
* Do not pass experimental warning on from terminology server unless doing publishing
* Add `-matchetype` parameter to validator
* Fix eager loading of UCUM service in validator

## Other code changes

* Improved canonical support for JSON and XML + refactor xhtml handling to fix canonical issues
* Fix errors handling paths when generating snapshots
* Add support for tracking data/narrative relationship (beta)
* Add FHIRPath Debug Tracer interface and hooks from FHIRPath engine (permitting debug tracing live execution of expression evaluation) + Test Cases
* Fix FHIRPath: The precedence processing loses the parsing location information from operators, add it into the injected group
* Filter obligations - filter out actors not used
* Fix stated paths for query type OperationDefinitions
* Fix checkstyle warning
* Fix potential NPE in Mime Type evaluation
* Fix system out usage and insecure XML calls
* update pt translations (#2055)
* Remove lots of deprecated classes and methods
* migrate DICOM package builder to R5
* Support conversion of CommunicationRequest between DSTU3 and R4 

