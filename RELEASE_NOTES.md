## Validator Changes

* Improved Errors for bad resource ids
* R5 ballot: Hack around discovered issues in the ballot
* Enforce value set & code system versioning when validating codes 
* Enable bulk -snapshot and -convert on multiple/wildcard -source
* Fix bug revalidating profiled abstract types

## Other code changes

* Rework validator test cases to not have inter-test dependencies (+ fix up to allow contexts to be cloned)
* add First draft of xliff production
* Add ActorDefinition conversions R5 -> R4, R4B, R3
* Add support for validating logical model json files (not surfaced in CLI yet)
* Updates for changes to extension URLs in Tools IG
* Fix map rendering in value sets
* Fix broken link in R4 DeviceUseStatement