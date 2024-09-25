## Validator Changes

* Validator supports R6 from now on (using last stable release)
* Set default language to tag not display
* Handle tx server issues better
* Do not use server piecemeal when validating complex value sets
* Add support for -txCache parameter

## Other code changes

* Add support for R6 to R4 version enumeration
* Fix SCT link to include version and point to the right place
* Add response time to tx log
* Allow for code to turn off use of cache-id on tx interface (for debugging)
* Support n/a for tx cache folder
* Update tx cache for tests
* Add more logging for too costly validation
* Fix xml annotation suppression
