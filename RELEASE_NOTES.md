## Validator Changes

* Improve language on constraint error message + add expression checking for SQL on FHIR project

## Other code changes

* Fix uuid() executing StructureMaps and don't throw errors processing StructureMaps
* Add support for test folder in NPM packages
* Fix rendering of XML Attributes in profiles
* Add support for hosts to manage certificate resolution using ISignatureServices + fix issue matching type names when validating logical models
* Make sure snapshots are generated when fetching types
* Workaround issue where R5 build wrongly adds ele-1 to base
* Fix conversion issue associated with ConceptMap.element.target.equivalence in versions previous to R5 (use proper extension URL, and move extension so it can be a modifier. And fix for modifierExtension handling)
* Fix birthDate editing in CmdLineApp


