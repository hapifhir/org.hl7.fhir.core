## Validator Changes

* Bundle reference resolution: the R5 rules for resolving relative references in a Bundle now apply to all FHIR versions. A relative reference (e.g. `Patient/123`) is only resolved against the fullUrl of the entry that contains it when that fullUrl is a RESTful URL. In a bundle with `urn:uuid:` fullUrls (common in R4 documents and messages) such references are reported as unresolvable (information), with a warning when an entry matches by type and id, and in documents they may now fail to resolve. The setting that controlled this (`-r5-bundle-relative-reference-policy` on the command line, the `r5BundleRelativeReferencePolicy` server parameter, and `ValidationOptions/ValidationEngine/InstanceValidatorParameters.get/setR5BundleRelativeReferencePolicy`) has been removed - passing it is now an error
* txTests: keep the expansion-issue extension when scrubbing responses, so the 200 path of the invalid-code expansion tests can pass

## Other code changes

* no changes
