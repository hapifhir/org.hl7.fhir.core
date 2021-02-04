# HAPI FHIR - HL7 FHIR Core Artifacts

| CI Status (master) | 
| :---: |
| [![Build Status][Badge-BuildPipeline]][Link-BuildPipeline] |

This is the core object handling code, with utilities (including validator), for the FHIR specification. 
included in this repo: 

* org.fhir.fhir.utilities: Shared code used by all the other projects - including the internationalization code
* org.fhir.fhir.r5: Object models and utilities for R5 candidate (will change regularly as new R5 candidates are released)
* org.fhir.fhir.r4: Object models and utilities for R4
* org.fhir.fhir.dstu3: Object models and utilities for STU3
* org.fhir.fhir.dstu2: Object models and utilities for STU2
* org.fhir.fhir.dstu2016may: Object models and utilities for an early STU3 candidate used by some implementers
* org.fhir.fhir.convertors: Code to convert between versions, and other version indepedence code - uses all the above projects
* org.fhir.fhir.validation: The FHIR Java validator
* org.fhir.fhir.validation.cli: Holder project for releasing the FHIR validator as as single fat jar (will be removed in the future)

### CI/CD

All integration and delivery done on Azure pipelines. Azure project can be viewed [here][Link-AzureProject].

### Current Versions 
| Project | Current Release | Latest SNAPSHOT |
| :---: | :---: | :---: |
| org.hl7.fhir.validation.cli | [![Release Artifacts][Badge-r4SonatypeRelease]][Link-cliSonatypeRelease] | [![Snapshot Artifact][Badge-cliSonatypeSnapshot]][Link-cliSonatypeSnapshot] |
| org.hl7.fhir.validation | [![Release Artifacts][Badge-validationSonatypeRelease]][Link-validationSonatypeRelease] | [![Snapshot Artifact][Badge-validationSonatypeSnapshot]][Link-validationSonatypeSnapshot] |
| org.hl7.fhir.dstu2 | [![Release Artifacts][Badge-dstu2SonatypeRelease]][Link-dstu2SonatypeRelease] | [![Snapshot Artifact][Badge-dstu2SonatypeSnapshot]][Link-dstu2SonatypeSnapshot] |
| org.hl7.fhir.dstu2016may | [![Release Artifacts][Badge-dstu2016maySonatypeRelease]][Link-dstu2016maySonatypeRelease] | [![Snapshot Artifact][Badge-dstu2016maySonatypeSnapshot]][Link-dstu2016maySonatypeSnapshot] |
| org.hl7.fhir.dstu3 | [![Release Artifacts][Badge-dstu3SonatypeRelease]][Link-dstu3SonatypeRelease] | [![Snapshot Artifact][Badge-dstu3SonatypeSnapshot]][Link-dstu3SonatypeSnapshot] |
| org.hl7.fhir.r4 | [![Release Artifacts][Badge-r4SonatypeRelease]][Link-r4SonatypeRelease] | [![Snapshot Artifact][Badge-r4SonatypeSnapshot]][Link-r4SonatypeSnapshot] |
| org.hl7.fhir.r5 | [![Release Artifacts][Badge-r5SonatypeRelease]][Link-r5SonatypeRelease] | [![Snapshot Artifact][Badge-r5SonatypeSnapshot]][Link-r5SonatypeSnapshot] |

### Building this Project
This project uses [Apache Maven](http://maven.apache.org) to build. To build:
```
mvn install
```
Note that unit tests will run, but are currently not set to fail the build as they do not all pass. This is being worked on.

To skip unit tests:
```
mvn -Dmaven.test.skip install
```
### Publishing Binaries

An brief overview of our publishing process is [here][Link-Publishing].

For more detailed instructions on cutting a release, please read [the wiki][Link-PublishingRelease]

### Download
##### org.hl7.fhir.validation.cli
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>org.hl7.fhir.validation.cli</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'org.hl7.fhir.validation.cli', version: '(latest version)'
```

##### org.hl7.fhir.dstu2
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>hapi-fhir-structures-dstu2</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'hapi-fhir-structures-dstu2', version: '(latest version)'
```

##### org.hl7.fhir.dstu3
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>hapi-fhir-structures-dstu3</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'hapi-fhir-structures-dstu3', version: '(latest version)'
```

##### org.hl7.fhir.r4
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>hapi-fhir-structures-r4</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'hapi-fhir-structures-r4', version: '(latest version)'
```

##### org.hl7.fhir.r5
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>hapi-fhir-structures-r5</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'hapi-fhir-structures-r5', version: '(latest version)'
```

### Maintenance
This project is maintained by [Grahame Grieve][Link-grahameGithub], [James Agnew][Link-jamesGithub] and [Mark Iantorno][Link-markGithub] on behalf of the FHIR community.

[Link-AzureProject]: https://dev.azure.com/fhir-pipelines/fhir-core-library
[Link-BuildPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=29&branchName=master
[Link-SnapshotPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=17&branchName=master
[Link-dstu2SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu2&v=LATEST "Sonatype Snapshot"
[Link-dstu2SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu2&v=LATEST "Sonatype Release"
[Link-dstu2016maySonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu2016may&v=LATEST "Sonatype Snapshot"
[Link-dstu2016maySonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu2016may&v=LATEST "Sonatype Release"
[Link-dstu3SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu3&v=LATEST "Sonatype Snapshot"
[Link-dstu3SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.dstu3&v=LATEST "Sonatype Release"
[Link-r4SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r4&v=LATEST "Sonatype Snapshot"
[Link-r4SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r4&v=LATEST "Sonatype Release"
[Link-r5SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r5&v=LATEST "Sonatype Snapshot"
[Link-r5SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r5&v=LATEST "Sonatype Release"
[Link-cliSonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=LATEST "Sonatype Snapshot"
[Link-cliSonatypeRelease]: https://github.com/hapifhir/org.hl7.fhir.core/releases/latest/download/validator_cli.jar
[Link-validationSonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation&v=LATEST "Sonatype Snapshot"
[Link-validationSonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation&v=LATEST "Sonatype Release"
[Link-grahameGithub]: https://github.com/grahamegrieve
[Link-jamesGithub]: https://github.com/jamesagnew
[Link-markGithub]: https://github.com/markiantorno
[Link-Publishing]: https://github.com/FHIR/fhir-test-cases/wiki/Publishing-Binaries
[Link-PublishingRelease]: https://github.com/FHIR/fhir-test-cases/wiki/Detailed-Release-Instructions

[Badge-BuildPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_apis/build/status/Master%20Branch%20Pipeline?branchName=master
[Badge-SnapshotPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_apis/build/status/Module%20SNAPSHOT%20Publisher?branchName=master
[Badge-dstu2SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2.svg "Sonatype Releases"
[Badge-dstu2SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2.svg "Sonatype Snapshots"
[Badge-dstu2016maySonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2016may.svg "Sonatype Releases"
[Badge-dstu2016maySonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2016may.svg "Sonatype Snapshots"
[Badge-dstu3SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3.svg "Sonatype Releases"
[Badge-dstu3SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3.svg "Sonatype Snapshots"
[Badge-r4SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r4.svg "Sonatype Releases"
[Badge-r4SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r4.svg "Sonatype Snapshots"
[Badge-r5SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r5.svg "Sonatype Releases"
[Badge-r5SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r5.svg "Sonatype Snapshots"
[Badge-cliSonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.cli.svg "Sonatype Releases"
[Badge-cliSonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.cli.svg "Sonatype Snapshots"
[Badge-validationSonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.svg "Sonatype Releases"
[Badge-validationSonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.svg "Sonatype Snapshots"
