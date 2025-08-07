## Validator Changes

* Fix to handle CodeSystems with content=not-present when validating ValueSets
* Remove maxLength from prohibited properties for elements in specializations
* Improve extension error messages
* Better handling of xsi:type errors in CDA
* improve error message for invariants when running inside Publisher
* Improve error message when code system is unknown
* Fix bug where displayLanguage overriding resource language when validating
* Fix HTML validation: Allow for col in colgroup
* Improve hash mismatch error
* Fix NPE in FHIRPath
* Fix bug in R5 client - wrong URL
* Add .debug(name) to FHIRPath engine for user convenience
* Fix problem with using wrong language code validating terminology (en-* didn't equate to null)
* Fix bug checking for extension contexts on the wrong structure
* Fix snapshot processing - missing inner elements in some circumstances
* Ignore binding missing for types that aren't bindable when checking profile CompliesWith extension
* Only report missing localization messages the first time (#2121)


## Other code changes

* Support for type operations rendering
* Add R4B support to validation tests
* Fix errors in CDA narrative handling
* Allow fetching the last milestone release
* Stop using deprecated CodeSystem comments extension
* Make closing elements hyperlinks too in marked up xml view
* Profile Version Transformation:
  * Fix error where ExtensionContext of 'CanonicalResource' is not preserved when adapting extensions for past versions
  * fix bug setting status on extensions for previous versions
* clean up language handling in tests and rebuild txcache
* Change R3 client to use JSON work around weird IO error
* fix encoding bug for ElementDefinition.examples
* fix experimental extension warning
* Update DicomPackageBuilder for package generation changes
* Make XIG link translatable
* fix bug mishandling sqlite index not being generated
* fix kindling extension handling
* fix rendering issue for main build
* updates to TXtester for reworking mode functionality with icd-11 tests coming
* better handling for missing description in derived IGs when generating snapshots
* Update rendering-phrases-fr.po
* Internal changes to cli parameter handling (phase #1): Fix double loading of compare ValidationEngine + move time tracking
