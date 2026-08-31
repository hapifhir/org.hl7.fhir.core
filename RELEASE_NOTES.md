## Validator Changes

* Don't report an unknown code as being in version 'null' when the code system doesn't state a version
* Validate codes against value sets that use a `concept child-of` filter, instead of failing with "unable to handle concept filter with op = CHILDOF" (the expansion already supported it)

## Other code changes

* Add TerminologySubsumptionTester: subsumption testing against CodeSystem hierarchies (nested concepts and #parent/#child properties), with proper errors when subsumption cannot be determined
* Use TerminologySubsumptionTester for internal subsumption in BaseWorkerContext.subsumes(), falling back to the terminology server when it cannot answer, and for $subsumes in the internal terminology service tests
* R6: mirror the subsumption changes into org.hl7.fhir.standalone / org.hl7.fhir.model
* $validate-code: don't return a status parameter when the concept's status is 'active' (it says nothing that the absence of inactive doesn't already say)
