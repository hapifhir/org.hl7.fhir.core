## Validator Changes

* fix NPE loading resources
* Don't enforce ids on elements when processing CDA
* Send supplements to tx server
* fix bug processing code bindings when value sets are complex (multiple filters)
* fix spelling of heirarchy
* Look up CodeSystem from terminology server
* Don't use tx-registry when manual terminology server is set 

## Other code changes

* More work on WHO language support ($1592)
* allow validation message to have count
* render versions in profile links when necessary
* rework OID handling for better OID -> CodeSystem resolution
* fix up vsac importer for changes to client
* don't send xhtml for tx operations
* FHIRPath: Backport the defineVariable code to the R4 and R4B fhirpath implementations
* FHIRPath: Remove the alias/aliasAs custom functions (use standard defineVariable now)
* Bump lombok (#1603)
