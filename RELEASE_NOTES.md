## Validator Changes

* Internal changes for supporting new cross-version packages - not yet released (WIP)
* Support for new cross-version packages - pin versions explicitly in old core packages (R3-R4B)
* Fix issues handling deprecated concepts and designations in code systems and value sets - make consistent across all contexts and code systems
* Fix bug checking versions with wildcards
* Ensure that wildcard dependencies are always to the latest version when loading wildcard dependencies
* No double errors on unknown cross version extensions
* Don't use batch validation when no tx server
* Add missing SIDs to validator definitions
* Fix misleading error for case mismatch on files
* Fix error trying to validate against a broken profile (no snapshot)
* Fix threading / mishandling issues around expansion parameters 
* Warn for usage of old debug param on the command line 
* Fix for invalid package versions in package listing JSON (#2152)
* Fix ips:au param
* Fix validation of max decimal places in Questionnaire
* Fix erroneous use of alternate tx servers to validate value set codes in batch mode

## Other code changes

* Add SCT tests when testing for tx.fhir.org
* Fix web source for LOINC attachments value set
* Render modifier explicitly on extensions
* Fix double $$ rendering operations
* Add rendering support for additional SCT editions
* Fix error generating cross-version definitions for canonical resources