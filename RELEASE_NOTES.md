## Validator Changes

* Snapshot changes:
  * Cater for entering type slicing without defining slicing
  * Allow profiles to constrain common element properties on multiple types
* Changes to tx-tester: 
  * rename `-txTests` parameter to `txTests`
  * rename `-version` parameter to `-test-version`
  * move test case output from `dest` to `dest\actual` and also populate `dest\expected` for ease of comparison
* Fix bug doing compares on differentials with incomplete slicing information
* Test cases for updating eco-system to LOINC 2.81
* Use correct version when loading packages (FHIR version, not package version)
* Fix error loading THO R3
* Correct version of IPS used with `-ips` parameter

## Other code changes

* Rendering:
  * make rendering cross-resource views in the IG publisher more robust
  * fix problem with type casting while generating comparisons
* Various minor cleanups of R3 <-> R4 conversion code
* Fix bug where XHTML was not always processed correctly in CDA transformations
