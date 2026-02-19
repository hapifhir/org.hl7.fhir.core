## Validator Changes

Note: this version is synchronised with a major update to tx.fhir.org. 
Implementers SHOULD upgrade to this version immediately - this is the 
oldest validator version *supported* for use with the new server. On
the other hand, there's no change to the terminology server API - older
version of the validator SHOULD continue to work. But how some cases 
are handled - particularly around supplements - has changed.

* Update internal terminology server for new server on tx.fhir.org
* fix bug reporting wrong version when validating value sets

## Other code changes

* Fix stated version when rendering explicitly pinned canonicals
* Fix NPE converting bad property converting from R4 to R5
* fix NPE reading extensions with no value
* Add support for $related operation on terminology server
* fix case of forloop variable in liquid implementation
* Add facility for warnings to terminology test cases
* Give more format control over pretty json output
