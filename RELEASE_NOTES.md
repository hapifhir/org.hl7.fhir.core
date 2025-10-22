## Validator Changes

* Add -ignore-list and -include-list when (re)generating packages 
* Check in element constraints for dependencies if -include-conforms-to is specified when (re)generating packages 
* Fix wrong derivation message checking StructureDefinitions
* Fix Error checking tx server version for old tx servers

## Other code changes

* Major reorganization of parameter handling on the command line
* Fix missing/broken LOINC links for implicit valuesets
* Pass diagnostics through to qa.html
* Add http header utiliity
