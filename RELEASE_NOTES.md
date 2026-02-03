## Validator Changes

* Add support for imposing a timeout on the validator
* Check for circular definitions when validating Structure and Operation definitions
* Update compliesWith checker to handle value set bindings
* Fix bug where slice .min is not set to zero for multiple slices when slicing is closed
* Fix bug in version checking with 'current' and 'dev' when loading packages
* fix logic checking for canonical resources when they are custom resources
* Remove spurious warning in the console log about loading simplifier IGs
* fix precedence error in FHIRPath implementation
* Fix definitions of -ig, -cert and -matchetype parameters on the CLI
* Allow -allow-example-urls to work with true/false as well
* Use json when testing tx servers
* refactor http server and add commands for stop, loadIG and txtest

## Other code changes

* update language sources and fix some french phrases
* Add better support for extended operations in OpenAPI (#2278)
* Fix up json logic for suppressing resourceType when rendering fragments
* Add identifier(s) to summary table when rendering resources
* Add support for rendering with messageIds rather than language specific message (translator troubleshooting)
* upgrade pubpack version
* Refactor OperationOutcome construction
* rebuild r5 tx cache for new terminology server
* Minor fixes to mini-terminology server for tx ecossytem tests compliance
* fix version tests
* general improvements to test robustness
* make version comparison more robust
* make json parsing more robust
* add format to terminology client
* Update junit5 to 5.14.0 and platform launcher to 1.14.0
* Bump ch.qos.logback:logback-core from 1.5.20 to 1.5.25
* Sync logback and logback-classic versions
* Fix dependency location error in POM
