## Validator Changes

* Do not check the values of the xml-namespace extensions (e.g. noNamespace) for URL resolution (HL7/fhir-ig-publisher#1416)
* Apply -level to all validation messages, including issues returned by the terminology server (previously these were always reported)
* Decide whether a type is a canonical resource from the type hierarchy (including all structuredefinition-implements interfaces), not from whether it has a url element, everywhere the validator and renderers check it (ContextUtilities.isCanonicalResource) - fixes additional resources such as ViewDefinition, and removes Composition, Device etc. from getCanonicalResourceNames()
* Check resourceDefinition on an additional resource against the resource the profile constrains, not the profile itself (ViewDefinition validated against ShareableViewDefinition)
* Stop at a loop in the baseDefinition chain when walking up from a profile
* Add a warning for CodeSystems with hierarchyMeaning = classified-with that do not set versionNeeded = true
* Snapshot generation: preserve the child constraints of a datatype under a content reference, and do not recurse into the already processed parent for a new extension under a nested content reference (e.g. Composition.section.section) (#2738)
* Update the CLI preset versions: IPS 2.0.1, CDA core 2.0.3-sd, C-CDA 5.0.0
* FHIRPath: lowBoundary() and highBoundary() now handle decimals with exponents (9.5e2), and no longer leave a leading zero (10.lowBoundary(0) gave 09)
* FHIRPath: fix = and ~ for quantities with no UCUM code - two quantities without units were never equal, and the unit was ignored when only the left side had one
* FHIRPath: treat the calendar durations year and month as the UCUM units a and mo for equivalence (and not for equality), and map month to mo in toQuantity()
* Terminology tester: tests can be gated on features the server declares in its CapabilityStatement; sort parameter parts at every level before comparing; report all differences in a comparison, not just the first
* Add Czech translations for rendering phrases

## Other code changes

* Context: preserve an explicit version when looking up an external resource, and fix the canonical resource index when a resource is removed that shares an ID or URL with others
* Conversion: ConceptMap R3/R4/R4B to R5 only adds the equivalence modifier extension when the relationship loses information (equal, subsumes, specializes, inexact), not for every target
