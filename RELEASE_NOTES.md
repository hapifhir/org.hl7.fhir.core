## Validator Changes

*

## Other code changes

* Performance: load the OID registry once and share it, instead of reading and parsing oidregistry.csv for every OIDUtilities instance (about 9 ms for every InstanceValidator created)

*NOTE: This is a patch release with enhancements targeting HAPI-FHIR.*

