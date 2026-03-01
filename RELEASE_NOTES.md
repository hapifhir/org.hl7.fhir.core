## Validator Changes

* Fix date/time validation errors for fixed, pattern, minValue and maxValue
* Add validator parameters: check-display and resource-id-rule
* Some performance improvements
* Fix processing errors returned from tx server
* Trace state of profile when checking value set status
* Fix error handling if no server when checking inferred systems
* Supplement handling fixes - only process when marked as lang-pack or explicitly invokd
* Fix problem choosing correct server for code systems not fully supported by server (Only use a terminology server if really supports a code system)
* Rework handling of imported value sets in exclude statements

## Other code changes

* Rework resolveReference() to support logical references
* Speed Improvements:
  * Add getDefinitionsVersion() to IWorkerContext
  * FHIRPathEngine optimization
  * Perfomance improvement for getResourceNames()
  * minor speed improvement building package indexes
  * Don't try expanding when inferring systems
* Remove spurious error check in Context loading code
* Fix consent renderer making non-linkable URLs hrefs
* Fix issue cloning contexts
* rebuild tx cache for changes to terminology server
