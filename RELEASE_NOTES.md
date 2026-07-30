## Security: SSRF Protection

{todo}

## Validator Changes

* Pass language to ecosystem when resolving code systems
* Don't retrieve a code system from a server and use it locally in place of consulting the server for validation/expansion
* Fix constant evaluation type checking in FHIRPath
* Fix up testing of server support for a code system, and don't persist failed resolutions between runs
* Fix error processing of erroneous response from tx.fhir.org
* Improve canonical URL resolution
* More regex protection tidy up
* Do not try to validate Endpoint.address as a definitional URL
* Add command for code generation for additional resources
* Clean up txTest parameters issue

## Other code changes

* Internal tooling for http/https requests now prevents server-side request forgeries, as well as the option to bypass these for custom configurations or testing.
* Delegate FHIRPath custom-function hooks (resolveFunction/checkFunction/executeFunction) to ITransformerServices in StructureMapUtilities
* Allow unknown resource types when parsing resources
* Render DiagnosticReport.presentedForm
* Fix mapping rendering  - no empty columns, no duplicate ids
* Fix NPE Rendering incomplete ratios
* Add support for new R6 release
* Language processing clean up
* Update cache after changing the way code systems are resolved
* Validation tests tidy up
* AR language fix
* Dependency updates: jansi -> 4.3.1, log4j -> 2.26.1
