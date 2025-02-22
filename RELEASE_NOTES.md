## Validator Changes

* Fix detection of HL7 core vs affiliate specifications
* Fix bug failing to compare large valuesets correctly when generating snapshots
* Add ReferenceDestinationType to IPolicyAdvisor.policyForReference (breaking change)

## Other code changes

* Fix bug processing languages when processing value set from server
* Bump owasp dependency check version
* Rework how other version packages are generated, and recast extensions for older versions
* Improve Binary rendering
* Add support for R6 MolecularDefinition
* Fix bug rendering test plans
* Support R5 natively in txtests
* fix illegal URL on compositional SCT codes
* Add subscription Conversion R4 - R5
* Support for CDS-hooks extension type when writing json
