## Validator Changes

* Fix value set code system references when pinning as part of repackaging
* Property validate CDS-Hooks extensions
* Don't override displayLanguage if explicitly set in expansion parameters
* Fix Line numbering in the fhirpath parser is 1 char off
* Fix snapshot generation & consequent validation failure when a profile walks into a slice that has multiple type profiles
* Fix error loading .r4/.r5 packages for other than Extensions Pack
* Fix complies with checking on slice evaluation

## Other code changes

* Add UML generation for StructureDefinitions (+add test cases)
* Update PackageLoaders to load resources converted from basic
* Fix rendering of comments in ConceptMaps for unmapped items
* ExampleScenario Rendering: Fixed hyperlink issues, correct rendering of workflow and fix commas
* Fix value set concept counting for single filter that has >1000 members
* Utility to scan for must-support issues on slicer+slices
* Update rendering-phrases_de.properties to fix minor typos in german rendering
* Fix language comparison code when rendering value sets - en and en-US are default languages
* fix issue with UML tests caused by Snapshot generation tests
* Render obligation source
* Track extension source generating snapshots
* Bump ucum to 1.0.10
* Add UML generation test cases
