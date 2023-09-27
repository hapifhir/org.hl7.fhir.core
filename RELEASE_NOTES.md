## Validator Changes

* Fix for issue parsing SHC and not recording line/col correctly
* Fix issue validating CDA FHIR Path constraints
* Better error handling validating codes in concept maps
* Validate special resource rules on contained resources and Bundle entries
* Improved error messages of observation bp
* Fix up WG internal model for changes to workgroups
* fix misleading error message inferring system when filters in play
* Fix type handling for logical models (CDA fixes)
* Fix up parsing of logical models
* Fix bug parsing extension with no value in JSON for the validator

## Other code changes

* Major uplift of PEModel to support generated code for profiles in R4 + R5
* Add removeChild in R4/R4B/R5 model
* Fix version conversion issue between r4 and r5 charge definition issue
* Fix rendering extension and missed profile on Reference()
