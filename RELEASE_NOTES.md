## Validator Changes

* Improve error message when CodeSystem Content is not present
* Fix error validating oids
* Add parameter type validation
* Fix bug where wrong server details are consulted when validating value sets
* fix bug generating snapshots for logical models with new elements on existing subelements
* Track errors from tx server more carefully
* Add validation of expansions
* Fix terminal output issues around ASCII extensions
* Remove wrong rule about not consulting the server for OID based code systems

## Other code changes

* Fix issues with canonical rendering
* Update for new pubpack release
* Fix version loading in tx test cases
* Add version dependency to json comparison utlitiy

