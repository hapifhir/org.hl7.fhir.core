## Validator Changes

* Significant upgrade to Questionnaire validation capability
* Fix maxLength validation in Questionnaires
* Fix issue loading cross-version package
* Fix for repurposing the SNOMED-CT CA edition concept
* Fix NPE validating OperationDefinitions with profiles
* Reenable text based terminology logging
* Fix for wrong calculation of slice boundaries when pre-processing slices
* Fix for missing type profile cardinality when generating snapshots
* Fix issue with validation profiles on parameters of type Resource in OperationDefinitions
* Fix OperationDefinition Validation check on outputProfile
* Better validation for references to IGs in packages
* Add oid 2.999 to example URLs
* Use https: for terminology servers
* Fix bug in compliesWithProfile checking - wrongly processing issue level for extensible bindings
* Preliminary Work on multi-inheritance for profiles (still WIP)
* Fix: recheck invariant with deviating severity
* Handle $versions better in TxTester
* Fix: R5 FHIRToolingClient should request 5.0 not 4.0 responses
* Fix: add null check for derived definition in ProfileUtilities
* Fix places where locale was set to null instead of using context
* Enhance JsonDrivenPolicyAdvisor to support JSON5
* fix for Implicit LOINC ValueSet Generation Off-by-one Error

## Other code changes

* Revise validation test outcome handling - separate outcomes to a different file (not in the manifest)
* Fix up cross-version snapshot test infrastructure
* Update validation terminology cache for changing to https
* Fix problem with loading packages without an IG resource
* generate https: links for images and package references (not http:)
* fix NPE rendering codesystem links
* Track extension provenance when generating snapshots (for obligations)
* fix code system comparison to not alter code system being compared
* Modified rendering of SubscriptionTopic.trigger.queryCriteria.current, changing from 'create {0}' to 'current {0}'
* Bump sqlite to 3.49.1.0
* Fix places where locale was set to null instead of using context
* Improve lazy load for i18n messages and plural rules
* fix for underlying cause of missing attribute reference in has<ElementName><TypeName>() methods for multi-typed elements in generated code