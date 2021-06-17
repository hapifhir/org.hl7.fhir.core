Validator:

* Add support for $index on aggregators in FHIRPath
* don't fail with an exception if an unknown resource type appears in contained resource
* improved validation for some value sets that are based on unknown code systems
* add the -verbose parameter, and add additional verbose messages
* CDA: Fix erroneous type validation on CDA templates

Snapshot generator:
* CDA: Suppress erroneous "Expansion" text appearing in view
* CDA: Don't delete binding information in snapshot for CDA bindable data types

Other code changes:

* Fix rendering of slices so type on slicer is not hidden
* Fix rendering for most resources - remove empty tables (e.g. text element, that shouldn't render)
* Fix NPE rendering code systems with some kinds of properties
* Improve rendering of questionnaires (icons, option sets)
* Rendering: add support for CodeableReference
* Rendering: Support binding mode and XML element information 


