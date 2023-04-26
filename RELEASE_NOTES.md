## Validator Changes

Note: This validator release is accompanied by a new release of tx.fhir.org, and earlier versions 
of the validator will not perform validation correctly for some valuesets and languages. This is 
in effect a mandatory upgrade

* Major **Breaking** change: test multi-lanugage support on the terminology service API, and make many fixes.
** This release also includes full support for supplements providing designations and properties
* Add support for -install operation to install packages and generate snapshots while at it (support simplifier packages in sushi)
* Add support for ```lang-transform extract``` and ```-lang-transform inject``` to the validator (start of multi-lingual implementation support)
* Add support for -tx-tests to validator
* Change settings file to fhir-settings.json in .fhir, instead of fhir-tools-setting.ini (see [here](https://confluence.hl7.org/pages/viewpage.action?pageId=35718580#UsingtheFHIRValidator-FHIRSettings) for documentation)
* Add provisional support for running without a network: -no-network. Beware: this is not fully tested at this point
* Warning not error when the code system isn't known validating questionnaires
* Fix up loading of IG bundles
* Work around issue with R5 path in extensions pack

## Other code changes

* Code to support translation functionality
* Partial fix for problem parsing maps from previous versions
* Fix Code System rendering for supplements, and when there's 1..2 display translations
* Remove spurious header from ConceptMap rendering
* Return ID part correctly when FhirPath expression result is converted to string
* fix problem with leaf rendering in profile driven renderer
* Fix R4B tests to be based on R4B
* fix index error validating HierarchicalTable
* fix NPE in requirements renderer
* Fix NPE in code generator
* Rework package cache manager - add testing mode
* Add link to questionnaire rendering questionnaireResponse + Fix access violation rendering questionnaire
* Fix bugs generating narratives
* Defining the existence of R6
* i18n framework for HTML generation in renderers - step #1
* Re-org validation testing to be more memory efficient
* Better error handling loading resources
* Restore broken R4 loading
