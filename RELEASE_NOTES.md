## Validator Changes

* Change validator handling of cross-version extensions where required bindings on code exist (warning not error)
* Fix Server Mode Documentation
* Improve Error messages associated with testing compliesWith testing
* Update tests for profile compliesWith ValueSet logic to use server side logic on tx.fhir.org
* Implement Duration based validation for min/maxValue on date related types

## Other code changes

* Various Regex fixes for Denial of Service resistance
* Fix conversion problem with R5 value sets and filter operators not supported in R4
* Update expansion logic around fragments to conform to committee decision
* Add support for getValueSetRelationship to terminology clients
* Add features to PackageList to support IG replacing/withdrawal
* Improve WCAG compliance of rendering
