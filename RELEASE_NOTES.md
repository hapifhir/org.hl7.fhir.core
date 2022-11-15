## Validator Changes

* Minor fix to jurisdiction output (+ handle case where JVM has no locale) 
* Add support for extensions parameter
* Make all error messages include version of underlying resource if available
* Accept display for code from ValueSet CLD if no code system available
* Various minor improvements to error messages 

## Other code changes

* Minor clean up in test cases
* Fix up i18n support to handle pluralization properly
* Refactor resource narrative generation rules (GenerationRules.X)
* Display resource type in generated narrative
* Add support for generating R4 and R4B packages
* Add support for generating XVer packages 
