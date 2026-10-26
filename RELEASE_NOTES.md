## Validator Changes

* The terminology ecosystem coordination server (tx-reg) is now independent of the terminology server: by default it is https://ecosystem.hl7.org/tx-reg (configurable as txEcosystem in fhir-settings.json), and the new -ecosystem parameter nominates a different one ('n/a' for none). As before, nominating a terminology server with -tx turns the ecosystem off unless -ecosystem is given too, and -tx n/a turns both off. The same rule now applies to library callers and to the validator wrapper (ValidationEngineParameters, ValidationEngineBuilder, connectToTSServer): a terminology server other than the default means no ecosystem unless one is given explicitly, so that requests meant for a private server aren't routed on to other servers
* Server mode terminology tests: new POST /txTest/setup and POST /txTest/teardown bracket a run of GET /txTest calls. Setup fixes the server, the test-version (no longer always the dev package), the externals (as content, not a package file name), the output folder and the tester; the FHIR version comes from the server. Teardown returns (and writes) test-results.json and report.json, as the command line does. Tests that don't run - now including disabled tests and FHIR version gated tests - return an error but aren't counted. The default modes no longer include tx.fhir.org (or closure, which is a feature now). The old server= form still works
* The terminology tests report the version of the test package they ran (it was always 1.9.3, read from the frozen tests/history.json)

## Other code changes

* Fix R4/R4B to R6 conversion of Immunization.protocolApplied.doseNumber[x] and seriesDoses[x]: keep the original positiveInt type and the primitive's extensions, e.g. a data absent reason on a value-less dose number (HL7/fhir-ig-publisher#1362)
* FHIRPath: implement the document functions section(), entry(), entryIn(), resources(), resourcesIn() and sameSubject() (local extensions, R4, R4B, R5 and R6) - for rules about what a document (e.g. an IPS) contains. Tests are in the fhirpath test suites, in a group marked mode="custom". In a document, section entries are resolved the way the validator resolves references in a Bundle, and only in the document
* FHIRPath: lowBoundary() and highBoundary() now handle decimals with exponents (9.5e2), and no longer leave a leading zero (10.lowBoundary(0) gave 09)
* FHIRPath: fix = and ~ for quantities with no UCUM code - two quantities without units were never equal, and the unit was ignored when only the left side had one
* no changes
