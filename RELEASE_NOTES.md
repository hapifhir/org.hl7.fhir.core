## Validator Changes

* Workaround for 'xml', 'json', 'ttl' in mime types after tx.fhir.org correction - see note below
* Fix bug where version variants were being ignored if their resource.id were the same

## Other code changes

* Use Turtle shorthand syntax for booleans, integers, and decimals
* Suppress some unwanted debug output
* Fix code lookup issue in kindling
* Add Group Compartment for R6
* More work on  version conversion
* Fix bug where modifierExtension types were being rendered differently
* Add candidate HCPCS importer

## Workaround

This validator corrects for a fix made in tx.fhir.org where 'xml', 'json', and 'ttl' 
are no longer erroneously considered to be valid mime type codes. These are considered
correct codes in the specification for versions R2-R5, but they're not. This 
is corrected in R6 - see [FHIR-48679 (Issue with invalid MIME types)](http://jira.hl7.org/browse/FHIR-48679).

As tx.fhir.org is now correctly saying they are not valid mime types, 
this release of the validator contains special logic to treat them as 
valid mime types for R2-R5. 

This means that if you are validating either CapabilityStatements or TestScripts,
this validator is somewhat of a manatory upgrade, though you have another choice:
use the policy advisor framework to turn off validation of the relevant elements.

Note the policy regarding FHIR Validator upgrades can be found here: 
https://confluence.hl7.org/spaces/FHIR/pages/35718580/Using+the+FHIR+Validator#UsingtheFHIRValidator-LimitationsofUse:

> older versions of the validator may suddenly stop working due to forced upgrades to the various system and network infrastructure components that the validator depends on (typically due to security notifications).

For further discussion, see [chat.fhir.org](https://chat.fhir.org/#narrow/channel/179239-tooling/topic/mandatory.20validator.20upgrade).