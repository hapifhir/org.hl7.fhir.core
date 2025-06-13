## Validator Changes

* Fix FHIRPath precedence for `in` operation 
* Fix issue with erroneous warning about most recent IG
* Check for duplicate xhtml anchors and ids, and improve message for duplicates
* Fix bug raising errors for terminology.hl7.org.au
* Fix URL error on Compartment Definition
* Fix inactive issue with URI validation

## Other code changes

* add rendering around Narrative control, and sort out issues around language and anchor uniqueness
* Fix up ActorDefinition rendering of derivedFrom
* Remove unnecessary check on element id generating snapshots
* More improvements to OMOP importer
* Conversion 30 to 40 for CommunicationRequest
* Only use ucum service when needed + refactor ucum equality check
* Add signature test case
* Fix NPE rendering mappings, and render ElementDefinition.map.comment
* Fix annotation rendering issue
* Support for pinning to manifest and fix various pinning bugs
* Fix bug using wrong code system for resource types and slowing rendering down
* Fix typo when rendering Structure - Structure Mapping
* Fix issues with concept map rendering of depends on and properties
* Fix issue with missing code system properties when rendering

