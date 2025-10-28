## Validator Changes

* Remove apikey from tx log
* Fix error validating profile reference in extension context
* Fix issue with slice discriminators checking compliesWith
* Fix issue with type matching when validating structure maps
* Validate display names in value sets
* Fix version comparison code to avoid semver failure

## Other code changes

* Fix npe in valueset expansion infrastructure
* NPE fix rendering obligations
* Add sql-on-FHIR test cases 
* Adjust representation of excluded elements in profiles
* Publisher mode Rapido Support code
* Fixing NPE in repackager
* RDF / Shex work:
  * use fhir:v with xhtml
  * keep object properties lower cased
  * upper case class names & shapes, add version & unit test
  * upper case class names in Turtle + ShEx, annotate ShEx version
  * fix xhtml error writing ttl
