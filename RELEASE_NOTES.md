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

* Backport of memory leak fix targeting 6.1.2
