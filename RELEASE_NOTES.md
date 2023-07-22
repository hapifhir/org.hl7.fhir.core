## Validator Changes

* Add support for private NPM registries requiring authentication
* Don't check FHIRPaths on differentials - not enough type info to test reliably
* Fix bugs in FHIRPath handling of logical models
* Fix minor bugs in type handling for Logical Models and R3 Profile validation
* Remove spurious warning message validating CDA documents
* Add value set qa checking 
* Fixes to validator for new CDA package (proper handling of logical model types)
* Fix up bi-di warning message
* Add provisional support for alternate codes
* Workaround ClinicalImpression definition problem in core spec
* Fix to get context variables right when running invariants + fix for parent not always being populated + check type in derived profiles
* Fix checking FHIRPath statements on inner elements of type slices 
* Fix scan of naming systems (error validating namespaces)
* Fix issue checking invariant expressions in R5

## Other code changes

* FHIRPath in HAPI mode: Strip returned IIdType of qualifier, version, and resourceType
* Update R4 and R4B FHIRPath implementations for changes picked up in R5 usage
* Fix obligation rendering message
* Fix missing extensions when converting value set properties
* Fix type of x-unknown-code-system in $validate-code response
* Fix CDA validation test case
* Much work on TxServer test case framework + Update terminology server implementation and tests for changes to test cases
* OMOP Vocabulary and ICFImporter development
* Add OWASP dependency check (#1347), upgrade many packages, remove ShEx
* Add github action to upload results
* Remove unused javalin dependency, also generate html reports
* Added test case for ExampleScenario conversion (R4/R5) and significantly bulked up the conversion process
* Remove unneeded resources (#1346) (help16.png)
* Add test for setVsAsUrl parameter setting (#1345)