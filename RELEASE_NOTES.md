## Validator Changes

* Performance fix: Delay loading content when loading IGs
* CodeSystem validation around count and content
* Add checking around internal status consistency and across dependencies (draft/experimental/retired/deprecated)
* Improved error messages on server failure
* Fix bug in warning about No valid Display Names found
* Use Supplements when validating display names
* Fix issue in FHIRPath .combine focus handling 
* Check Extension fixed values for URLs - enforce consistency
* Fix R4 FML parser problem

## Other code changes

* Significant upgrade of version comparison for profiles/extensions, value sets, and code systems, and integration into rendering framework
* Many minor changes to terminology functionality (reconciliation with differences with OntoServer) including service protection 
  * Rename implySystem parameter to inferSystem per TI decision
  * rework how definitions are handled after discussion with Michael
  * add flat mode to tests for Ontoserver, and add experimental functionality
* fix rendering issue in subscription topic 
* Add a renderer for ExampleScenario
* Automatically render markdown in code system concept definitions
* Fix loading issues in test mode for simplifier packages
* Remove spurious logging in FHIRPath engine
* Fix addChild error in PEBuilder (#1343) + Add test case
* CPT Importer
* Dependencies fixed: okhttp, thymeleaf, and commonmark
* Xhtml fluent improvements + related XHtmlNode improvements
* Release new pubpack for new icons
* Json Object comparison: fix bug in arrays with multiple optional elements + improved error messages + support for external strings
* fix cross-version extensions web references where possible
