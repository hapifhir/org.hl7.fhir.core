## Validator Changes

* Cross-check canonical version when there's an applicable version element when validating `ImplemenationGuide.dependsOn` or `ValueSet.compose.include`
* OperationDefinition: Cross check Operation Parameters with inputProfile and outputProfile
* Add support for filter by regex on property value in ValueSet definitions
* Add check for consistency across slices for types and must-support when validating profiles
* more validation url resolution exemptions
* Remove superfluous spaces validating ValueSet parameters in Questionnaire 
* Exempt `tel:` urls from being resolved in validator
* More URL validation improvements including checking the OID registry
* Fix source location tracking for FHIRPath expressions
* Add support for enforcing R5 policy on relative references in Bundle entries
* Fix bug where examples in other packages not being found on windows
* Add profile.compliesWith validation

## Other code changes

* Move CLI code to cli module
* General clean up of wrong assertions and badly expressed exceptions
* Fix discovered issues related to snapshot generation with slicing while investing how slicing works per extensive committee discussion
* Add support for sort in FHIRPath
* Improvements to txtester for R5 support
* Obligation Rendering improvements
* Don't produce links in narrative when they are definitely broken
* Add option to render value set expansion with OIDs instead of URIs for CDA users
* Add APPLY_PROPERTIES_FROM_SLICER constant for slicer processing, but set to false (preserve the investigative work)
* Version Bumps: poi ooxml to 5.4.1, apache poi to 5.4.0
* Fix various NullPointerErrors
* Fix format & version of version independent Snapshot tests
* update DicomPackageBuilder to conform it's documentation
* Add US gender location finder
* Add testing dependencies to POM
* Adjust logback configs for testing
