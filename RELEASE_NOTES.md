## Validator Changes

Post DevDays Release - many significant changes!

* Add ```-watch-mode``` parameter (See [doco](https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-Watchmode))
* Start checking constraint expressions defined in profiles
* Start checking ElementDefinition.mustHaveValue and ElementDefinition.valueAlternatives
* Start validating derived questionnaires 
* Tighten up checking on FHIRPath - enforce use of ```'```, and don't accept ```"``` for string delimiters
* Add ```-allow-double-quotes-in-fhirpath``` parameter ([doco](https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-LegacyFHIRPathSetting))
* Fix error when validating profiles that mix canonical() and Reference() types
* Fix incomplete support for ```-display-issues-are-warnings``` parameter
* Fix broken NullFlavor binding in R4 
* Fix various NPE errors doing value set validation (+ logging tx operations)
* Minor performance improvements to start up time

## Other code changes

* Add CodeQL to the build process
* Various NPE fixes
* Add getValueAsString(TemporalPrecisionEnum) method to date/time types
* Fix rendering for unresolvable ValueSets
* Remove r4b eclipse project files
* Upgrade multiple dependency libraries (per CodeQL)
* Only record sorting errors when generating snapshots when debug mode is on
* Tighten up SSL certificate checking 
* Partial refactor of CLI parameter handling 
* Fix path regex (per CodeQL)
* Remove erroneous logging from conversion tests
* Rendering improvements for various profile related extensions
* More work on TxTests operation (lenient wrt extensions)