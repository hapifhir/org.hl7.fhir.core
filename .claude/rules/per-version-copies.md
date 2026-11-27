---
paths:
  - "org.hl7.fhir.r4/src/main/java/**"
  - "org.hl7.fhir.r4b/src/main/java/**"
  - "org.hl7.fhir.r5/src/main/java/**"
  - "org.hl7.fhir.services/src/main/java/**"
  - "org.hl7.fhir.standalone/src/main/java/**"
  - "org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/utilities/**"
  - "org.hl7.fhir.convertors/src/main/java/org/hl7/fhir/convertors/conv*/**"
---

# Per-version copies

Much of this code has copies in other modules:
- r5 `fhirpath`, `terminologies`, `renderers`, `elementmodel`, `conformance` and `context` have R6 copies in `org.hl7.fhir.services` (where `terminologies` becomes `terminology`) and `org.hl7.fhir.standalone` (context and terminology).
- r5 `terminologies/CodeSystemUtilities` has a copy in `org.hl7.fhir.model/.../model/utilities`.
- r4 and r4b have older, partly diverged copies. Some are still maintained, such as the terminology client loggers (`HTMLClientLogger`, and `TextClientLogger` in r4b), which have copies in r5 `context` and `services/utilities`.
- The R6 convertors are clones of the R5 ones: `conv40_N` of `conv40_50` and `conv43_N` of `conv43_50`, with `_N` in place of `_50` in class names. A defect in one is usually in the other, so fix both.

When you change a class here:
1. Find its other copies: `find . -name <Class>.java -not -path '*/target/*'`. For convertors, also look for the `_50` or `_N` counterpart.
2. Apply the same change to the copies that share the logic. For a bug fix, that is usually r5 plus its R6 copies. Some `services` changes are deliberately not ported to r5. If you leave a copy unchanged on purpose, say why.
3. Do the same for tests. A test added to only one copy is a gap.

When reviewing, don't flag that copies exist. Do flag copies that diverge without a reason, but don't flag a `services` change only because r5 lacks it.
