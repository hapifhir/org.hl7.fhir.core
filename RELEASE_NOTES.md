## Validator Changes

* Performance: `ValidationEngine.fetch()` keeps the resources of the context it converted to the element model, and returns a copy on each call, instead of converting the resource (compose to JSON and parse) every time. Invariants such as `'http://.../ConceptMap/x'.resolve()` fetch the same resources for every instance
* Performance: the OID registry (`oidregistry.csv`) is loaded once, instead of for every `InstanceValidator`

## Other code changes

* no changes

