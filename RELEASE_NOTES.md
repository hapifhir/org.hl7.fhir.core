Validator:
* Fix NPE reading results of batch code validation
* Validate that binding references are present, and are for value sets 
* Fix output message when there's nothing to validate

Other Code Changes:
* fix for renderer on ElementModels rendering - follow contentReference
* fix for NPE rendering references to contained value setes in Questionnaires that don't resolve
* fix for NPE rendering parameters with no names
* fix for rendering bundles on ElementModels


