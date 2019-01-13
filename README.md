HAPI FHIR - HL7 FHIR Core Artifacts
===================================

# Building this Project

This project uses [Apache Maven](http://maven.apache.org) to build. To build:

```
mvn install
```

Note that unit tests will run, but are currently not set to fail the build as they do not all pass. This is being worked on.

To skip unit tests:

```
mvn -Dmaven.test.skip install
```
