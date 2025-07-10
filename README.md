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
* **org.fhir.fhir.validation.cli**: Holder project for releasing the FHIR validator as as single fat jar 

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
| Project |                                      Current Release                                      |
| :---: |:-----------------------------------------------------------------------------------------:|
| org.hl7.fhir.validation.cli |         [![Release Artifacts][Badge-r5MavenCentralRelease]][Link-cliMavenCentralRelease]          |
| org.hl7.fhir.validation |  [![Release Artifacts][Badge-validationMavenCentralRelease]][Link-validationMavenCentralRelease]  |
| org.hl7.fhir.dstu2 |       [![Release Artifacts][Badge-dstu2MavenCentralRelease]][Link-dstu2MavenCentralRelease]       |
| org.hl7.fhir.dstu2016may | [![Release Artifacts][Badge-dstu2016mayMavenCentralRelease]][Link-dstu2016mayMavenCentralRelease] |
| org.hl7.fhir.dstu3 |       [![Release Artifacts][Badge-dstu3MavenCentralRelease]][Link-dstu3MavenCentralRelease]       |
| org.hl7.fhir.r4 |          [![Release Artifacts][Badge-r4MavenCentralRelease]][Link-r4MavenCentralRelease]          |
| org.hl7.fhir.r5 |          [![Release Artifacts][Badge-r5MavenCentralRelease]][Link-r5MavenCentralRelease]          |

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
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r4")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r4b")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.r5")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.convertors")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.validation")
            includeModule("ca.uhn.hapi.fhir", "org.hl7.fhir.validation.cli")
        }
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
[Link-dstu2MavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2 "Maven Central Release"
[Link-dstu2016mayMavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2016may "Maven Central Release"
[Link-dstu3MavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3 "Maven Central Release"
[Link-r4MavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.r4 "Maven Central Release"
[Link-r5MavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.r5 "Maven Central Release"
[Link-cliMavenCentralRelease]: https://github.com/hapifhir/org.hl7.fhir.core/releases/latest/download/validator_cli.jar
[Link-validationMavenCentralRelease]: https://central.sonatype.com/artifact/ca.uhn.hapi.fhir/org.hl7.fhir.validation "Maven Central Release"

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
[Badge-dstu2MavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2 "Maven Central Releases"
[Badge-dstu2016mayMavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.dstu2016may "Maven Central Releases"
[Badge-dstu3MavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.dstu3 "Maven Central Releases"
[Badge-r4MavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.r4 "Maven Central Releases"
[Badge-r5MavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.r5 "Maven Central Releases"
[Badge-cliMavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.validation.cli "Maven Central Releases"
[Badge-validationMavenCentralRelease]: https://img.shields.io/maven-central/v/ca.uhn.hapi.fhir/org.hl7.fhir.validation "Maven Central Releases"
