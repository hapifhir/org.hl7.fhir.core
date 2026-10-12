## Validator Changes

* Performance: `resolve()` in FHIRPath expressions fetches each URL once per validation (through the fetch cache of the validation, like references), and `ValidationEngine.fetch()` keeps the last 100 resources of the context it converted to the element model (`setFetchCacheSize()`, 0 to keep none), and returns a copy on each call, instead of converting the resource (compose to JSON and parse) every time. Invariants such as `'http://.../ConceptMap/x'.resolve()` fetch the same resources for every instance
* Performance: the OID registry (`oidregistry.csv`) is loaded once, instead of for every `InstanceValidator`; the shared registry is unmodifiable

## Other code changes

* Performance: the serialisers (JSON, XML, RDF) check the model context of the resource or type they compose (`Base.checkModelContext`), instead of walking the whole tree on every compose (`assertModelContext`); the whole tree is checked with an `assert` (`hasConsistentModelContext`), in the test suites

