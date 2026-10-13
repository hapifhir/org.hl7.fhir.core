Sliced datatype / content-reference snapshot examples

These are reduced StructureDefinition JSON inputs to ProfileUtilities, with
explicit snapshots for the base definitions. They are self-contained algorithm
fixtures, not replacements for the full FHIR core package or complete IGs. Their
purpose is to preserve the exact element paths and contentReference that trigger
the bug. No EBM/AWMF packages or SUSHI installation are needed.

ProfileUtilitiesSlicedDatatypeTest parses these exact files and calls:
  new ProfileUtilities(context, messages, null).generateSnapshot(
      base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());

Failing-before / working-after example:
  Cache Extension.json, LabelExtension.json and BaseComposition.json in an empty
  worker context. Pass BaseComposition.json as base and NestedComposition.json as
  derived. BaseComposition.section.section has contentReference
  "#Composition.section". The differential adds a label extension under the
  summary/details section and constrains label.value[x] to the fixed string
  "Nested section label".

  Before fix: StackOverflowError during extension datatype expansion.
  With fix: snapshot generation succeeds. The label slice has cardinality 1..1,
  its type profile is LabelExtension, value[x] has min 1 and fixedString
  "Nested section label", label.extension has max 0, and the section title
  constraints "Summary" and "Details" are preserved.

  Moving the differential cursor alone prevents the overflow but can silently
  lose the child fixed value. The test explicitly checks that value as well as
  successful generation.

Null-reset regression:
  Cache Extension.json, RecursiveExtension.json and BaseComposition.json. Pass
  BaseComposition.json as base and NestedExtensionComposition.json as derived.
  RecursiveExtension represents nested extensions using contentReference
  "#Extension". After expanding the new label slice's datatype, generation must
  add a fresh redirection when expanding its nested extension.

  With the cursor fix but withRedirector(null): NullPointerException in
  ProfileUtilities.redirectorStack(), which calls addAll(redirector).
  With an empty ArrayList: generation succeeds; the nested extension is 1..1,
  its extension child is prohibited (max 0), its URL is fixed to "child", and
  value[x] is fixed to "Nested extension value". The sibling title "Details"
  remains constrained. This is another reduced algorithm fixture.

Working-before-and-after control:
  Cache ContactPoint.json and BasePatient.json. Pass BasePatient.json as base and
  ReslicedPatient.json as derived. The phone/work reslice has cardinality 1..1,
  fixed system "phone", fixed use "work", and value min 1 in both versions.

Keep the id children in Extension.json and BaseComposition.json: removing them
can suppress the datatype expansion and stop this reduced fixture reproducing
its intended bug.

From the repository root:
  mvn -pl org.hl7.fhir.standalone -am -Dtest=ProfileUtilitiesSlicedDatatypeTest -Dsurefire.failIfNoSpecifiedTests=false test

Expected: 3 tests pass with the fix. The original content-reference case fails
without it and the ordinary reslicing control passes. A null redirector reset
also fails the nested-extension case with NullPointerException.
