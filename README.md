<!---
 ____________________
|                    |
|  N  O  T  I  C  E  |
|____________________|

Please maintain this README.md as a linkable document, as other documentation may link back to it. The following sections should appear consistently in all updates to this document to maintain linkability:

## Building this Project
## Releases
## CI/CD
## Maintenance

--->

# HAPI FHIR - HL7 FHIR Core Artifacts

| CI Status (master) | 
| :---: |
| [![Build Status][Badge-BuildPipeline]][Link-AzureMasterPipeline] |

This is the java core object handling code, with utilities (including validator), for the FHIR specification. 
included in this repo: 

* org.fhir.fhir.utilities: Shared code used by all the other projects - including the internationalization code
* org.fhir.fhir.r5: Object models and utilities for R5 candidate (will change regularly as new R5 candidates are released)
* org.fhir.fhir.r4b: Object models and utilities for R4B
* org.fhir.fhir.r4: Object models and utilities for R4
* org.fhir.fhir.dstu3: Object models and utilities for STU3
* org.fhir.fhir.dstu2: Object models and utilities for STU2
* org.fhir.fhir.dstu2016may: Object models and utilities for an early STU3 candidate still used by some implementers
* org.fhir.fhir.convertors: Code to convert between versions, and other version independence code - uses all the above projects
* org.fhir.fhir.validation: The FHIR Java validator (note: based on R5 internally, but validates all the above versions)
* org.fhir.fhir.validation.cli: Holder project for releasing the FHIR validator as as single fat jar (will be removed in the future)

This code is used in all HAPI servers and clients, and also is the HL7 maintained 
FHIR Validator. In addition, this is the core code for the HL7 maintained IG publisher
and FHIR main build publisher. As such, this code is considered an authoritatively 
correct implementation of the core FHIR specification that it implements.


## Building this Project

### Prerequisites

This project uses [Java](https://www.java.com) (minumum version 11), [Apache Maven](http://maven.apache.org), and [Lombok](https://projectlombok.org/) to build. You can find detailed instructions on setting up this project in your IDE [here](https://hl7.github.io/docs/core/getting-started).

### Build Commands

To build and add artifacts to your local Maven repository:

```
mvn install
```

To skip unit tests:
```
mvn -Dmaven.test.skip install
```

To clean and rebuild the terminology server caches:

_clean_
```
mvn clean -Dfhir.txcache.clean=true   
```

_rebuild_
```
mvn test -Dfhir.txcache.rebuild=true
```

_The source contains cached terminology server responses for testing. If the expected responses have changed in any way, 
this cache should be cleaned and rebuilt with the above so that subsequent `mvn test` calls will have the most current 
responses cached._

To just build validator_cli locally:
```
mvn package -Dmaven.test.skip=true --projects org.hl7.fhir.validation.cli --no-transfer-progress
cp org.hl7.fhir.validation.cli/target/org.hl7.fhir.validation.cli*-SNAPSHOT.jar ./validator_cli.jar
```

## Releases

The built binary for the FHIR command-line validator is released through [GitHub releases][Link-GithubReleases] and can be downloaded directly [here][Link-GithubZipRelease]. For instructions on using this validator visit the [FHIR Validator Confluence page][Link-ConfluenceValidator].

All build artifacts are published on [OSS Sonatype][Link-Sonatype]. 

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

To use these artifacts in your project will need to add the proper dependency to your `pom.xml` file, or your `build.gradle.kts` file.

###### pom.xml
```
<repositories>
    <repository>
        <id>oss-snapshot</id>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
    <repository>
        <id>oss-releases</id>
        <url>https://oss.sonatype.org/service/local/staging/deploy/maven2/</url>
    </repository>
</repositories> 
```
###### build.gradle.kts

```
repositories {
    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
    maven {
        url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
    }
}
```

After adding the necessary repositories, you can include the libraries as follows:

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

## CI/CD

All integration and delivery done on Azure pipelines. Azure project can be viewed [here][Link-AzureProject].

* **Pull Request Pipeline** is automatically run for every Pull Request to ensure that the project can be built via maven. [[Azure Pipeline]][Link-AzurePullRequestPipeline] [[source]](pull-request-pipeline.yml)
* **Master Branch Pipeline** is automatically run whenever code is merged to the master branch and builds the SNAPSHOT binaries distributed to OSSRH [[Azure Pipeline]][Link-AzureMasterPipeline][[source]](master-branch-pipeline.yml)
* **Release Branch Pipeline** is run manually whenever a release is ready to be made. It builds the [release binaries](#releases), distributes them to artifact repositories and sends release notifications. [[Azure Pipeline]][Link-AzureReleasePipeline][[source]](release-branch-pipeline.yml)

A brief overview of our publishing process is [here][Link-Publishing].

For more detailed instructions on cutting a release, please read [the wiki][Link-PublishingRelease]

## Maintenance

Have you found an issue? Do you have a feature request? Great! Submit it [here][Link-GithubIssues] and we'll try to fix it as soon as possible.

This project is maintained by [Grahame Grieve][Link-grahameGithub], [James Agnew][Link-jamesGithub], [David Otasek][Link-davidGithub] and [Mark Iantorno][Link-markGithub] on behalf of the FHIR community.


[Link-ConfluenceValidator]: https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator

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

[Link-AzureProject]: https://dev.azure.com/fhir-pipelines/fhir-core-library
[Link-AzureMasterPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=29&branchName=master
[Link-AzurePullRequestPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build?definitionId=31
[Link-AzureReleasePipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build?definitionId=30

[Link-sonatype]: https://oss.sonatype.org/
[Link-davidGithub]: https://github.com/dotasek
[Link-grahameGithub]: https://github.com/grahamegrieve
[Link-jamesGithub]: https://github.com/jamesagnew
[Link-markGithub]: https://github.com/markiantorno
[Link-PublishingRelease]: https://hl7.github.io/docs/ci-cd-building-release
[Link-Publishing]: https://hl7.github.io/docs/ci-cd-publishing-binaries
[Link-GithubIssues]: https://github.com/hapifhir/org.hl7.fhir.core/issues
[Link-GithubReleases]: https://github.com/hapifhir/org.hl7.fhir.core/releases
[Link-GithubZipRelease]: https://github.com/hapifhir/org.hl7.fhir.core/releases/latest/download/validator_cli.jar

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
