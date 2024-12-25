## Validator Changes

* Christmas 2025 Add new command option to validator: [test instance factory](https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-GeneratingTestInstancesusingFactories)
* Fix validation of invariants in profiles - check for more conflicts, and don't call conflict if the expression is the same
* Fix issues with tracking supplement usage and getting supplement version matching correct
* Fix npe loading old simplifier package

## Other code changes

* Fix handling of ValueSetVersion parameter in txTests
* Test Instance Generation, and many fixes to PE model
* Fix logical model rendering to use type characteristics for can-be-target
* Only use profiled datatype information for generating snapshots for Resource and Extension
* Fix comparison template loading issue
