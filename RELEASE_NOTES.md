Validator:
* Add date addition/subtraction to FHIRPath + add parsing comments
* Fix questionnaire mode parameter support for validator
* add extra debugging when valdiator can't fetch content to validate
* fix error setting up mapping log 

Other code changes:
* rename org.hl7.fhir.utilities.cache to org.hl7.fhir.utilities.npm
* report error locations for run time FHIRPath errors
* add search on IG registry to PackageClient
* add focus to FHIRPath function extensions
* fix rendering of definitions in CodeSystems
* fix error rendering bundles in bundles
