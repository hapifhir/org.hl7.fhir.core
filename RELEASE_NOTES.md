## Validator Changes

* Fix up path management in the validator for resolving references in Bundles
* Add support for defineVariable in FHIRPath
* Fix problem with CDA element having multiple types
* Fix problem with 'is' not working in FHIRPath for CDA types
* Fix issue processing CDA generic type names
* Fix for NPE processing tx server response
* Add support for code system supplements when communicating with tx server

## Other code changes

* OSGI: make sure JUnit 4 and 5 dependencies are optional (#1596) (Also removed duplicate managed versions of JUnit 4.13.2 and mockwebserver 4.11.0)
* Render CapabilityStatement.imports (and instantiates)
* Terminology Service Tests - minor improvements for running in HAPI, add $lookup & $translate support, create R4 clone
* Add support for $translate to terminology client
* More i18n work in rendering context (WHO project)
* Add isServerSide for seeing if code systems are only supported on the server
* Fix R4B loading issue that lead to wrong web paths for R4B resources
* Fix problems rendering Binary files in IGs
* Add support for rendering logical URIs
* Remove path.toFile()

## Security

* Finish moving all local file access to go through ManagedFileAccess

## WHO Internationalization work

* More work on date rendering



