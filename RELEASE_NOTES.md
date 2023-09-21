## Validator Changes

* Significant Performance improvements parsing JSON resources 
* Refactor Type handling for faster performance
* Validate the stated publisher/WG/contacts for HL7 published resources
* Better error message when diff contains bad paths
* pass dependent resources to server and make sure cache-id is filled out properly in all contexts
* Fix error in FML parser parsing parameters
* Fix issue with dom-6 and contained elements (Internal ChildMap synchro issues)
* Better handling of errors from tx.fhir.org
* Fix bug checking for implicit value sets
* Fix bug checking of mixing snomed display types
* Reduce size of validatable concept map to 500 - for now + better handling of errors on server batches
* Improve UCUM validation BP rule

## Other code changes

* Fix up handling of includes in liquid templates
* Fix up rendering of profile names for abstract profile instantiations
* Improved rendering of codes in include when rendering valuesets
* Start generating .index.db as well as .index.json in packages for faster package reading
* Fix problem caching look up of implied value sets
* Add okio dependency for running vsac
