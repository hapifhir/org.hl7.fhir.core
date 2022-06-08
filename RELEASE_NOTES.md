## Validator Changes

* Clean up the -extension parameter - make implementation conistent with documentation
* Stop auto-converting parameters to strings for string functions e.g. .length() in the FHIRPath engine
* Add parameter -implicit-fhirpath-string-conversions for old FHIRPath string conversion functionality

## Other code changes

* Fix NPE counting descendents when validating
* Fix bug processing invalid HTTP response
