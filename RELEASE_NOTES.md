## Validator Changes

* Do not check the values of the xml-namespace extensions (e.g. noNamespace) for URL resolution (HL7/fhir-ig-publisher#1416)

## Other code changes

* Fix R4/R4B to R6 conversion of Immunization.protocolApplied.doseNumber[x] and seriesDoses[x]: keep the original positiveInt type and the primitive's extensions, e.g. a data absent reason on a value-less dose number (HL7/fhir-ig-publisher#1362)
