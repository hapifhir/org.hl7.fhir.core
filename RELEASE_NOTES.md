## Validator Changes

* Add InstanceValidator.setEntryExecutor(ExecutorService) to validate the entries of a Bundle concurrently, keeping the Bundle's semantics. The validator's working state moves out of the elements' user data, and Element synchronizes the annotations it publishes. Also fixes a NullPointerException in checkTypeValue when the additional resources registry can't be read

## Other code changes

*

*NOTE: This is a patch release with enhancements targeting HAPI-FHIR.*

