## Validator Changes

* The terminology ecosystem coordination server (tx-reg) is now independent of the terminology server: by default it is https://ecosystem.hl7.org/tx-reg (configurable as txEcosystem in fhir-settings.json), and the new -ecosystem parameter nominates a different one ('n/a' for none). As before, nominating a terminology server with -tx turns the ecosystem off unless -ecosystem is given too, and -tx n/a turns both off

## Other code changes

* Fix R4/R4B to R6 conversion of Immunization.protocolApplied.doseNumber[x] and seriesDoses[x]: keep the original positiveInt type and the primitive's extensions, e.g. a data absent reason on a value-less dose number (HL7/fhir-ig-publisher#1362)
* FHIRPath: implement the document functions section(), entry(), entryIn(), resources() and resourcesIn() (local extensions, R4, R4B, R5 and R6) - for rules about what a document (e.g. an IPS) contains. Tests are in the fhirpath test suites, in a group marked mode="custom"
* FHIRPath: lowBoundary() and highBoundary() now handle decimals with exponents (9.5e2), and no longer leave a leading zero (10.lowBoundary(0) gave 09)
* FHIRPath: fix = and ~ for quantities with no UCUM code - two quantities without units were never equal, and the unit was ignored when only the left side had one
* no changes
