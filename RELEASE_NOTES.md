## Validator Changes

* Fix bug where some #refs are not resolved to the root of the resource in FHIRPath slicing evaluation
* Fix bug passing wrong type to tx server when using inferSystem
* Fix bug processing version of CodeSystem.supplements incorrectly
* Don't process wrong parent when processing snapshot of element with profiled type that is not reprofiled
* Fix typo in OID message
* Fix handling value set exclude filters
* Allow code system declared properties to be self-referential

## I18n changes

* More comprehensive internationalization phrase coverage reporting on project page
* Move many rendering phrases into i18n framework

## Rendering Changes

* Fix issue with unknown element rendering fixed value for Attachment
* Fix bug calculating value set expansion size for multiple imports
* Fix bug using wrong message for value sets that are too costly to expand
* Fix extension urls not being linked in tree view
* rendering improvements and remove static use of describeSystem
* Fix NPE rendering profile comparisons
* Fix bug where slicing and grouping gets mixed up rendering profile tree

## Other code changes

* Wrap general exception for IWorkerContext (Catch missed exception from HAPI)
* Shim interfaces and classes to support clinical reasoning project updates.
* Fix duplicate txServer getters and setters
* Use extension class on Exception to force try-catch blocks on checkCodeOnServer calls (#1609)
* rework OID handling for better consistency
* handle time outs doing vsac import (starlink obstructions)
