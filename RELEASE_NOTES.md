Validator Fixes:
* Support auto-determination of the version of FHIR to use when using the java validator
* auto-load packages from the package server when references to profiles etc are encountered
* Support better validation of version specific profiles in meta.profile 
* look for references inside other parameters in Parameters resource

Other Code changes:
* Rendering: add rendering for Parameters resources 
* Rendering: refactor of resource resolution code to support Parameters
* General clean up of rendering consistency & implement additional details when rendering (including patient summary)
* Rendering: major overhaul of DiagnosticReport rendering
* Fix NPE bug in value set comparison


TODO before commit:
* check version of contained resources 
* review validation of CanonicalResource.url

