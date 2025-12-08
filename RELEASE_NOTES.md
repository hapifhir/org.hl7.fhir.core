## Validator Changes

* Improve error message for multiple version matches
* Add Globals.date in test factory
* Remove duplicate messages (#2122 and #2126)
* Fix NPE bug loading NpmPackage
* Add new validator parameter -check-references-to
* Add support for $validate-code with Coding Properties
* Fix value set expansion for value sets with Coding properties
* Fix issue with wrongly including warnings in $validate-code message
* Version mismatch for unversioned code system references in value sets is a warning not an error unless CodeSystem.versionNeeded is true
* Warning when a code system is not supported
* Support implicit value sets better when routing to tx ecosystem

## Other code changes

* Move digsig strings to constants
* Don't scan data folder when loading NPM packages unless specifically requested
* Mark generated narrative with data-fhir=narrative in IG-Publisher mode
* Add support for -sct in validator test cases
* Fix issue with reindexing packages unnecessarily
* Fix header order problem rendering value sets with associated mappings
