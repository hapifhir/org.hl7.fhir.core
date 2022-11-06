## Validator Changes

* Add support for R4B to validator (parts were missing)
* Fix bugs in Logical Model snapshot generation and validation (both instances and logical models themselves)
* Check min/max value for decimal values 

## Other code changes

* Fix broken links rendering questionnaires
* Fix issue with converting ActivityDefinition.kind between R5 and R4/R4B/R3 (+ update R5 code)
* Fixes to terminology cache management for test cases
* Process relative links in markdown in code descriptions when rendering value sets
* Fix issue with contained resource not always rendering consistently
* Fix bug where Element Model paths are not populated after preforming a transform
* Fix NPE rendering invalid bundles
* refactor Paramters.getParameter helper methods
* Rendering improvements for logical models
