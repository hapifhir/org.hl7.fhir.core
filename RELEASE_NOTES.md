## Validator Changes

* Major rework of tx and validation test cases associated with reworking terminology / validator interface and ongoing testing + reconciliation with Ontoserver
major upgrade to validation - use terminology server to perform more logic, and standardise interface based on agreements with Vocab & Ontoserver
* Improve slicing error message
* Add warning to user when referencing an extension that doesn't exist in FHIRPath
* Fix bugs in FHIRPath implementation of split() and join()
* Fix bug handling null objects in JSON (R5)
* Fix for missing search parameter definition in R4
* fix bug handling XML name extension

## Other code changes

* Properly populate property definitions in expansions
* Add CVX Importer
* R6 release support
* IPS tool development
* Improved errors publishing IGs
* Refactor Context to support multiple terminology services
* change type of error when value set circularity found