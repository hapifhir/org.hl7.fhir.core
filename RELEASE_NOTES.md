## Validator Changes

* Change how count is calculated when expanding value sets
* Fix value set expansion bugs
* Fix for fhirpath issue on command line (#1650)
* Add IG dependency validator
* work around bad r4 extension definitions
* don't reload different sub-version of extensions pack

## Other code changes

* Rework rendering library from ground up
  * Merge Fix: Fix split logic of canonical into url and version in several places (#1663)
  * Suppress spurious message when code system is unknown
  * don't raise needless and wrong exceptions about extension definitions when rendering
  * fix duplicate link creation
  * Stop recursive rendering crash
  * Obligation rendering improvements
* Handle extra profiles on resources in an IG when converting between versions
* Fixed issue with actor title not rendering in obligations
* Test and adaption for dateOp #1655
* Use assertj instead of hamcrest (#1662)
* More transifex work
* Add support for local packages during testing
