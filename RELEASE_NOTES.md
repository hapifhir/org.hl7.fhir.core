## Validator Changes

* Fix problems validating variables
* No longer ignore hl7.org/fhir/tools when validating

## Other code changes

* Fixed bug with incorrect parameter type when POSTing a $validate-code request to a remote terminology server
* Fix OS issue with zipslip protection
* Fix for where profile_element extension was being ignored when checking types after snapshot generation
* Fix generated name for FML rules to be a valid name
* Allow loaders to decide which resources to load into the context