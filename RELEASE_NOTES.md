## Validator Changes

* Add validation for http://hl7.org/fhir/StructureDefinition/narrative-language-control and http://hl7.org/fhir/StructureDefinition/narrative-source-control
* better error message when XML encoding is incorrect
* fix bug validating profiles when canonicals have versions
* fix bug validating constraint.source when it has a version

## Translations

* Add support for using crowd-in for translations
* Add Mandarin and Uzbek language spaces
* update some PT translations, mark AI generated translations

## Other code changes

* Improved rendering of structure mappings, and support for structure - structure concept maps when rendering 
* Support for suppressing mappings generally
* Auto create path in test data factories
* Fix duplicate IDs in examplescenario rendering
* Support not rendering code system definitions as markdown in value sets
* Fix NPEs in class generation
* add batch test to TxTester
* add POGenerate functionality to validator
* language aware present() on CanonicalResource
* fix bug where batch validation wasn't handling parameters correctly
* Fix path bug generating class diagrams
* Allow suppressing mappings in IG publisher
* Create new modules for R6 generated code
* fix version in terminology client from r4 to r5
* Update PECodeGenerator - fixes for some generated code
