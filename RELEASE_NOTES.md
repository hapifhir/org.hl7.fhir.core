## Validator Changes

* Security Fix: Move all instantiation of transformerFactory to XMLUtils and set ACCESS_EXTERNAL flags automatically (slightly improvement to output message, but closes possible attack vector)
* Handle 308 redirects when fetching packages
* Fix NPE in ValueSetValidator
* Fix for NPE in IGLoader
* fix version conversion problem for ConceptMap (4<->5): relationship comment getting lost for noMap entries
* Add check for multiple WG extensions (HL7 context)

## Other code changes

* Suppress spurious logging statement
* Add Australian CDA name prefix & uri to mapping transform code
* Add new messages for tx.fhir.org
* Remove narrative from snapshot tests
* Improve complex extension rendering when rendering by profile
* Rewrite processing of map statements when generating snapshots to fix known bugs
* Updates to Capability Statement rendering (and minor Operation Definition rendering improvement)
* Fix wrong reference to CDA classes for unscoped class names
* fix rendering issue for R4 relationship codes in ConceptMap
* rework decimal lowBoundary() and highBoundary() after discussion on Zulip, and add extensive testing
* Fix existing test case for fixed up boundary handling in FHIRPath
* Add CodeSystem fetching for selected code systems for VSAC import
* Drop to saxon 11.6 for now
* fix issue with json unicode whitespace enscaping
* get Java generator running again (though no code regenerated)
* don't escape unicode whitespace in json files
* Fix NPE in questionnaire renderer
* Hack workaround for R4 issue with ProcessPriority
* Rewrite concurrency management for file system package cache

