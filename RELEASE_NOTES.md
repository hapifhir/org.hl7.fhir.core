## Validator Changes

* Fix validator not allowing canonical resource extensions in canonical resources in bundles
* Fix bundle validation error on intneral link checking
* Check parameter type for FHIRPath where() and all()
* Validate that composite search parameters have components


## Other code changes

* Refactor timeout control on client
* Support IPS in validation tests
* Remove orphan R4B test
* Improve expansion error messages
* Fix expansion language - don't set for displayName parameter
* Adjust value set rendering for fragment code systems
* Fix NPE rendering some resources
* Fix rendering of TriggerDefinition
* Support parsing ad-hoc json data type fragments
* More memory work for IG Publisher
* Move ILoggingService & VersionUtil
* Fix timeout issue in vsac
* Introduce ips builder + Infrastructure changes for IPS builder
* Move json and xml extensions from extensions pack to tooling ig
* Add support for rendering union and intersections of profiles in profile comparison
* FHIRPath iif() test case fixes
* *Add support for IPS validation in test cases
* Fix for broken markdown re-processing
* Improve identifier rendering
* Fix committee URLs

