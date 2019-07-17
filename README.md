HAPI FHIR - HL7 FHIR Core Artifacts
===================================

[![Build Status](https://travis-ci.org/hapifhir/org.hl7.fhir.core.svg?branch=master)](https://travis-ci.org/hapifhir/org.hl7.fhir.core)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/hapifhir/org.hl7.fhir.core/badge.svg)](http://search.maven.org/#search|ga|1|hapifhir/org.hl7.fhir.core)


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

== Maintenance

This project is maintained by Grahame Grieve and James Agnew on behalf of the FHIR community.