---
paths:
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/core/**"
  - "org.hl7.fhir.core.generator/**"
---

# Generated code

Files that start with `// This file is generated code - do not edit it.` are produced by `org.hl7.fhir.core.generator` (see `org.hl7.fhir.core.generator/readme.md`). Hand edits are lost the next time the generator runs.
- To add utility methods to a generated class, edit the matching template in `org.hl7.fhir.core.generator/configuration/` or `add-ons-config*/`, and add any imports in `configuration.ini`.
- The generator is not a module of the root pom: `mvn -f org.hl7.fhir.core.generator/pom.xml compile`, after `mvn install` at the root.

When reviewing regenerated code, check:
- that the output is purely regenerated, with no hand edits mixed in;
- that hand-written add-ons weren't lost;
- whether renamed or removed public API breaks `kindling` or `fhir-ig-publisher` (see "Downstream consumers" in `CLAUDE.md`).
