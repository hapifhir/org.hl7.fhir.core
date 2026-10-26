## Validator Changes

* no changes

## Other code changes

* Narrative: a Reference with the alternate-reference extension (target type not allowed by the element) links to the target in the extension, also when it has a display or identifier, instead of ?rref? or plain text (HL7/fhir-ig-publisher#1423)
* Consent renderer (R4/R4B): use the R5 decision modifierExtension (http://hl7.org/fhir/5.0/StructureDefinition/extension-Consent.decision) as the base rule, and render a provision without type (the root rule) with the permit/deny of its parent instead of deny (HL7/fhir-ig-publisher#1422)
* Fix R4/R4B to R6 conversion of Immunization.protocolApplied.doseNumber[x] and seriesDoses[x]: keep the original positiveInt type and the primitive's extensions, e.g. a data absent reason on a value-less dose number (HL7/fhir-ig-publisher#1362)
* FHIRPath: lowBoundary() and highBoundary() now handle decimals with exponents (9.5e2), and no longer leave a leading zero (10.lowBoundary(0) gave 09)
* FHIRPath: fix = and ~ for quantities with no UCUM code - two quantities without units were never equal, and the unit was ignored when only the left side had one
* no changes
