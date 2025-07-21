## Validator Changes

* remove pt_BR translations - just have Portuguese
* produce hint about deprecation when description uses the word 'deprecated'
* Change an unknown property in a CodeSystem to a warning not an error
* Produce a better error message for referencing a value set by it's OID
* Rework extension context validation for cross-version issues
* Fix problem parsing named elements for extensions in json (CDS-Hooks support)
* Add support for terminology operations in FHIRPath
* Fix error validating conditional references in Bundles
* Improvements handling Qunatity Datatype in FHIRPath expressions
* Remove IG load endpoint from server mode
* Warn about watch params when in server mode
* Suppress progress logging in server mode

## Breaking Changes in the HAPI Core

This release features several breaking changes in the HAPI Core interfaces that users of the HAPI core might need to deal with:

* Changing the way Host Applications register functionality with the FHIRPath Engine in R5
* Reorganising Extension Support
* Reorganising the R3 code base 

Note that we've only incremented the minor version this time because this is the first of a series of changes over the next 
couple of releases that complete the pattern. We'll do a major release at the end of the process. 

### FHIRPathEngine Changes R5

There as two general issues with the IEvaluationContext in previous releases: 
* the `%` the prefixes constant references was inconsistently removed prior to invoking IEvaluationContext.resolveConstant{Type}()
* The context in which the constant was being resolved wasn't available to the Host Application, and it sometimes matters

As a result, IEvaluationContext has been renamed to IHostApplicationServices, and the interfaces for 
resolveConstant() and resolveConstantType() have been changed, and the documentation in the interfaces
have been improved. `%` is no longer passed through when invoking either of them. 

In addition, there's a new parameter checkWithHostServicesBeforeHand on the FHIRPathEngine. If that 
parameter is false, the engine will not call the HostApplicationServices before trying to evaluate a 
property locally (only when it fails). if it's true, the HostApplicationServices will be consulted 
beforehand. Doing so is useful and dangerous, because you can override the meaning of a name. 

When you write code for the new interface, pay careful attention to the name behaviour and the new mode parameter.
Thorough  testing is called for. Note that there's a new base class for IHostApplicationServices that might
be useful, called BaseHostServices.

This change is only in R5, but we are considering introducing it in R4/R4B/R3.

### Reorganising Extension Support

The new Extensions Pack being balloted moves several Extension from the Tools IG to the Extensions Pack,
and in so doing, changes their URL. This is supported in the tools by cloning the URL to have a _NEW and and _OLD 
variant, and checking for the presence of both (but only writing the new one, when the extension is written somewhere).

Testing this made clear that having both org.fhir.hl7.r5.extensions.* and org.fhir.hl7.r5.utils.ToolingExtensions
was causing problems, and also that "ToolingExtensions" was a misnomer. The content of all 3 have been merged 
to tww new classes: org.fhir.hl7.r5.extensions.ExtensionDefinitions and org.fhir.hl7.r5.extensions.ExtensionUtilities.

This change is only in R5, but we are considering introducing it in R4/R4B. (R3, see below)

### Reorganising the R3 code base 

We have reorganised the R3 code base to split it into two parts: org.hl7.fhir.dstu3 and org.hl7.fhir.dstu3.support.
These changes are being introduced to reduce the surface area/code size/dependencies for people who just want 
to use the model classes. What remains in the base package is: 

* the generated model code 
* the format classes to read and write to json, xml, and turtle
* The FHIRPath engine
* Some useful utility classes for working with the model classes

Everything else has gone to the support package. That's not much code for DSTU3, and not may people are using it,
so this is low impact. Note that we haven't invested in stripping the maven dependencies yet, but we will.
But you should look anyway, because we're planning on making the same changes in R4, R4B and R5. 

Comments are welcome. 

## Other code changes

* Add processing of logical models when converting versions
* Add explicit break statements missing from conversion routines
* Improve rendering of UsageContext in Additional Bindings
* increase timeout on lookup
* Performance Improvements for the IG Publisher - careful loading terminology resources (allowedToIterateTerminologyResources)
* support styles and js in Xhtml fluent interface
* rework .index.db to generate it by injection
* Bump com.nimbusds:nimbus-jose-jwt from 9.37.3 to 10.0.2 (#2088)
* Bump org.apache.commons:commons-lang3 from 3.17.0 to 3.18.0 (#2089)
* Fix NPE in language translation processing
