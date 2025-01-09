## Validator Changes

* Do not create issue about draft dependency for example bindings
* Beef up validation of CodeSystem properties that are codes
* Make sure all validation messages have a message id
* Validator enforce version-set-specific value for Extension and Extension context
* Specific Error when ValueSet.compose.include.system refers to a ValueSet
* Fix NPE processing code system supplements

## Other code changes

* Report count of tests in output from TxTester
* resolve issues with references between IGs to example resources
* Lookup compliesWithProfile target from link-only dependencies
* Update SNOMED editions related routines (add more editions)
* Accessibility - role=presentation on appropriate tables
* Add support for ADL in packages
* Support for Archetype processing in IG publisher
* Lazy load binaries for reduced memory usage


