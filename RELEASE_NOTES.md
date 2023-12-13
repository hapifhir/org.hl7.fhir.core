## Validator Changes

* Fix bug where validator doesn't actually validate web sourced input
* Fix narrative link validation and add id/idref validation
* Remove fhir-test-cases from Validator CLI JAR (#1497) (reduce size)
* Fix to CDA xsi:type validation per SD decision 
* Apply regex pattern to literal format if defined
* Improvements to vital signs related messages
* Fix R4 con-3 FHIRPath expression
* Fix bug loading packages with partially specified version that doesn't exist
* Fix for occasional missing warnings around bundle link validation
* Fix using wrong resource type when validating constraints in data type definitions during R6 build
* Fix NPE in validator processing CCDA examples
* Fix problem with version dependencies when loading npm packages directly as files
* Fix for SearchParameter validation using custom resource types

## Other code changes

* Bump commonmark version
* fix Utilities display of time periods (fixed width hour:min)
* Fix stated path for error when code not in value set
* Fix rendering of trigger definition using tables inside paragraphs
* Update VSAC importer to fix timeout issues
* Refactor FHIRPath java package
* Fix problem with profiled resources being called examples in IG publisher
* Remove dependencies for unused UI experiment (#1465)
* Remove AU connectathon 
* Include hamcrest dependency
* Fix breaking ValidationEngineTests
* Give kinder error message for missing param
* Fix commonmark group and bump version (#1500)
* Remove dep used for local testing
* Bump jackson & logback versions
* Fix StringType element properties not being copied in various Address, HumanName convertors
* Handle all initial value types when rendering Questionnaires
* Ensure Address.line[] element data is copied over
* Write locking on FilesystemPackageCacheManager
* Fix problems setting owning committee consistently
* Utility classes for fule system package cache pre-loading

