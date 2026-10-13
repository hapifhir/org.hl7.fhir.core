Inherited reslicing order examples

These are reduced StructureDefinition JSON inputs to ProfileUtilities, with
explicit snapshots for the base definitions. They preserve differential element
order directly, including intentionally invalid order in the negative controls.
They are self-contained algorithm fixtures, not complete IGs or replacements for
the full FHIR core package. No EBM/AWMF packages or SUSHI installation are needed.

For each case, ProfileUtilitiesInheritedReslicingTest caches ContactPoint.json
and BasePatient.json in an empty worker context, loads the named differential,
and calls:
  new ProfileUtilities(context, messages, null).generateSnapshot(
      base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());

BasePatient.json contains the inherited telecom slices phone, email (in that
order). phone can be resliced by use.

ConstrainedSibling.json
  Differential slice order: phone, phone/work, phone/home, email.
  Before fix: throws "Named items are out of order in the slice".
  With fix: snapshot slice order phone, phone/work, phone/home, email.
  phone/work is 1..1 with fixed use "work"; phone/home has fixed use "home";
  email is 1..1 and retains its inherited fixed system "email".

UnconstrainedSibling.json
  Differential slice order: phone, phone/work; email is not constrained.
  Before fix: generation succeeds with wrong order phone, email, phone/work.
  With fix: order phone, phone/work, email. email retains min 0 and its inherited
  fixed system "email"; phone/work has fixed use "work".

The following invalid inputs must throw the ordering exception before AND after
this fix. Tests asserting these expected failures count as passing tests:
  ReorderedSiblings.json             email, phone
  NewTopLevelBeforeSibling.json      phone, fax, email
  ResliceBeforeExplicitParent.json   phone/work, phone, email

From the repository root:
  mvn -pl org.hl7.fhir.standalone -am -Dtest=ProfileUtilitiesInheritedReslicingTest,SnapShotGenerationTests -Dsurefire.failIfNoSpecifiedTests=false test

Expected: 5 new tests pass with the fix; 2 fail without it. The 3 negative
controls pass in both versions. This branch is independent of the separate
sliced-datatype/content-reference fix.
