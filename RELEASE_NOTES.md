## Validator Changes

* Add support for ND-JSON. Note that the validator is not expected to perform well on large ND-JSON files (or any other file type)
* Significant change: the validator was not checking for the end of the input when parsing a JSON resource finished. It will now start giving errors when JSON continues once the object is complete 
* Add support for the create object syntax in FML when validating FML
* Improved error message when supplement url used instead of code system URL

## WHO Translation Project 

* Add complete dutch translations (Thanks Alexander Henket)

## Other code changes

* Fix various rendering problems leading to non-unique html anchors
* Fix for unrendered data types
