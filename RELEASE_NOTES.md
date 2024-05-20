## Validator Changes

* Fix bug processing extension with explicit type slicing
* Fix wrong language code from java locale
* Don't accidently hit other terminology servers for code systems handled natively by tx.fhir.org
* Validate Additional Bindings (provisional - usage context is todo)
* Improved system specific checking of value set filters - particularly LOINC and SNOMED CT

## WHO I18n Project

* Add importing translations to native resources
* Finish Migrating text phrases to i18n framework
* Fix bugs with loading translations (#1592)

## Security

* Move all network access to go through ManagedWebAccess
* More security documentation

## Other code changes

* Put jurisdiction in npm package.json
* Add testing ontoserver to test suite
* Fix NPE testing Ontoserver
* fix tx tester calling run ok when a filter is applied and tests fail
* Fix name of preferred when rendering AdditionalBindings
* Add AdditionalBinding version conversion in profiles
* Fix SNOWMED spelling
* Fix rendering of multiple imports in value sets
