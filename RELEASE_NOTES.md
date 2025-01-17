## Validator Changes

* New Feature: Validating references: parameters -check-references and -resolution-context
* New Feature: Use AI Service to validate CodeableConcept.text (very experimental)
* Add AI validation tests as a command line option ([-aiTests](https://chat.fhir.org/#narrow/channel/323443-Artificial-Intelligence.2FMachine-Learning-.28AI.2FML.29/topic/LocalAI))
* Don't enforce code system property references to standard properties in R4 (R4 hack workaround)
* Correctly handle supplements when validating based on expansions
* Fix issues with version dependent resolution of correct server for implicit value sets
* Better handle failure to find imported value sets when expanding
* correct error handling for expansion failure
* Correct grammar in language about resource not being valid against a profile
* use IPS 2.0.0 for `-ips`, not an old copy
* Fix NPE generating snapshots with expansions
* Rework `-txTests` to support additional test files and improve R4/R5 logging
* Fix bugs in RulesDrivenPolicyAdvisor
* Accept property in CodeSystem without requiring it be backed by a code
* Add issue when extension is deprecated

## Other code changes

* Track & report expansion source when rendering ValueSet expansions
* Render ValueSet supplement dependencies
* Add server headers to fhir-settings.json
* find places where ManagedFileAccess was missed
* Fix Actor rendering in obligations tables
* Renderer: move xml-no-order to tools ig
* Resource Factory: support for range in sheet for instance generation (#1881)
