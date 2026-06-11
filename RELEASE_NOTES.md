## Security

* XXE protection now covers saxon specific implementations
* Regex processing is now time bounded in dstu FHIRPathEngine funcMatches

## Validator Changes

* RDF/turtle revamp
  * turn r4 turtle back on (Tim still needs to actually fix)
* Fix for THO version Loading issue 
* Fix bug validating CVX codes in Concept Maps
* Fixed issues with missing translation property, allow use of markdown to HTML by external classes (#2308)

## Other code changes

* Improve SearchParameter Component rendering
* Fix bugs in ConceptMap / Profile rendering
* Include @AfterAll nulling of static fields to clear memory
  * Test clean up to reduce memory load.
* Fix typo in cardinality tooltip text
* More work on Regex Checkstyle checking
* Terminology cache rework
* Fix repetition of XML constant + SonarQube naming issues in OpenEHR
* Spit out Plant UML when debug is on
* Manage dependency of inherited opentelemetry
* Liquid enhancements: 
  * Manage encoding in properties + manage and update build plugins
  * Include encoding info for surefire plugin
  * Remove argline entry for encoding
  * Added additional capabilities into Liquid engine to support full Liquid (with exception of Map and Where)
  * Throw errors + catch parse errors in tests + Messages placeholders
* More I18n work
