## Validator Changes

* Several performance fixes in instance validator + parsing and serialising performance improvements
* Add support for R6 style signatures
* Fix time comparison in signature (#2385)
* Fix xhtml issue in signature (#2385)
* Add validation note when Attachment data can't be fetched
* Fix for Conditional Reference Validation Failure (#2474)
* QuestionnaireResponse validation for min/max occurs is wrong for number of answer equal to min or max(#2314)
* QuestionnaireValidator Calls QuantityComparator.valueOf With Code From Quantity.comparator (#2224)
* Fix caching issue associated with CodeableConcepts with multiple codings (#2262 related)
* Terminology: no NullPointerException in ValueSetValidator.resolveCodeSystem when a ValueSet requires a code system supplement and includes a code system that cannot be resolved
* Don't report an unknown code as being in version 'null' when the code system doesn't state a version
* Validate codes against value sets that use a `concept child-of` filter, instead of failing with "unable to handle concept filter with op = CHILDOF" (the expansion already supported it)
* Two terminology failures came back with no tx-issue-type in details.coding - fixed
* Add `too-costly`, `not-supported` and `business-rule` to OpIssueCode (`version-error` was already there), matching the codes added to the tools IG
* Add subsumption issues and fix various code validation issues
* fix handling of CodeableConcept with valid code and also an unknown codeSystem
* fix handling of properties per ValueSet.compose.property
* txTests: write everything that goes to the console to test.log in the run's output directory as well, next to actual/ and expected/. A test that fails by comparison leaves a diff; a test that fails by throwing left nothing at all once the terminal scrolled, and the stack trace is the whole of what you needed
* txTests: strip OperationOutcome.issue.diagnostics outright before comparing
* txTests: evaluate the test suites' FHIR version gates against the version the server under test reports, not against -test-version 
* txTests: Add $subsumes testing 
* txTests: Add better checking of terminology capability statements
* txTests: fix up error handling 
* txTests: tighten up TxTest command doco in picocli

## Other code changes

* fix: terminate XhtmlParser.readUntil at end-of-input
* update readme for changes to R6
* R6: Get the R6 tests passing - caused ripple effects into R5 for consistency
* revisit xhtml handling in element model to allow control over canonical form (#2464)
* Several potential NPEs fixed
* Use TerminologySubsumptionTester for internal subsumption in BaseWorkerContext.subsumes(), falling back to the terminology server when it cannot answer, and for $subsumes in the internal terminology service tests
* $validate-code: don't return a status parameter when the concept's status is 'active' (it says nothing that the absence of inactive doesn't already say)
* fix for #2547: ValidationOptions has inconsistent implementation of with... pattern validation-core
* fix @Nonnull attribute
* Update opentelemetry + okio





