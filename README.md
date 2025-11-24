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
[![OpenSSF Scorecard](https://api.scorecard.dev/projects/github.com/hapifhir/org.hl7.fhir.core/badge)](https://scorecard.dev/viewer/?uri=github.com/hapifhir/org.hl7.fhir.core) [![CodeQL](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/codeql.yml/badge.svg)](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/codeql.yml) [![OWASP Security Scans](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/owasp.yml/badge.svg)](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/owasp.yml) [![Trivy Security Scans](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/trivy.yml/badge.svg)](https://github.com/hapifhir/org.hl7.fhir.core/actions/workflows/trivy.yml)


|                        CI Status (master)                        |                   Current Release                    |           Snapshot           |
|:----------------------------------------------------------------:|:----------------------------------------------------:|:----------------------------:|
| [![Build Status][Badge-BuildPipeline]][Link-AzureMasterPipeline] | [![Badge-maven-release-core]][Link-GithubZipRelease] | ![Badge-maven-snapshot-core] |

This java project provides:

* A Java library containing object handling code for the FHIR specification.
* Useful FHIR utilities, including the FHIR Validator

This code is used in all [HAPI](https://github.com/hapifhir/hapi-fhir) servers and clients. It also provides the HL7 maintained 
FHIR Validator, both as a library and as a standalone CLI application. In addition, this 
is the core code for the HL7 maintained [IG publisher]((https://github.com/HL7/fhir-ig-publisher/))
and FHIR [main build publisher](https://github.com/HL7/kindling). As such, this code is considered an authoritatively 
correct implementation of the core FHIR specification that it implements.

The following is an overview of modules used in this project:

* **org.fhir.fhir.utilities**: Shared code used by all the other projects - including the internationalization code
* **org.fhir.fhir.r5**: Object models and utilities for R5 candidate (will change regularly as new R5 candidates are released)
* **org.fhir.fhir.r4b**: Object models and utilities for R4B
* **org.fhir.fhir.r4**: Object models and utilities for R4
* **org.fhir.fhir.dstu3**: Object models and utilities for STU3
* **org.fhir.fhir.dstu2**: Object models and utilities for STU2 (deprecated and scheduled for removal)
* **org.fhir.fhir.dstu2016may**: Object models and utilities for an early STU3 candidate still used by some implementers
* **org.fhir.fhir.convertors**: Code to convert between versions, and other version independence code - uses all the above projects
* **org.fhir.fhir.validation**: The FHIR Java validator (note: based on R5 internally, but validates all the above versions)
* **org.fhir.fhir.validation.cli**: Holder project for releasing the FHIR validator as a single fat jar 

## Internationalization

This project implements internationalization for its user tools and utilities for several locales using a combination of [GNU PO](https://www.gnu.org/software/gettext/manual/html_node/PO-Files.html) and [Java Properties](https://docs.oracle.com/javase/tutorial/i18n/resbundle/propfile.html) files.

Translation from the core library's original English locale to other supported locales is an ongoing process. 
See [Translation Status](https://fhir.github.io/translation-utils/) for current details.


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
> **Note:** If you're on Windows and use PowerShell, The `-` needs to be escaped with a backtick (`)
> ```
> mvn `-Dmaven.test.skip install
> ``` 

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

To build only the validator_cli jar locally:
```
mvn clean package -Dmaven.test.skip=true --projects org.hl7.fhir.validation.cli --no-transfer-progress
cp org.hl7.fhir.validation.cli/target/org.hl7.fhir.validation.cli*-SNAPSHOT.jar ./validator_cli.jar
```

_This will produce `./validator_cli.jar` in the project root directory._

## Releases

The built binary for the FHIR command-line validator is released through [GitHub releases][Link-GithubReleases] and can be downloaded directly [here][Link-GithubZipRelease]. For instructions on using this validator visit the [FHIR Validator Confluence page][Link-ConfluenceValidator].

All build artifacts are published on [Maven Central][Link-MavenCentral]. 

### Current Versions 

|          Artifact           |                                  Release                                   |                Snapshot                |
|:---------------------------:|:--------------------------------------------------------------------------:|:--------------------------------------:|
|      org.hl7.fhir.core      |           [![Badge-maven-release-core]][Link-maven-release-core]           |      ![Badge-maven-snapshot-core]      |
|   org.hl7.fhir.convertors   |     [![Badge-maven-release-convertors]][Link-maven-release-convertors]     |   ![Badge-maven-snapshot-convertors]   |
|     org.hl7.fhir.dstu2      |          [![Badge-maven-release-dstu2]][Link-maven-release-dstu2]          |     ![Badge-maven-snapshot-dstu2]      |
|  org.hl7.fhir.dstu2016may   |    [![Badge-maven-release-dstu2016may]][Link-maven-release-dstu2016may]    |  ![Badge-maven-snapshot-dstu2016may]   |
|     org.hl7.fhir.dstu3      |          [![Badge-maven-release-dstu3]][Link-maven-release-dstu3]          |     ![Badge-maven-snapshot-dstu3]      |
| org.hl7.fhir.dstu3.support  |  [![Badge-maven-release-dstu3-support]][Link-maven-release-dstu3-support]  | ![Badge-maven-snapshot-dstu3-support]  |
|     org.hl7.fhir.model      |          [![Badge-maven-release-model]][Link-maven-release-model]          |     ![Badge-maven-snapshot-model]      |
|       org.hl7.fhir.r4       |             [![Badge-maven-release-r4]][Link-maven-release-r4]             |       ![Badge-maven-snapshot-r4]       |
|      org.hl7.fhir.r4b       |            [![Badge-maven-release-r4b]][Link-maven-release-r4b]            |      ![Badge-maven-snapshot-r4b]       |
|       org.hl7.fhir.r5       |             [![Badge-maven-release-r5]][Link-maven-release-r5]             |       ![Badge-maven-snapshot-r5]       |
|    org.hl7.fhir.support     |        [![Badge-maven-release-support]][Link-maven-release-support]        |    ![Badge-maven-snapshot-support]     |
|   org.hl7.fhir.utilities    |      [![Badge-maven-release-utilities]][Link-maven-release-utilities]      |   ![Badge-maven-snapshot-utilities]    |
|   org.hl7.fhir.validation   |     [![Badge-maven-release-validation]][Link-maven-release-validation]     |   ![Badge-maven-snapshot-validation]   |


To use the most recent SNAPSHOT builds of these artifacts in your project will need to add the following repository to your `pom.xml` or `build.gradle.kts` file.

###### pom.xml
```xml
<repository>
  <name>Central Portal Snapshots</name>
  <id>central-portal-snapshots</id>
  <url>https://central.sonatype.com/repository/maven-snapshots/</url>
  <releases>
    <enabled>false</enabled>
  </releases>
  <snapshots>
    <enabled>true</enabled>
  </snapshots>
</repository>
```
###### build.gradle.kts

```kts
repositories {
    maven {
        name = "Central Portal Snapshots"
        url = URI("https://central.sonatype.com/repository/maven-snapshots/")
        
        content {
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.utilities")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.dstu2")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.dstu2016may")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.dstu3")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.dstu3.support")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.model")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r4")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r4b")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r5")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.support")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.convertors")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.validation")
        }
    }
}
```

After adding the necessary repositories, you can include the libraries as follows:

##### org.hl7.fhir.validation
###### Maven
```xml
<dependency>
    <groupId>ca.uhn.hapi.fhir</groupId>
    <artifactId>org.hl7.fhir.validation</artifactId>
    <version>(latest version)</version>
</dependency>
```

###### Gradle
```groovy
compile group: 'ca.uhn.hapi.fhir', name: 'org.hl7.fhir.validation', version: '(latest version)'
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

This project is maintained by [Grahame Grieve][Link-grahameGithub], [James Agnew][Link-jamesGithub], [David Otasek][Link-davidGithub], and [Mark Iantorno][Link-markGithub] on behalf of the FHIR community.


[Link-ConfluenceValidator]: https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator

[Link-SnapshotPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=17&branchName=master

[Link-AzureProject]: https://dev.azure.com/fhir-pipelines/fhir-core-library
[Link-AzureMasterPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build/latest?definitionId=29&branchName=master
[Link-AzurePullRequestPipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build?definitionId=31
[Link-AzureReleasePipeline]: https://dev.azure.com/fhir-pipelines/fhir-core-library/_build?definitionId=30

[Link-MavenCentral]: https://central.sonatype.org/
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

<!--- Maven Release Links --->
[Link-maven-release-core]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.core
[Link-maven-release-convertors]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.convertors
[Link-maven-release-dstu2]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2
[Link-maven-release-dstu2016may]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2016may
[Link-maven-release-dstu3]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3
[Link-maven-release-dstu3-support]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3.support
[Link-maven-release-model]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.model
[Link-maven-release-r4]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.r4
[Link-maven-release-r4b]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.r4b
[Link-maven-release-r5]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.r5
[Link-maven-release-support]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.support
[Link-maven-release-utilities]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.utilities
[Link-maven-release-validation]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.validation

<!--- Maven Release Badges --->
[Badge-maven-release-core]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.core%2Fmaven-metadata.xml
[Badge-maven-release-convertors]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.convertors%2Fmaven-metadata.xml
[Badge-maven-release-dstu2]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu2%2Fmaven-metadata.xml
[Badge-maven-release-dstu2016may]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu2016may%2Fmaven-metadata.xml
[Badge-maven-release-dstu3]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu3%2Fmaven-metadata.xml
[Badge-maven-release-dstu3-support]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu3.support%2Fmaven-metadata.xml
[Badge-maven-release-model]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.model%2Fmaven-metadata.xml
[Badge-maven-release-r4]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r4%2Fmaven-metadata.xml
[Badge-maven-release-r4b]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r4b%2Fmaven-metadata.xml
[Badge-maven-release-r5]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r5%2Fmaven-metadata.xml
[Badge-maven-release-support]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.support%2Fmaven-metadata.xml
[Badge-maven-release-utilities]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.utilities%2Fmaven-metadata.xml
[Badge-maven-release-validation]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Frepo1.maven.org%2Fmaven2%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.validation%2Fmaven-metadata.xml

<!--- Maven SNAPSHOT badges --->
[Badge-maven-snapshot-core]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.core%2Fmaven-metadata.xml
[Badge-maven-snapshot-convertors]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.convertors%2Fmaven-metadata.xml
[Badge-maven-snapshot-dstu2]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu2%2Fmaven-metadata.xml
[Badge-maven-snapshot-dstu2016may]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu2016may%2Fmaven-metadata.xml
[Badge-maven-snapshot-dstu3]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu3%2Fmaven-metadata.xml
[Badge-maven-snapshot-dstu3-support]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.dstu3.support%2Fmaven-metadata.xml
[Badge-maven-snapshot-model]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.model%2Fmaven-metadata.xml
[Badge-maven-snapshot-r4]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r4%2Fmaven-metadata.xml
[Badge-maven-snapshot-r4b]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r4b%2Fmaven-metadata.xml
[Badge-maven-snapshot-r5]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.r5%2Fmaven-metadata.xml
[Badge-maven-snapshot-support]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.support%2Fmaven-metadata.xml
[Badge-maven-snapshot-utilities]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.utilities%2Fmaven-metadata.xml
[Badge-maven-snapshot-validation]: https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fcentral.sonatype.com%2Frepository%2Fmaven-snapshots%2Fca%2Fuhn%2Fhapi%2Ffhir%2Forg.hl7.fhir.validation%2Fmaven-metadata.xml

