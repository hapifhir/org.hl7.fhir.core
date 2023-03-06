## Validator Changes

* Add ConceptMap validation
* Add StructureMap validation
* Validate using type regex (had been omitted to now, mostly affects decimal validation)
* Add new -output-style values compact and compact-split
* Fix bug validating CDA choice elements without [x] in their names

## Other code changes

* Various fixes and utilities to support StructureMap & ConceptMap validation
* Fix Observation.value conversion between R5 and other versions
* Recognise R4B and R5 core packages
* Improvements to specification diffference engine for R5 publication
* More efficient XHTML AST model

