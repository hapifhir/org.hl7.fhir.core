## Validator Changes

* accept regex on ElementDefinition and ElementDefinition.type, and an error for regex on ElementDefintion.type (though core packages have it on the wrong place)
* fix handling of cross-version extensions on choice elements
* fix OID validation (accept 1.3.88 GTIN OID)
* only consider bindable types when checking for multi-type bindings

## Other code changes

* Fix definitions in ListResource ("List" not "ListResource")
* introduce fhir-tools-settings.conf (see https://confluence.hl7.org/display/FHIR/Using+fhir-tool-settings.conf)
* Rendering fixes & improvements for Questionnaire and Patient and partial dates
* improvements to relative link handling in markdown when generating snapshots 
* updates to package tools for changes to package.json#type (see https://confluence.hl7.org/pages/viewpage.action?pageId=35718629#NPMPackageSpecification-Packagemanifest)
* fix semver handling for tags in versions 
* Bump mockito and bytebuddy versions for Java 17 compatibility & fix Kotlin ref
