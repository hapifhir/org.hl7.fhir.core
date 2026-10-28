## Validator Changes

* Fix races when several threads validate against the same definitions: parsed invariant and slice expressions and mustSupport use are kept in concurrent tables keyed by the definition, not written into its user data; a value set include's cached UUID is made under a lock; a Measure's parsed ELM is kept per validation

## Other code changes

*

*NOTE: This is a patch release with enhancements targeting HAPI-FHIR.*

