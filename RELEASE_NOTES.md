## Validator Changes

* Issues are only raised against preferred bindings when they are defined in profiles (or in IG publisher)
* Better error handling regenerating packages
* Add ability to suppress errors for missing resource ids
* Handle Regex ReDos error in terminology services
* Handle contained resources in value sets
* Add support for op = CHILD in value set filters
* fix bug choosing incorrect server for implied value sets
* fix bug choosing correct snomed server when value sets are in play

## Other code changes

* make external tx tests multi-threaded
* various fixes for terminology test framework
* Add ability to suppress validation by message parameters
* Fix json comparison bug
* render type characteristics
* Fix mapping representation for http urls
* Control validation of FHIRPath functions
* Fix missing assets and malformed icon URLs in comparison output
* Add JVM specific tests for DateTimeUtil
* Add setting for regex timeout in FHIRPathEngine
* Add Enable-Native-Access to generated jar (Suppress SQLite java warning)
* Update Various Dependencies
