## Validator Changes

* Show message ids in validator (-show-message--ids)
* Fix bug where message id not showing for slicing messages
* Add advisor documentation (not yet functional)
* Fix issue checking package currency for #current packages
* Add warning when code system is marked complete but has no content
* Fix bug processing adding discriminators in derived profiles
* Break valueset concept validation into multiple smaller batches for performance reasons

## Other code changes

* More work on translations in IGs
* Override inheritance of HAPI's old maven-compiler-plugin
* do not use loadPackageFromCacheOnly from outside cache manager
* Fix issues with rendering example scenario
* refactor sql view validation to fix NPE
* Fix misc warnings flagged by builds (#1772) + TRIVY typo
* Bump codeql actions to v3
* Bump checkout action to v4
* Bump commons.io to 2.14.0 (#1771)
* Workaround for ghcr rate limiting of trivy db downloads (#1770)
* Add VSACfinder (template for package analysis)
* Fix github urls
* Spelling fixes
