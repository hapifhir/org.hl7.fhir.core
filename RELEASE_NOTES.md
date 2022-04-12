## Validator Changes

* Handle reslicing within the same profile
* Fix up wrong handling of context on exists() in FHIRPath
* Add hints to profiles around behavior of pattern on repeating elements
* Ignore all tooling extensions when validating
* support specifying an alternative version when loading source using -ig parameter
* Don't validate Bundle.entry.fullUrl as a reference to some other content

## Other code changes

* Improved output for unit test comparisons
* Fix conversion issues around Base64Binary
* Fix for R4/R5 DataRequirements conversion for DeviceUsage
* Add AdditionalBindings Rendering (draft)
* Display all designations when rendering ValueSets
* Fix bug where expansions have empty objects some times 
* Fix R4B Snapshot generation 
* Enable Linking to fragment CodeSystems

