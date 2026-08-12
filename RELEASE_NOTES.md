## Validator Changes

* language fix validating codes in value sets
* Setup batch handling for Supplement code validation
* Armour up code generator - safe from theoretical code attacks
* Secure fetchTheOldWay links (SSRF related issue)

## Other code changes

* remove unneeded thread invocation for regex
* Allow Suppression of dependencies when generating packages (for THO)
* Fix issue where factory generator picks up version from the wrong code system
* revisit validation batch handling generally
* remove thread check from JUnit tests
* fix bugs in ConceptMapRenderer
* add TestPlan renderer
* Set up registration for convertors
* fix problem with tx cache always changing
* Testing IG Convertors
* refactor parser and render registration in R5 code
* update resource generation code
* COPY in StructureMapUtilities.runTransform update to return a clone
* Share the HTTP connection pool across ManagedHTTPClient instances