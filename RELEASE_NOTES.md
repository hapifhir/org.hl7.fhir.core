## Validator Changes

* fix NPE in FHIRPath services for the validator
* Allow full URL in extension context in logical models
* snapshot-source extension type fixes

## Other code changes

* Common FHIRPath interface across all versions (extend breaking change to all versions)
* fix PackageVisitor to include examples
* fix issue with wrong us core 311 web reference
* Split dstu3 package contents to prevent duplicate packages (#2105)
* add ElementVisitor to older FHIR versions
