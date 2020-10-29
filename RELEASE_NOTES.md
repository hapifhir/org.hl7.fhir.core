Validator Changes:
* Mark it has an error if a JSON Array is empty 
* Don't make wrong error reports for profiling resources in bundles
* fix bug checking unfixed values for HumanName patterns
* fix bug checking patterns (missed in some circumstances)
* fix bug checking type of resources in bundles
* improve messages around cardinality errors in profiles
* add parameter -html-output for enhanced presentation of slicing information

Other code changes:
* Render binding description in profile tables if it doesn't contain paragraphs
* fix bug with wrong value for contentReference in derived profiles (profiles do not and cannot change the value)
