## Validator Changes

* Fix passing wrong location to advisor in terminology messages
* Fix NPE when system is provided with no code validating CodeableConcept
* Fix FHIRPath context of evaluation for parameters 
* Fix bug validating CodeSystem property value sets
* Allow iterating code systems (for OIDs - to be reviewed)
* Properly generate snapshots in logical models when converting to R4

## Other code changes

* Move build to Java 17; older versions no longer supported
* Conversion fixes
  * R4 - R5: ChargeItemDefinition
  * R3 - R4: Task, Coverage, DiagnosticReport, CommunicationRequest, Medication, MedicationStatement
* Fix issue when rendering a CDSHookRequest (`<<code>/>`)
* Bump sqlite to 3.50.3.0
