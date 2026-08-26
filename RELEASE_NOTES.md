## Validator Changes

* Improved Measure and MeasureReport validation
* FHIRPath: don't throw a NullPointerException when a FHIR primitive has extensions but no value (e.g. data-absent-reason)
* Fix snapshot processing bug found in cz lab IG
* Fix for finding xver extensions when slicing (they were not being found)
* txTester improvements for better version control

## Other code changes

* R4/R4B <-> R5 conversion: don't lose extensions on Immunization/ImmunizationEvaluation/ImmunizationRecommendation doseNumber and seriesDoses, and preserve the original positiveInt type
* Fix round-tripping issue for R4/R5 concept maps in unmapped portions
* Fix bug in Expansion where noHeirarchy actually mean with a heirarchy
* Fix issues with expanding ValueSets with multiple property values for the same property (carry every value of a repeating concept property into contains.property)
* Code rearrangements pursuant to introducing R6 (Move ITerminologyClientManager and UserDataNames, remove adjunct marker)
* Server clean up + write documentation + add openapi definitions (yaml + json)
* Fix up shutdown issue with terminology caching (this issue did not affect the validator or the publisher)
* Fix error handling on $translate (for TxTester)
* Update tx.fhir.org error messages

## R6

* This version introduces the R6 code base
* The generator has been updated and secured
* The code has been split into 3 packages - model, services, and standalone
* Code does not include R6 because there will be no more version dependent code after R6
* The code has not been tested; it is included for review (R6 is still a moving target)
* Converters between R6 and R4 + R5 are included but not used at this time
