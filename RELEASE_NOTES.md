## Validator Changes

* Significant improvement in performance of validation (10-100 fold for simple resources)
* Add output tracker to trask progress of validation (Validate %R against %P..........20..........40..........60..........80.........|)
* Alter per-1 to handle different precision on start/end
* Add support for a -jurisdiction parameter, preparing for jurisdictionally specific constraints in profiles
* Fix bug in snapshot generation where type slices on a mandatory element were all marked as mandatory
* Add warnings when potential matches are found when performing reference resolution in bundles

## Other code changes

* extend FHIRPath to support lowBoundary(), highBoundary() and precision()
* Fix for inefficiency in StructureMap engine
* Update version of PubPack used by the IGPublisher
* Handle scope on TestScript R4 <-> r5 conversion
* Fix bug converting extension context = Resource (R4 <-> R5 conversion)
* Update VSAC importer for changes to VSAC FHIR authorization
* Fix broken links in profile comparison due to cross version issues