# Registering Additional Resources in R5

An *additional resource* is a resource that is not defined in the base FHIR specification, but is
defined by an *incubator IG* — an implementation guide that prototypes a resource for a future
version of FHIR (for example `TestPlan`, `TestScript` and `TestReport` in the
[FHIR Testing IG](https://build.fhir.org/ig/HL7/fhir-testing-ig/), package `hl7.fhir.uv.testing`).

To work with such resources as first-class objects in the R5 object model, code has to be generated
for them and registered with the parsers, and their definitions have to be loaded into the worker
context. This document describes how to do that. It has three steps: generate the code, register the
parsers, and make the definitions available. Users of the [IG Publisher](https://github.com/HL7/fhir-ig-publisher/)
can skip all of this and use the `incubator-ig` parameter (see the end).

## 1. Generate the code

The validator's (hidden) `ig-codegen` command generates a Java model for the resources (and logical
models) in one or more IG packages, in the same style as the core `org.hl7.fhir.r5.model` classes —
model classes, a `TypeFactory`, and JSON/XML parsers:

```
java -jar validator_cli.jar ig-codegen \
  -package-name org.hl7.fhir.r5.igs.testing \
  -output      org.hl7.fhir.r5/src/main/java/org/hl7/fhir/r5/igs/testing \
  -config      org.hl7.fhir.core.generator/add-ons-config \
  -test-package-name org.hl7.fhir.r5.igs.testing \
  -test-output       org.hl7.fhir.r5/src/test/java/org/hl7/fhir/r5/igs/testing \
  hl7.fhir.uv.testing#current
```

* `-package-name` / `-output` — the Java package and folder for the generated model.
* `-config` — the code-generation configuration folder (`org.hl7.fhir.core.generator/add-ons-config`).
* `-test-package-name` / `-test-output` — optional; also generate a JUnit round-trip test
  (`<Jname>RoundTripTests`) that loads every example in the source package and checks it round trips
  json &rarr; xml &rarr; json.
* the trailing arguments are the package id(s) to generate from. Only R4 and R5 are supported.

`<Jname>` is the capitalised last segment of the package name, so `org.hl7.fhir.r5.igs.testing`
produces `TestingRegistration`, `TestingJsonParser`, `TestingXmlParser`, etc.

## 2. Register the parsers

The generated `<Jname>Parser` class registers the parsers/composers for its resources with the core
parsers. Registration is a choice the *application* makes, so the register methods take two things:

* `overridesBase` — if `true`, these resources take precedence over any base-specification resource
  with the same name (this is the point of an incubator IG that redefines a resource); if `false`,
  they are only used for resource names the base specification doesn't define.
* an optional `CustomResourceRegistry` — the scope of the registration.

```java
// register globally: every parser in the process now understands these resources
TestingRegistration.register(true);

// or register into a scoped registry: only parsers given this registry are affected
CustomResourceRegistry registry = new CustomResourceRegistry();
TestingRegistration.register(registry, true);

Resource r = new JsonParser(registry).parse(source);        // sees the custom resources
Resource s = new JsonParser().parse(source);                // does not (uses the global registry)
```

A parser uses `CustomResourceRegistry.GLOBAL` unless it is given a different one — via a constructor,
or `setCustomResourceRegistry(registry)` / the fluent `withCustomResourceRegistry(registry)`. The
scope propagates automatically to the sub-parsers used for nested, contained and Bundle-entry
resources, so a scoped registration does not leak to any other parser.

Registration affects the object-model parsers (`JsonParser`, `XmlParser`). When a resource is
registered as overriding the base, the core parsers return the generated class in place of the base
one; otherwise the generated class is used only for resource names the base specification does not
define.

## 3. Make the definitions available

Registering the parsers changes how instances are *parsed*; it does not change what the worker
context knows about the resources' *definitions*. The `StructureDefinition`, `CodeSystem` and
`ValueSet` resources for the additional resources are in the source package, and the generated
`<Jname>Parser.packages()` returns the versioned package id(s) the code was generated from:

```java
for (String pid : TestingRegistration.packages()) {
  NpmPackage npm = pcm.loadPackage(pid);
  IContextResourceLoader loader = ...;
  context.loadFromPackage(npm, loader, true);   // load as a "master" package
}
```

Loading the package as a **master** package (the `true` argument) is what makes the context prefer
the incubator IG's definitions: a version-less lookup of `http://hl7.org/fhir/StructureDefinition/TestPlan`
then resolves to the incubator definition rather than the base-specification one. A lookup that asks
for a specific version (e.g. `…/TestPlan|5.0.0`) still resolves to the base specification, and
resources the IG does not define are untouched. This covers `CodeSystem`, `ValueSet` and specialising
`StructureDefinition`s.

## 4. Rendering (usually nothing to do)

Rendering works off a `ResourceWrapper` facade (over either the typed model or the element model), so
it is model-agnostic. Once the definitions are loaded (step 3), the generic `ProfileDrivenRenderer`
renders the additional resources, and any built-in renderer that matches by resource name is used
automatically — so an additional resource with the same name as a base resource (e.g. `TestPlan`)
already gets the base renderer, and the rest fall back to the profile-driven renderer. In most cases
there is nothing to do.

If a resource needs a bespoke narrative that the generic renderer does not produce, a hand-written
renderer (a subclass of `ResourceRenderer`, with a public `RenderingContext` constructor like the
built-in renderers) can be registered on the `RendererFactory` the application builds for its
`RenderingContext`:

```java
RendererFactory rf = new RendererFactory();
rf.registerRenderer("TestPlan", TestPlanRenderer.class);
RenderingContext rc = new RenderingContext(context, rf, ...);
```

A registered renderer takes precedence over the built-in renderer (and the profile-driven fallback)
for that resource name. Registration is per `RendererFactory` instance — the application already
constructs the factory it hands to the `RenderingContext`, so the registration is naturally scoped to
that rendering context and needs no global state. It is also kept separate from parser registration
(a package's renderers register through their own companion), so the parsing layer never depends on
the rendering layer.

Note that this differs from parser registration, which is global by default (with an optional scoped
`CustomResourceRegistry`). The difference is primarily for backwards compatibility: parsers are
constructed in many places across the codebase — and inside the object model itself — that cannot all
be changed to pass a registry, so a global default lets those existing call sites resolve the
additional resources. A `RendererFactory`, by contrast, is always explicitly constructed by the
application and injected into the `RenderingContext`, so it can carry its registrations per instance
without changing any existing construction.

## In the IG Publisher

IG authors do not do any of the above. The publisher ships the generated code, and the IG declares
the `incubator-ig` parameter (see the
[ig-parameters code system](https://build.fhir.org/ig/FHIR/fhir-tools-ig/CodeSystem-ig-parameters.html)):

```xml
<parameter>
  <code value="incubator-ig"/>
  <value value="hl7.fhir.uv.testing"/>
</parameter>
```

When the publisher sees this (repeating) parameter it does all three of the above: it registers the
generated parsers, loads the package into the context as a master package, and registers the IG's
hand-written renderers on the RendererFactory it uses for rendering — so the IG is parsed, resolved
and rendered against the incubator IG's definitions of its resources. The value is a code from the
list of incubator IGs that code has been generated for — currently just `hl7.fhir.uv.testing`.
