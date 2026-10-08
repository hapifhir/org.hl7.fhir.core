## Validator Changes

* Fix code system supplement content (designations, properties) being missed once the supplements are merged into the code system
* Check that a StructureDefinition only defines new elements inside an element with an abstract type (e.g. BackboneElement) - the children of an element with a concrete type can only constrain the elements the type already defines
* Fix the FML parser not setting the resource definition on the StructureMaps it parses
* Package cache: don't delete temporary package folders that another process sharing the cache may still be installing into (only folders more than an hour old are cleaned up)

## Other code changes

* Fix R4 and R4B StructureMap conversion of the group type mode 'none'
* XhtmlParser: add parse(File) - reads the file as UTF-8, and closes it when done
* Fix the terminology client looking for R5 resource classes when fetching resources from a terminology server
