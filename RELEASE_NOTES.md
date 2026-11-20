## Validator Changes

* Slicing: a pattern discriminator whose pattern is a Coding (or a CodeableConcept with a Coding) that only fixes userSelected can now be evaluated - userSelected was ignored, so the slicing was reported as 'cannot be evaluated' (#2511)

* Bundle reference resolution: the R5 rules for resolving relative references in a Bundle now apply to all FHIR versions. A relative reference (e.g. `Patient/123`) is only resolved against the fullUrl of the entry that contains it when that fullUrl is a RESTful URL. In a bundle with `urn:uuid:` fullUrls (common in R4 documents and messages) such references are reported as unresolvable (information), with a warning when an entry matches by type and id, and in documents they may now fail to resolve. The setting that controlled this (`-r5-bundle-relative-reference-policy` on the command line, the `r5BundleRelativeReferencePolicy` server parameter, and `ValidationOptions/ValidationEngine/InstanceValidatorParameters.get/setR5BundleRelativeReferencePolicy`) has been removed - passing it is now an error

* Terminology tests (`/txTest/setup`, `test-version`): can run the tests from the ci-build of a branch of the tx-ecosystem IG, `current$<branch>` - to test a server change against test changes that aren't merged yet

* Terminology cache: an $expand that fails without an answer about the value set is no longer kept for later runs, only for the rest of this one. As well as a server that couldn't be reached, that is now a 500 (INTERNAL_ERROR), a 401 or 403 (NOSERVICE), no server able to expand the value set (NOSERVICE), and a request that failed on this side (INTERNAL_ERROR). INTERNAL_ERROR results already written to a cache are dropped when it is loaded

* Terminology ecosystem: when the registry finds no server for a code system and says that it knows of no code system at all on its host (`unknown-host`, see 'Unknown Hosts' in the tx ecosystem IG), the registry isn't asked about any other code system on that host for the rest of the run

* Terminology: a code system from a loaded package (a dependency, not the IG being built or the files being validated) isn't sent to the terminology server (tx-resource) when the server's TerminologyCapabilities lists that version of it, with its content - it has it already. The IG publisher was sending the full ICD-10-CM (28 MB, from fhir.tx.support) to tx.fhir.org, which has the same version, once a run (PackageInformation.isFromNpmPackage)

## Other code changes

* FHIRPath: an evaluation can't run for ever - repeat() stops with an error after 1000 rounds (FHIRPathEngine.MAX_REPEAT_ROUNDS; 1.repeat($this + 1) never ended), and any evaluation stops with an error after a minute (FHIRPathEngine.MAX_EXECUTION_MILLIS, can be changed with setMaxExecutionMillis). Expressions come from content - invariants, Liquid templates, ViewDefinitions - and can be written so they don't end

* Liquid: a template can't nest for, if, capture and include more than 100 deep (LiquidEngine.MAX_DEPTH, counting the levels in included templates), when it's parsed or when it's run - a template that included itself went on until the stack ran out

* NpmPackage: a package that decompresses to more than 1.5 GB is refused by default (NpmPackage.DEFAULT_MAX_LOAD_SIZE; the largest real package, us.nlm.vsac#0.18.0, is 1.25 GB). There was no limit unless setDefaultMaxLoadSize was called, and nothing called it, so a decompression bomb could exhaust memory or disk. setDefaultMaxLoadSize(0) still turns the limit off

* NpmPackage: a package (tgz or zip) with two files of the same name is refused. Readers disagree on which copy wins, so a package with two package.json files could be one package to one reader and another to another. Names are compared after normalising ./, //, \ and Unicode form, and ignoring case (NpmPackage.entryNameKey), as FHIRsmith does

* NpmPackage: a package entry whose name has a .. segment is refused in every reader, with \ as well as / as the separator (NpmPackage.checkEntryPath). Extracting a tgz to disk (the package cache) only looked for /.. and ../, so package\..\x got through, and on Windows was written outside the package folder. The check is now by segment, so a name like Patient-a..b.json is no longer refused, and it throws IOException rather than RuntimeException. NpmPackageVersionConverter makes the same checks as NpmPackage (.. segments, duplicate names, the size limit)

* NPMPackageGenerator (services, r5, r4b, r4): adding a file whose name is the same file to some systems as one already added - they differ only in case, or in ./ or // (NpmPackage.entryNameKey) - is an error, and fails the build: every package reader now refuses a package with both. This happens when two resources' ids differ only in case. Adding exactly the same name twice is still a warning, and the second is skipped (PackageEntryNames). Files loaded from a folder (templates) were named with the platform's separator, so on Windows their tar entries had \ in them; they are named with / now

* ManagedFileAccess: setAllowedPaths() limits file access to the files under a set of folders. A path is checked where it really is (. and .. resolved, symbolic links followed), by path segments (so /ig-other isn't under /ig), and inStream(File) and outStream(File) are checked too

* Terminology logs (the IG publisher's qa-tx.html): Authorization, Proxy-Authorization and Cookie headers, and any header whose name says it is a key, token, secret or password, are masked like Api-Key - a server configured with token or basic authentication had its credentials written out in full. Request headers in the HTML log are also escaped now

* FileUtilities.clearDirectory with exemptions deletes a symbolic link in the folder instead of failing on it (CSFile's case check) - not what it links to, as without exemptions

* NPM packages: a package loaded from a zip (a template from a github repository) can't have an entry with '..' in its name, the same as a tgz - unpacked, package/content/../scripts/ant.xml was written over scripts/ant.xml

* Snapshot generation: when a profile narrows the types of a type sliced element, the inherited type slices for types that are no longer allowed are prohibited (max = 0) in the snapshot, instead of being left usable - profiles no longer have to do this by hand (#1191)

* Snapshot generation: fix a StackOverflowError when a differential walks into an extension (and its children) inside an element reached through a content reference, e.g. Observation.component.referenceRange.low.extension.url - the walk into the Extension data type kept the content reference redirection (fhir-ig-publisher#1299)

* Snapshot generation: reslices are now checked against the slice they reslice - a slice whose reslices add up to more than its minimum gets SD_SLICE_MIN_EXCEEDS_SLICER (an error for publication), the same as slices against their slicer. The slicer's own check counts a resliced slice once (the larger of its minimum and its reslices' total) instead of counting the slice and its reslices separately, which over-raised the minimum of an auto-added slicing entry

* Snapshot generation: when a differential restates a type without aggregation or versioning - e.g. a slice on a Reference that narrows its target profiles - the aggregation and versioning of the same type in the base are kept, rather than dropped (#733)

* Snapshot generation: a differential that walks into an element with more than one type (without slicing it by type) and constrains anything other than its extensions now gets the error that says so - '... has children (...) and multiple types (...)' - instead of the generic 'No match found' for each child. It's a DefinitionException when the ProfileUtilities is set to throw exceptions (#2596)

* Snapshot generation: a min stated on a type slice is no longer reset to 0 after the slice is processed. That only happened when the type slicing entry was written out in the differential, so the same profile written with type specific names (valueQuantity) kept it (#2586)

* Terminology: a value set found on a terminology server is only taken when its url is the one asked for. A server that also returned value sets whose url starts with it (e.g. tx.fhir.org returning `...1267.39` for `...1267.3`) could have the wrong one chosen, and bindings rendered with a link to another value set

* Snapshot generation: a differential mapping marked with the elementdefinition-suppress extension now removes the matching inherited mapping (same identity and map) from the snapshot - it used to be ignored, so the inherited mapping was kept (#2669)

* Snapshot generation no longer rewrites the type of Resource.id in the base definition every time it generates a snapshot - that modified shared definitions, and raced when snapshots were generated concurrently (#2470). The fix (R4 publishes the fhir-type of Resource.id as 'string', not 'id') is now made once, when the definition is loaded from a package. Packages that are loaded without lazy loading now get all the package fixes too

* Package cache: `current$<branch>` packages (the ci-build of a branch) can now be installed - they were fetched, then refused as an illegal version - and are checked for a newer build of the branch, as `current` is
