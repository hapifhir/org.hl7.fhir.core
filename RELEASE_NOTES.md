## Validator Changes

* Make comparison filenames properly unique
* Fix aggregation validation for change to definition of aggregation in R5
* Tighten up on how server identity is evaluated when chooinsg which headers to send
* Make sure `-server` mode only runs on localhost by default

## Other code changes

* Profile Rendering: add support for rendering required binding code lists in StructureDefinitionRenderer
* Profile Rendering:  enhance StructureDefinitionRenderer to support complex merged pattern values and improve icon rendering
* Profile Rendering: enhance StructureDefinitionRenderer to handle merged pattern values and prevent duplicate rows in summary tables
* Rendering: Correct language in experimental warning per FHIR-I discussion
* Fix rendering errors generating extensions IG
* Added support to render SHALL NOT extension in Requirements narrative
* Ensure that conformance is only inferred for rendering CapabilityStatements if a flag is set
* Fix end-of-line test case issues
* Fix broken link in dtr when rendering profiles
* Suppress fatal error building extensions IG
