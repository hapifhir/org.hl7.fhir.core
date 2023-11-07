## Validator Changes

* Validate Vital signs Profiles when validating observations
* Hack around problem with vs-1 constraint in R4
* Check for retired status when multiple OID matches exist
* Fix for validating extensions on R5 resources in R4 (R4 special case)
* Minor fixes for standalone ViewDefinition validator

## Other code changes

* Revised Capability Statement rendering (Thanks Vassil Peytchev)
* Fix bug rendering primitive types with an extension that provides a value alternative
* Add links to references when rendering json and xml instances in IG publisher
* Fix bug generating profile spreadsheets
* Support suppress examples when generating snapshots
* VSAC Import improvements
