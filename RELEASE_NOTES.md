## Announcement

This release marks the beginning of a process of refactoring the HAPI core code.
We are trimming and refactoring the core model code to reduce dependencies. As part 
of this, we will be culling all the old unmaintained code in the older versions. In
addition, we will be moving all the terminology, rendering, view definition, and 
validation related code to a new partner package for R4, R4B, and R5. 

This change is planned for July 2025. This release starts the process of marking the
code with annotations to indicate it's proposed fate:
- @Deprecated classes will be deleted in July 2025 unless users raise issues with that 
- @MarkedToMoveToAdjunctPackage is code that will move the other package
- Code with no annotations will not move or be deleted 

## Validator Changes

* Add HL7 CodeSystem display and definition checks
* Add Matchetype validator
* Add "http://hl7.org/fhir/tools/StructureDefinition/snapshot-base-version" to snapshot generation
* Optimize the JSON parsing in NpmPackageIndexBuilder.seeFile (#1898) (faster loading)
* Fix stack crash when structure definitions are circular
* Fix error reporting duplicate contained IDs when contained resources are sliced by a profile
* Allow cardinality changes in obligation profiles (but not recommended)
* Fix bug with wrongly processing -ips#(v) parameter
* Add underscore to regex to be able to use underscore in Bundle URLs

## Other code changes

* Refactor FileUtilities and other Utilities classes
* fix element order in Element.forceElement()
* fix NPE in patient renderer
* Resource Factory updates for loading generated resources in IG publisher
* Fix intermittent thread issue in Date rendering
