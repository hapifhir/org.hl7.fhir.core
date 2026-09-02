## Validator Changes

* Don't report an unknown code as being in version 'null' when the code system doesn't state a version
* Validate codes against value sets that use a `concept child-of` filter, instead of failing with "unable to handle concept filter with op = CHILDOF" (the expansion already supported it)
* txTests: evaluate the test suites' FHIR version gates against the version the server under test reports, not against -test-version (which names the tx-ecosystem package, not a FHIR version)
* Two terminology failures came back with no tx-issue-type in details.coding, so the only machine-readable thing about them was the FHIR issue type. An expansion that stops because it is too costly now carries `too-costly`; a filter that cannot be evaluated at all - a regex that never terminates - carries `invalid-data`. Both are the codes the ecosystem tests already expect, so no test changed
* Add `too-costly`, `not-supported` and `business-rule` to OpIssueCode (`version-error` was already there), matching the codes added to the tools IG
* txTests: write everything that goes to the console to test.log in the run's output directory as well, next to actual/ and expected/. A test that fails by comparison leaves a diff; a test that fails by throwing left nothing at all once the terminal scrolled, and the stack trace is the whole of what you needed
* txTests: strip OperationOutcome.issue.diagnostics outright before comparing, instead of only when the issue also has details and the text doesn't mention x-request-id. diagnostics is server-specific detail and no test can now depend on it; everything a client is entitled to see belongs in details.text, with the machine-readable classification in a tx-issue-type coding in details.coding

## Other code changes

* Add TerminologySubsumptionTester: subsumption testing against CodeSystem hierarchies (nested concepts and #parent/#child properties), with proper errors when subsumption cannot be determined
* Use TerminologySubsumptionTester for internal subsumption in BaseWorkerContext.subsumes(), falling back to the terminology server when it cannot answer, and for $subsumes in the internal terminology service tests
* R6: mirror the subsumption changes into org.hl7.fhir.standalone / org.hl7.fhir.model
* $validate-code: don't return a status parameter when the concept's status is 'active' (it says nothing that the absence of inactive doesn't already say)
