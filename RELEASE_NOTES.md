## Validator Changes

* Remove wrong LOINC code for circumference % from vital signs scan
* Remove spurious error when profile discriminators have no value
* Fix as() and ofType() in FHIRPath engine to support type namespaces properly
* Fix problem with FHIRPath engine wrongly checking types in context of CDA
* Fix date validation error in CDA validation
* Update error handling to preserve message ids properly

## Other code changes

* Add rendering of II.system
* Fix extension handling when generating snapshots - which are ignored, overwrite, or add
* Delete some empty java files
* Remove unnecessary snapshot tests
