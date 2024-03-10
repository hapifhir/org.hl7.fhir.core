## Validator Changes

* Add validation for CodeSystem Properties and ValueSet filters
* More validation for Code Systems: contained code systems, supplement cross checks
* Add more validation around ValueSet.compose.include.system - must be a proper URL, and not a direct reference to a supplement
* HL7: Don't require HL7 publishing status on contained resources
* Don't walk into nested bundles when validating links in bundles
* fix up implementation of notSelectable in value set filters
* Add check for multiple version matches for a versionless canonical reference

## Other code changes

* Fix narrative generator generating duplicate anchors (prefix 'hc')
* exclude .DS_Store from generated zip files
* Add cross-version support extension
* Add ConceptMap utilities in support of cross-version module
