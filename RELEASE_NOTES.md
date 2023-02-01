## Validator Changes

* Fix for NPE rendering resources
* Consider CanonicalResource to be a CanonicalResource when validating profile references 
* Work around error in R5 sdf-29 invariant


## Other code changes

* XHTML processing: Cater for "." in XML element and attribute names
* Handle R3 encoding of primitive values when validating profiles
* Improve error messaging when validating StructureDefinition
* Temporary Support for MedicationStatement in R5
* Work around for Identifier.use = ? in THO R5 package (old error)
* Rework Package API to allow for authentication on package servers
* Structure mapping now finds source Structure Definition by URI and sets ParserBase logical property appropriately.
* DOn't convert ig-r4 when converting package versions
