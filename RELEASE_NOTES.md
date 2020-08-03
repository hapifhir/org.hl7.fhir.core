Validator Fixes:
* better validation of external references. Note: this is a potentially significant change: things that were called ok before may not be now, and things that were not ok before may become so, depending on the interplay between this and auto-load, further work may be needed here 
* Support better validation of version specific profiles in meta.profile. This may also find new errors that were not previously being found
* Support auto-determination of the version of FHIR to use when using the java validator
* auto-load packages from the package server when references to profiles etc are encountered
* look for references inside other parameters in Parameters resource
* no validation for CanonicalResource.url (further work needed)

Other Code changes:
* Rendering: add rendering for Parameters resources 
* Rendering: refactor of resource resolution code to support Parameters
* General clean up of rendering consistency & implement additional details when rendering (including patient summary)
* Rendering: major overhaul of DiagnosticReport rendering
* Fix NPE bug in value set comparison


TODO before commit:
* check version of contained resources 


