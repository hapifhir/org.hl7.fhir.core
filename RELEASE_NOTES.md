## R6 Version

* As of this version, internal processing is moving to be based on R6 not R5
* Support the new R6 release (6.0.0-snapshot1), and get the R6 tests passing and into the pipeline
* Deploy new model, services and standalone modules to the repositories
* Port the supporting libraries from R5 to R6
* Various fixes for the core spec R6 build, and for R6 incubator IGs

## Validator Changes

* Terminology: send required code system supplements to the server (including versioned supplements and server-side includes) and count server-applied supplements as used
* Terminology: fixes for contained resources (including circularities), mixed inactive codes, missing code or system, and resource status checking
* Terminology: the router no longer queries every server for a code system that doesn't exist; dummy value sets get a consistent URL so they cache
* Snapshot generation: rework how datatype profile root constraints migrate into the referencing element, stop copying slicer constraints into slices, always close type slicing, and fix type-specific constraints (binding, maxLength) found in US Core
* Snapshot generation: fix additional-base merges, mapping identity collisions, slice groups that end the snapshot, obligation bindings and extensions, label and additional binding merges, pattern handling, and wrong URLs in R6 snapshot processing
* FHIRPath: fix =/!= on mismatched types and hasValue()/getValue() on complex types; join() on an empty collection returns empty; split() is typed as an ordered collection in static analysis
* Allow ElementDefinition.constraint.source to name an imposed profile
* Match the reference host, not a substring, in policyForReference
* Fix time validation problem
* Fix base64Binary whitespace handling
* Add missing SPDX codes
* Add support for Questionnaire variables (SDC), including launch context (#2404), and Questionnaire answer constraints (#2549)
* Add support for AdditionalBinding.usage when validating
* Improved error messages for failed invariants and constraints
* OperationOutcomes produced by the validator now carry a `validator-version` extension (#2459)
* StructureDefinition validation: validate root ElementDefinitions, move the slicing cardinality consistency check from the snapshot generator to the validator, and fix profiles being validated against the wrong version context
* Missing ELM in a CQL Library is now a warning, not an error
* Terminology cache rework (#2332): less frequent atomic flushing, nonce moved to a partner file, fixed cache key conflicts, and only load from disk when asked
* HTTP server: /loadIG accepts a server-local path only when bound to loopback (#2617)

## Other code changes

* Security: Depth limits in the JSON, XML, Turtle, XHTML and SHC parsers
* txTests: report why a mode-gated test didn't run, add icd-11 to the default modes, add `folder` and `label` parameters, fix the `$versions` probe, and support `$closure`
* Rendering: new narrative renderers for Organization, OrganizationAffiliation, HealthcareService, Endpoint, Location, Group, Practitioner, PractitionerRole and RelatedPerson; render RelativeTime, Duration, Distance and Count
* Rendering: Provenance shows patient, encounter, basedOn, reason/authorization/why, agent roles and an Entities table (HL7/fhir-ig-publisher#1225)
* Rendering: improved rendering of Additional Resources, change tracking in StructureDefinitions, and standards status on ValueSet.compose.include.concept
* Rendering: WCAG accessibility fixes, and new XHTML utilities to support WCAG
* Rendering: add a Translatable flag
* Rendering fixes: CodeableConcept text, display-only references, identifiers, ConceptMap relationship anchors, R6 Requirements, TestReport score, unclosed elements in the copy-XML buttons, illegal html in resources, and no narrative links when there's no web path
* Fix the copy of a worker context to keep package information and master definitions; remove context copying in R4 and R4B
* Package loading speed improvements, plus a new load resource by type/id method
* Work around a problem with an extension definition in old builds of the extensions pack
* NPM package generator fixes for core dependencies and versionless dependsOn, plus an immutable package dependency planner
* Conversion: R5 -> R4/R4B carries ValueSet.compose.property as an extension; fix type "Any", FHIR version codes, and the ValueSet scope extension (FHIR-53122)
* Fix JSON round-tripping of decimal literals (e.g. 1.0e0)
* Fix setting XHTML properties in the element model, and parsing additional resources as contained resources
* Add base adaptors for using engines across versions
* SQL on FHIR: %rowIndex and repeat support, bounded repeat recursion, and runner/validator fixes aligned across R4, R5 and R6
* Fix a terminology client parameter size limit
* Mark R4B code (and more R4 code) deprecated for removal
* Replace the xpp3 and org.everit.json dependencies, and add a Maven license check
* Import leftover translations (adding Ukrainian) and remove the Crowdin set up
* StructureMap/FML: many evaluation and validation fixes - constants, cp/qty/id/c/cc transforms, sub-element sources/targets, choice types, type resolution and analysis, and parse/render of version metadata and trailing comments

