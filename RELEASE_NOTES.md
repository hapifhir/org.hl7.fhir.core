## Security Notices 

* TODO: HTTP Authentication Notes
* This release of the Validator supports scoped packages (see [security advisory note](todo))

## Validator Changes

* Introduce HTTP client/server mode for performance when validating in pipelines
* Add support for scoped packages in package cache
* Fix bugs chasing package versioned references when no version supplied
* Fix snapshot generation for nested slices with contentReference (h/t glichtner)
* Add validation context to error output to help explain validation errors
* Fix bugs in expansion and validation when valueset includes two different versions of the same code system
* Various Performance Improvements
* Package Regenerator
  * Performance Improvements 
  * more robust against errors in FHIRPath expressions 
  * Don't produce duplicate value sets 
* Fix bug parsing with multiple profiles for a type
* fix bug validating codes with no server

## Other code changes

* The IWorkerContext has been changed, which impacts on all uses of the HAPI core library:
  * Introduce VersionResolutionRules when resolving versions for canonical references
  * Add Identifier when resolving References to support logical references 
  * Add the methods storeAnalysis/retrieveAnalysis for caching analysis of the loaded resources - caches are wiped when loaded content changes
  * Remove the NamingSystem related function in preference to using the analysis methods
* Fix NPE rendering Questionnaires 
* Expansion bugs: imported valueSet excludes ignored + expansion.total inconsistent
* Remove FTPClient, tests, and supporting dependencies
* Fix rendering bug where naming system resolution was a little random
* Fix bug where binding.valueSet extensions are lost in snapshots
* Add utility to help migrate packages to npmjs.org
* Renderer: fix duplicate ids in questionnaire pages in igs
* Fix problem where comparing profiles gets into an infinite loop
* Version updates: Java 17 minimum, + jackson, okio, okhttp-jvm and okhttp3
