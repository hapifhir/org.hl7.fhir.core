## Validator Changes

* Find value sets on tx server if not tx.fhir.org
* Do not send Content-Type header with GET requests for tx servers
* Fix npe validating code system
* Support discriminator by position
* Don't check type characteristics for unknown types

## WHO I18n Project

* Fix typos in phrases, and fix up handling of apostrophes in messages without parameters
* Test and fix for single quote escapes in I18n
* Create and test transifex configuration

## Rendering Changes

* Fix contact rendering to work properly
* Fix issue resolving contained resource rendering DiagnosticReports etc
* Handle case where Contact.value has extensions instead of a string value
* Render Parameterised types
* Fix bug with LOINC Code row showing wrongly in Profile Details view
* Partial implementation of type parameters
* Fixed rendering of actor-specific obligations, added elementIds to obligation narrative rendering
* Corrected ObligationsRenderer to handle multiple actors and multiple codes.  Also got obligations with elements to render properly (which means knowing whether you're on a table page or definitions page, what tab you're on, and whether the element for the obligation is in-scope for that tab (so you know whether to hyperlink or not).  Had to make links on the tables point to definitions because table anchors are not unique.

## Other code changes

* split out Base.canHavePrimitiveValue() from Base.hasPrimitiveValue()
* Refactor how observation profiles are registered in order to generalise management of extra profiles
  * Use validation policy to implement Observation profile rules
  * Rework validation policy management in standalone validator
* Try deploying javadoc with SNAPSHOT
* Add utility to unpack the spec.internals file
* v2 in FHIR tests