## Validator Changes

* Improve warning messages about collections in SQL ViewDefinitions
* Fix type evaluation of .item() in FHIRPath
* Revise message about unknown usage context on additional binding
* Add support for code generation
* Add check for # in CanonicalResource.version
* Fix problem parsing urls in cds-hooks formats
* Fix issues with output folder running tx tests
* Fix bug evaluating resolve() in contained resources when doing slicing

## Other code changes

* Fix NPE processing markdown
* Capture missing snapshot generation messages
* Track OID status
* Improve rendering of coded values
* update tests for changes to PE code generation
* Tx Tests: Add support for special header on specific tests 
* Tx Tests: Fix framework to handle diagnostics correctly
* Tx Tests: check http code in tx test cases
* Add support for NCI code rendering
* Adding missing lombok annotation (cannot build without it from scratch) (#1785)
* Remove Encounter Renderer
* Profile code generation fixes
* Add r4 code gen classes
* Draft work for tx server authentication (not landed yet)
* Move XXE safe SAXParserFactory and XMLReader instantiation to XMLUtil
* Bump commons-compress version
