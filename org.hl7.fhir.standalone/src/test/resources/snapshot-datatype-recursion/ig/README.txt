Snapshot recursion reproducer using the released IG Publisher

This minimal IG contains two StructureDefinitions generated from
input/fsh/nested-composition.fsh and a small ImplementationGuide. The FHIR JSON
is supplied so running the reproducer needs Java 17+ and the Publisher JAR;
SUSHI and Maven are not needed. The Publisher downloads standard packages and
the template when they are not cached.

From this directory:

  curl --fail --location https://github.com/HL7/fhir-ig-publisher/releases/download/3.0.0/publisher.jar --output publisher.jar
  java -Xmx3g -jar publisher.jar -ig ig.ini -no-sushi -tx n/a -generation-off -validation-off

Pinned binary:
  Publisher 3.0.0, Git 7d1c5ae624df, built 2026-10-08.
  Bundled FHIR Core 7.0.1.
  SHA-256: b8403abe5a438ddb9a3a07e02ad925f2c4bbbd9e903c49ecff50fcb481ec64ad

Version prerequisite: the profiles must be generated for 6.0.0-snapshot1.
The same FSH compiled for 4.0.1 does not reproduce this overflow. After changing
fhirVersion, rerun SUSHI before using -no-sushi. The supplied JSON is already R6.

The initialization message for DocumentStructure / example-composition about
slice minimum 0 versus 2 belongs to a bundled core example. It occurs with and
without this fix. The actual reproduced failure is the later StackOverflowError
following "Generating Snapshots".

Expected before the fix: process exits with code 1 and StackOverflowError.
The stack repeatedly contains ProfilePathProcessor.processPathWithSlicedBaseDefault.

With this PR's Core fix loaded into the same Publisher runtime, the build
completes and the snapshot has label.value[x] min 1, max 1, and fixedString
"Nested section label". Verification uses only the changed Core class ahead of
the released JAR on the classpath.

The command disables SUSHI, terminology-server use, HTML generation and
validation. Snapshot generation still runs, which is where the error occurs.
The IG deliberately has no website pages. input/ignoreWarnings.txt contains only the required format header;
no messages are suppressed.

To edit/regenerate the two profiles, run SUSHI from this directory. FSHOnly in
sushi-config.yaml preserves the supplied minimal ImplementationGuide file.
