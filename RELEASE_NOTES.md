Validator:
* Add NL translations
* Fix validation of extensions on patterns 
* Validation of cardinality on address-line elements containing pattern elements fixed
* Ensure that validator creates errors on example urls by default
* Add -allow-example-urls option to the validator
* Fixed issue where when validating with no terminology server and a value set with only an expansion (no compose), the 'inferred' code system wasn't being populated and validation was then failing on a coding with no specified code system
* when validating value sets, use CodeSystem/$validate-code not ValueSet/$validate-code

Version Conversion Fixes:
* add copying of aggregation mode for conversion from 50 to 30 
* add test for Observation conversion from 10 to 40
* add procedures conversion form dstu2 to r4
* add medication conversion from dstu2 to r4
* fix obscure issue converting discriminators from R2B to R4/5

Code Changes:
* Adding Maven exec to test validation cli jar
* Add SIDUtilities and clean up SID handling code across the code base
* fix rendering bug on references
