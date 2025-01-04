## Validator Changes

* Validate that ConceptMap references to ValueSets are actual value sets
* Check if abstract classes have concrete subtypes in scope
* Handle tx ecosystem failure properly
* fix for CLI Should Fail with Non-Zero Exit Code on TX Test Errors

## Other code changes

* Add support for multiple lines in the first cell in heirarchical tables
* Also add support for suppressing lines and inner borders
* Add support for table.rows in TestDataFactory
* Add Element View for non-technical readers of profiles
* Improved Rendering for Timing Datatype
* Fix for handling SD extensions when generating snapshots
* Don't remove bindings from types with characteristics = can-bind (Extensions in R5)
* Various minor Fixes for generating snapshots for archetypes (checking type parameters)
* Fix logback configs + update logback (#1868)
* .qos.logback-logback-core-1.5.13: Fix inclusion of logback-test in jar and fix classpath log configs
* Fix LoggingPolicy enum (use SLF4J)
