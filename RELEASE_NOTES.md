## Validator Changes

* Pass context locale through to terminology server
* Fix error validating valid internal codes in supplements
* Delay text check on coded entries for performance and integrity reasons
* Properly Process all-slice element definitions when generating snapshots
* Add warnings about IG status for HL7 IGs
* Fix NPE validating code systems

## Other code changes

* Refactor Utilities & TextFile classes 
* Fixes for thread & synchronicity issues in snapshot generation
* Only use one method for detecting snapshot generation
* Fix referenced parameters object in copy
* Support non-FHIR logical models in element model parsing and composing
* Render displayLanguage when rendering value set expansion
* Hack around broken link in R4 ServiceRequest definition when rendering
* Add support for advisors in test cases and fix ecosystem use in testcases
* rebuild tx cache after release of new extensions pack
* Add test case for R4 rendering
* Support for openEHR WebTemplates (loading, rendering, very draft)
* Update operation renderer to support allowedType
* Fixing tests for slicing pro-processing
