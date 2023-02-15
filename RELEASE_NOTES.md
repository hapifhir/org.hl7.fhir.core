## Validator Changes

* Fix bug checking canonical URLs in bundles with dashes in them
* Fix extension messages (modifier and normal messages reversed)
* Change how error location paths are reported in bundles for easier resolution (no counting!)
* fix bugs checking whether binding is allowed in corner cases

## Other code changes

* Rendering Improvements: Additional Bindings, Search Parameters, Operation Definitions
* FHIRPath implementations for comparable(), highBoundary(), lowBoundary()
* Fix list of canonical resources from VersionUtilities
* Fix bug parsing html entities in XHTML parser
* Rename extension to http://hl7.org/fhir/StructureDefinition/structuredefinition-imposeProfile
