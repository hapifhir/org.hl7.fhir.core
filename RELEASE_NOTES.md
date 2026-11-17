## Validator Changes

* ViewDefinition: check `resource` against each declared `fhirVersion` rather than the version the validator is running on, and accept a logical model named by the canonical URL of its StructureDefinition (#2873)

## Other code changes

* SQL on FHIR Runner and Validator (R4, R5 and R6): support views over a logical model named by the canonical URL of its StructureDefinition (#2873)
