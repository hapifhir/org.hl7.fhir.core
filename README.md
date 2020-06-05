# HAPI FHIR - HL7 FHIR Core Artifacts

### CI/CD 
| master Branch CI | SNAPSHOT Publisher |
| :---: | :---: |
| [![Build Status][Badge-BuildPipeline]][Link-BuildPipeline] | [![Build Status][Badge-SnapshotPipeline]][Link-SnapshotPipeline] |

All intergration and delivery done on Azure pipelines. Every successful merge to master branch will result in a new SNAPSHOT build being published to Sonatype. Azure project can be viewed [here][Link-AzureProject].

### Current Versions 
| Project | Latest SNAPSHOT | Current Release |
| :---: | :---: | :---: |
| org.hl7.fhir.validation.cli | [![Snapshot Artifact][Badge-cliSonatypeSnapshot]][Link-cliSonatypeSnapshot] | [![Release Artifacts][Badge-cliSonatypeRelease]][Link-cliSonatypeRelease] |
| org.hl7.fhir.r4 | [![Snapshot Artifact][Badge-r4SonatypeSnapshot]][Link-r4SonatypeSnapshot] | [![Release Artifacts][Badge-r4SonatypeRelease]][Link-r4SonatypeRelease] |
| org.hl7.fhir.r5 | [![Snapshot Artifact][Badge-r5SonatypeSnapshot]][Link-r5SonatypeSnapshot] | [![Release Artifacts][Badge-r5SonatypeRelease]][Link-r5SonatypeRelease] |

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
This project is maintained by [Grahame Grieve][Link-grahameGithub] and [James Agnew][Link-jamesGithub] on behalf of the FHIR community.

[Link-AzureProject]: https://dev.azure.com/fhir-pipelines/fhir-core-library
[Link-BuildPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=16&branchName=master
[Link-SnapshotPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=17&branchName=master
[Link-r4SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r4&v=LATEST "Sonatype Snapshot"
[Link-r4SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r4&v=LATEST "Sonatype Release"
[Link-r5SonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r5&v=LATEST "Sonatype Snapshot"
[Link-r5SonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.r5&v=LATEST "Sonatype Release"
[Link-cliSonatypeSnapshot]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=LATEST "Sonatype Snapshot"
[Link-cliSonatypeRelease]: https://oss.sonatype.org/service/local/artifact/maven/redirect?r=releases&g=ca.uhn.hapi.fhir&a=org.hl7.fhir.validation.cli&v=LATEST "Sonatype Release"
[Link-grahameGithub]: https://github.com/grahamegrieve
[Link-jamesGithub]: https://github.com/jamesagnew

[Badge-BuildPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_apis/build/status/Build%20%26%20Test?branchName=master
[Badge-SnapshotPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_apis/build/status/Module%20SNAPSHOT%20Publisher?branchName=master
[Badge-r4SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r4.svg "Sonatype Releases"
[Badge-r4SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r4.svg "Sonatype Snapshots"
[Badge-r5SonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r5.svg "Sonatype Releases"
[Badge-r5SonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.r5.svg "Sonatype Snapshots"
[Badge-cliSonatypeRelease]: https://img.shields.io/nexus/r/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.cli.svg "Sonatype Releases"
[Badge-cliSonatypeSnapshot]: https://img.shields.io/nexus/s/https/oss.sonatype.org/ca.uhn.hapi.fhir/org.hl7.fhir.validation.cli.svg "Sonatype Snapshots"
