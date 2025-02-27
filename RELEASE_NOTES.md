## Validator Changes

* Rework -re-package to actually work
* Fix bug where reslicing not being processed properly when parent profile already sliced the element
* Improve tx test result message
* Prohibit '.', $ and | in SearchParameter.code.
* Rename http.disabled + refactor proxy setting (#1916)

## Other code changes

* Fix up ResourceWrapperR4 to work properly, and test it
* Add _datatype slice when converting extensions to R4
* Fix consistency problem in name presentation generating slices
* Fix profiles & tags being omitted rendering resources
* Clean up confusing message in slice processing
* Update test cases for Java 21 changes to date formats
* Regenerate PO files

