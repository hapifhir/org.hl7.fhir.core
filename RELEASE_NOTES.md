## Validator Changes

* Various Performance improvements, thanks Vadim Peretokin
* Snapshot generation: fix type slicing when a type specific name (e.g. valueQuantity) is used where the base restricts a choice element but doesn't type slice it (IG publisher 2.3.5 regression, seen in AU Core blood pressure), and report duplicate slice names and differential fixed/pattern values that conflict with the base profile
* Snapshot generation: a profile on an extension now takes the context of the extension it profiles when it doesn't state its own
* ConceptMap validation: new mapping quality checks - consistency with the reverse ConceptMap when one is found in the context (equivalence, narrower/broader, noMap, source/target scope), and subsumption checks on sources and targets when the code system has an is-a hierarchy (hints for missing things, warnings for inconsistent things)
* FHIRPath: the type checker narrows types under `is` guards (e.g. `$this is dateTime implies $this.toString().length() >= 10`) through implies, and, or, xor, not and iif (R4, R4B, R5 and R6)
* FHIRPath: fix decimal comparison - only zeros after the decimal point are insignificant (`100 = 1.0` was true)
* FHIRPath: toString() on a complex type returns empty
* FHIRPath: `=` treats element model decimals as decimals (1.0 = 1.00), as it already did for DecimalType
* Allow `Base` as an extension context type
* Fix loading R6 resources from references during validation
* Improved error messages: FHIRPath functions that only work on primitives report the actual type, and invariant expression errors identify the element
* txTests: fix sorting of subproperty parameters

## Other code changes

* Conversion: the version convertors no longer track the conversion path. `ConversionContextXX.path()` is gone, `init()` and `close()` no longer take a path, and `copyElement()` and the advisor methods (`ignoreExtension()`, `ignoreType()`, `useAdvisorForExtension()`, `handleExtension()`) no longer take a path parameter - custom advisors will need updating
* Conversion: the TestScript scope extension is now dropped when the TestScript is inside a Bundle, not only when it is converted on its own; elements whose extensions are all empty no longer get empty extensions copied across
* Conversion: the Testing IG convertors have moved from `org.hl7.fhir.convertors.igs.testing` to `org.hl7.fhir.convertors.igs.r5.testing`, with new R6 versions in `org.hl7.fhir.convertors.igs.rN.testing` (used by `VersionConvertorRegistry`)
* Conversion: error messages for types and resources that can't be converted now name the right versions
* Model (R6): new `IModelObjectVisitor` and generated `visitChildren()` on the model classes, used by `Base.forEachChild()` / `visitDescendants()`, `getChildValues("*")`, `assertModelContext()` and `changeModelContext()` instead of walking `listChildren()`
* Context: new `IWorkerContext.fetchSpecializations()` (R5 and R6) that finds the type definitions without loading every StructureDefinition; worker context `copy()` now copies the resource indexes instead of sharing them with the original
* Context: `.standalone` is documented as not thread safe (readme and javadoc), and `CachedCanonicalResource.getDerivation()` is no longer synchronized - the thread safety of the standalone module will be subject to further ongoing review
* Rendering: fixed and pattern values (and minValue/maxValue) in profiles are now shown as JSON (with XML as well in the detailed view), primitives as the value with "(no extensions allowed)" or "(extensions allowed)", and Quantity collapsed to value, units and code
* Rendering: `HierarchicalTableGenerator` uses CSS classes instead of inline styles where it can, which needs the new pubpack (0.2.8) with `HierarchicalTableGenerator.css`. `Piece.setStyle()` / `addStyle()` and `Cell.setStyle()` / `Title.setStyle()` are replaced by `styleAsXX()`, `addNamedStyle()` and `setBackgroundColor(BackgroundColorCode)`
* Rendering: new `CodeSystemHierarchy` (R5 and R6) is the CodeSystem parent/child analysis shared by the renderer and `TerminologySubsumptionTester`; `CodeSystemNavigator` is built on it, and `RenderingContext.cacheResourceAnalysis` keeps the analysis in the CodeSystem's user data for reuse
* Bundle renderer: render the narrative of each entry with its top heading at h3, so a nested document Bundle no longer pushes the headings of the other entries one level too deep (HL7/fhir-ig-publisher#1404)
* ConceptMap renderer: in maps between StructureDefinitions, link element ids with [x] to the _x_ anchors of the structure tables, and show the element types instead of 'todo' (HL7/fhir-ig-publisher#1405)
* ConceptMap renderer: element links in maps between StructureDefinitions now go to the definitions page for core spec resources, datatypes and profiles (with the anchor format each uses), and no longer append a second fragment to web paths that already have one (datatypes.html#Quantity)
* Rendering: narratives inline images (participant photos, Library content) as data: urls instead of writing files alongside, with a note for images too big to include; fix the malformed data: url in the Library renderer, and ignore whitespace in base64 image data
* Rendering: an Identifier with no value shows the reason (data absent reason etc.), and more rendering phrases are translatable
* Packages: examples are now written to `package/examples/` (as the package spec says) instead of `package/example/`, and everything that reads examples from a package looks in both (`NpmPackage.EXAMPLE_FOLDERS`, `listExamples()`, `loadExample()`). Also fixes `PackagedResourceFile.isExample()`, which was false for examples in packages loaded from the package cache
* i18n: messages no longer fall back to the JVM default locale when the requested locale has no translations (#2733)
* XhtmlParser: `parseFragment(InputStream)` decodes as UTF-8, not the platform default
* R4/R4B: recognise uuid as a primitive type in `TypesUtilities`
* Update opentelemetry, logback, jackson, okio and ST4
