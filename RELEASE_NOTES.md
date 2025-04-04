## Validator Changes

* no changes
* Change value set validation to consider unknown concepts as errors not warnings
* rework handling of unknown URLs outside HL7.org and fhir.org spaces
* fix bugs processing extension slicing in the all slices slice
* fix bug where unknown canonical urls pointing outside hl7.org/fhir are ignored in the IG publisher
* fix bug generating snapshots on nested elements with slicing at both levels
* And fix bug where discriminators can't be processed on profiled elements that also have contentReference
* Fix NPE in ConceptMap Validator
* Fix problem with file name in terminology cache
* Add parameter -authorise-non-conformant-tx-servers
* Properly handle expansion errors
* Parameterised Valueset validation + check for misuse of OIDs
* Handle missing valueset filter value better


## Other code changes

* Update rendering-phrases-fr.po
* Add SDC for snapshot generation test case
* update preferred extension pack version
* Add 3rd draft ballot for R6
* Adjust expectations for revised string summary of issues
* ValueSet rendering improvement
* rework how slicing info is handlded in tests
* OIDAssigner updates for R6 draft ballot
* xhtml compliance work
* fix up valueset designation rendering
* Add R4B <-> R5 conversion for Subscription
* fix bug in SearchParamType.resource + Add SearchType.Resource for R6 support
* R6 support for ClinicalAssessment
* Don't use Locale(String) constructor when using full BCP 47 strings
* Support for withdrawing IGs
* Render parameterised value sets
* fix problem with tests/ directory in Npm Packages
