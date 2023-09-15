## Validator Changes

* Add R4B binding-definition URL to validator exception list
* Correct validation when CodeSystem.content = example and server doesn't know code system
* Fix bug processing CDA snapshots
* Fix issue evaluating FHIRPath correctness on CDA.Observation
* Improve error message from validator when invariants fail
* Fix NPE validating concept maps
* Add parameter for easy CDA validation
* Suppress wrong invariants on compiler magic types
* fix NPE checking codes

## Other code changes

* Improve CodeSystem rendering - make parent property a link
* Add file tracking when npm package performing file unpacking
* Remove env variables from path builder
* Fix bug in version comparison
* fix for NPE in HAPI
* Performance improvements for IG Publisher
* Start working on cross-version extensions
* Improve rendering of message about logical target
* Fix error in Comparisons
* fix NPE checking codes
