## Validator Changes

* Fix significant bug where validator gets internal child lists incorrect and doesn't do complete validation when switching between validating profiles and resources directly
* Performance improvement for validator parsing - thanks Brian Postlethwaite
* Fix Crash on slicing a sliced element #862
* Fix ig loading from direct URL (#1559)
* Fix bug copying constraints into Bundle.entry.resource profiles
* Fix bug loading R5 extensions with imported value sets
* Replace dom-3 with custom java code, and check xhtml references to contained content
* Improve concept map code validation
* Update observation validator for committee decision not to enforce Blood Pressure profile for Mean Blood Pressure
* Validate value set internal codeSystem references
* Split value set validation into 10k batches for very large extensional value sets
* Hack fix for opd-3
* Fix bug where using ontoserver when not appropriate
* Fix issues with inferSystem
* Don't require HL7 committee for contained resources in HL7 namespace
* Fix where validator was ignoring minimum cardinality for XML attributes (especially in CDA)
* Improved ConceptMap validation
* Updated IG versions used for -cda and -ccda CLI validation options.

## Other code changes

* Fix code system rendering for uri properties
* Fix broken links Bundle and Profile rendering
* Take copy of code when doing local validation
* WIP: major refactor of cross version analysis
* Add support for subsumes in tx client
* Don't generate snapshots when scanning structure definitions for resource names
* Work on ConceptMap infrastructure for cross-version analysis
* Fix bug where not rendering ConceptMap relationships
* Fix wrong URLs rendering Profiles and Questionnaires
* Fix bug using wrong version constant for R3
* Updates for R5 StructureMap syntax
