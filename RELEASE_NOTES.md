## Validator Changes

* Change rules around Document and Link Message validation (see [Jira](https://jira.hl7.org/browse/FHIR-39502) and [Zulip](https://chat.fhir.org/#narrow/stream/179252-IG-creation/topic/Entry.20isn't.20reachable.20by.20traversing.20from.20first.20Bundle.20entry) for details)
* Allow https://example in questionnaire example links

## Other code changes

* Rendering Improvements for deprecated codes Including deprecation reason 
* Add Accept header fetching JSON
* Fix version comparison bug
* Fixes for producing profile summary in IGs
* Add contents to .index.json and bump to v2
* Fix stated package & version in alternate versions packages
* Refactor ProfileUtilities.generateSnapshot
* Fix bug in XHTML generation around empty tags
* Fix NPE appending slashes
* Fix rendering timing to not use a specific verb
* Fix R2 - RX ValueSet convertor for Code Systems
