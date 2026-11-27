---
paths:
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/core/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/extensions/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/api/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/fml/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/testing/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/tools/**"
  - "org.hl7.fhir.r5/src/*/java/org/hl7/fhir/r5/igs/testing/**"
  - "org.hl7.fhir.standalone/src/test/java/org/hl7/fhir/testing/**"
  - "org.hl7.fhir.core.generator/**"
  - "org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/codegen/**"
---

# Generated code

Files that start with `// This file is generated code - do not edit it.` are overwritten the next time their generator runs, so hand edits are lost. Comments following that phrase name the generator and the package it was generated from.

- **`core code generator`** (`org.hl7.fhir.core.generator`, see its `readme.md`) produces `org.hl7.fhir.model/.../model/core/**` and `model/extensions` from `hl7.fhir.r6.core`.
  - To add utility methods to a generated class, edit the matching template in `org.hl7.fhir.core.generator/configuration/` or `add-ons-config*/`, and add any imports in `configuration.ini`.
  - The generator is not a module of the root pom: `mvn -f org.hl7.fhir.core.generator/pom.xml compile`, after `mvn install` at the root.
- **`ig-codegen`** (`org.hl7.fhir.validation/.../validation/codegen/`, run by the validator CLI's `ig-codegen` command) produces code from IG packages: `model/api`, `model/fml`, `model/testing`, `model/tools`, `r5/igs/testing`, and the generated `TestingRoundTripTests` classes.
  - To change the output, change the generator in `validation/codegen/`, the IG it is generated from, or the adornment fragments in the configuration folder passed to `ig-codegen`.

When reviewing regenerated code, check:
- that the output is purely regenerated, with no hand edits mixed in;
- that hand-written add-ons weren't lost;
- whether renamed or removed public API breaks a downstream consumer (see "Downstream consumers" in `CLAUDE.md`).
