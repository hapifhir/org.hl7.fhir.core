## Validator Changes

* Performance: `ValidationEngine.fetch()` keeps the resources of the context it converted to the element model, and returns a copy on each call, instead of converting the resource (compose to JSON and parse) every time. Invariants such as `'http://.../ConceptMap/x'.resolve()` fetch the same resources for every instance
* Performance: the OID registry (`oidregistry.csv`) is loaded once, instead of for every `InstanceValidator`

## Other code changes

* Performance: the serialisers (JSON, XML, RDF) check the model context of the resource or type they compose (`Base.checkModelContext`), instead of walking the whole tree on every compose (`assertModelContext`)

