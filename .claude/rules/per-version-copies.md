---
paths:
  - "org.hl7.fhir.r4/src/main/java/**"
  - "org.hl7.fhir.r4b/src/main/java/**"
  - "org.hl7.fhir.r5/src/main/java/**"
  - "org.hl7.fhir.services/src/main/java/**"
  - "org.hl7.fhir.standalone/src/main/java/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/utilities/**"
---

# Per-version copies

Much of this code has copies in other modules:
- r5 `fhirpath`, `terminologies`, `renderers`, `elementmodel`, `conformance` and `context` have R6 copies in `org.hl7.fhir.services` (where `terminologies` becomes `terminology`) and `org.hl7.fhir.standalone` (context and terminology).
- r5 `terminologies/CodeSystemUtilities` has a copy in `org.hl7.fhir.model/.../model/utilities`.
- r4 and r4b have older, partly diverged copies.

When you change a class here:
1. Find its other copies: `find . -name <Class>.java -not -path '*/target/*'`.
2. Apply the same change to the copies that share the logic, usually r5 plus its R6 copies. If you leave a copy unchanged on purpose, say why.
3. Do the same for tests. A test added to only one copy is a gap.

When reviewing, don't flag that copies exist. Do flag copies that diverge without a reason.
