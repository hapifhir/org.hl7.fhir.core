Validator:
* Better validation of bad references (and fix NPE)
* Rework output to be more informative and cleaner 
* Fix bugs in validation of nested bundles 
* Fix bug loading package with no specified version
* fix bugs loading discovered packages on the fly
* Validator now supports logical models in XML wkith no namespaces

Other code changes:
* Add version conversion for AllergyIntolerance (1.2 <-> 3.0 & 1.2 <-> 4.0)
* Add version conversion for MedicationRequest
* Fix rendering of documents 
* fix for not rendering null values in patterns for must-support view

