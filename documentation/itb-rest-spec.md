# FHIR Validator — GITB REST Services Specification

**Status**: Draft, revised post-review (2026-04-28).
**Target contract**: [gitb-types](https://github.com/ISAITB/gitb-types) — `gitb_vs.xsd` (Validation Service) and `gitb_ps.xsd` (Processing Service).
**Scope**: GITB-faithful REST handlers in `org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/`, exposed under `/itb/...`. The existing flat native handlers (`/fhirpath`, `/validate`, …) remain available alongside.
**Companion**: [gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json) is the authoritative machine-readable spec. When this document and the OpenAPI disagree, the OpenAPI is the implementation contract.

---

## 1. TL;DR

The validator exposes **eight GITB REST services** under `/itb/`:

| Service | Kind | Path prefix | Operations |
|---|---|---|---|
| `FHIRValidator`           | Validation | `/itb/fhir`              | `validate` |
| `MatchetypeValidator`     | Validation | `/itb/matchetype`        | `validate` |
| `FHIRPathAssertion`       | Validation | `/itb/fhirPathAssertion` | `validate` |
| `FHIRPathProcessor`       | Processing | `/itb/fhirPath`          | `evaluate` |
| `TestDataGenerator`       | Processing | `/itb/testdata`          | `generate`, `generateBundle`, `modify` |
| `ValidationResultsProcessor` | Processing | `/itb/validationResults` | `summarize`, `filterBySeverity`, `filterByText` |
| `IGManager`               | Processing | `/itb/igManager`         | `loadIG` |
| `FHIRTransformer`         | Processing | `/itb/transform`         | `transform` |

Per the GITB contract, each kind has a fixed sub-path scheme — the **handler URI is the service root**, and ITB knows the operation names from the contract:

| Kind | Sub-paths the ITB calls |
|---|---|
| Validation Service | `GET /<svc>/getModuleDefinition`, `POST /<svc>/validate` |
| Processing Service | `GET /<svc>/getModuleDefinition`, `POST /<svc>/process`, `POST /<svc>/beginTransaction`, `POST /<svc>/endTransaction` |

A separate `GET /openapi.json` serves the OpenAPI overlay describing all services — purely informational; the GITB contract is what ITB calls.

---

## 2. Common conventions

### 2.1 Base URL and dispatch

Services are hosted under a single origin, e.g. `http://localhost:8080`. The handler URI registered for a service is its root (e.g. `/itb/fhir`); the ITB framework appends the GITB sub-path (`getModuleDefinition`, `validate`, `process`, `beginTransaction`, `endTransaction`) per the service's contract.

### 2.2 Wire format

JSON in, JSON out. `Content-Type: application/json` on all requests.

### 2.3 GITB headers

Every call MAY include the five optional GITB headers:

| Header | Purpose |
|---|---|
| `Gitb-Reply-To` | Test engine callback root (logged only — no callbacks are emitted) |
| `Gitb-Test-Session-Identifier` | Test session id — copied to TAR `overview.note` |
| `Gitb-Test-Case-Identifier` | Test case id — logged |
| `Gitb-Test-Step-Identifier` | Test step id — logged |
| `Gitb-Test-Engine-Version` | Test engine version — logged |

### 2.4 `AnyContent` — the input/output unit

Inputs and outputs are arrays of `AnyContent` items. Shape:

```json
{
  "name": "contentToValidate",
  "value": "<payload>",
  "embeddingMethod": "STRING",
  "type": "string",
  "mimeType": "application/fhir+json",
  "encoding": "UTF-8"
}
```

`embeddingMethod` controls how `value` is interpreted:

- `STRING` — `value` is the raw text content (default).
- `BASE_64` — `value` is base64-encoded bytes (use for binary or very-large content).
- `URI` — `value` is a URL the server SHALL fetch. Subject to the SSRF policy in §2.4.1. Disabled when the validator is started with `-disable-uri-fetch`.

Outputs (in `output[]` of `ProcessResponse`, or in `report.context[]` of TAR) carry additional rendering hints used by the ITB UI:

- `mimeType` — choose a viewer (JSON viewer, XML viewer, …).
- `forContext` — include in the report's context (referred-to data).
- `forReport` — show in the report itself.

Nested AnyContent is supported via the `item` array property — used for outputs like the (future) `IGManager.listIGs` where each loaded IG is itself an AnyContent collection.

### 2.4.1 SSRF-hardened URL fetch (when `embeddingMethod: URI` is enabled)

- **Scheme allowlist** — only `http` and `https`.
- **Private-address denylist** — DNS-resolved IP must not match loopback (`127.0.0.0/8`, `::1`), link-local (`169.254.0.0/16`, `fe80::/10`), private (`10.0.0.0/8`, `172.16.0.0/12`, `192.168.0.0/16`, `fc00::/7`), or multicast/unspecified (`0.0.0.0/8`, `224.0.0.0/4`, `::/128`). Resolved IP is reused for the actual connection (no DNS rebinding).
- **Redirects** — followed up to 5 hops, each re-validated.
- **No credential forwarding** — cookies and `Authorization` are dropped.
- **Size cap** — 30 MB.
- **Timeouts** — 10 s connect, 60 s total.
- **Kill-switch** — `-disable-uri-fetch` CLI flag disables URL fetching entirely.

The fetch result (final URL, HTTP status, content length, elapsed time) appears in TAR `context[]` as a `fetchInfo` AnyContent item.

### 2.5 No `configs`

The GITB schema allows `Configuration` entries in addition to `input` items. In line with ITB built-in handler conventions, this validator passes everything through `input[]` — `config[]` is accepted on the wire (per the spec) but currently unused by all services.

### 2.6 Errors

| Situation | HTTP | Body |
|---|---|---|
| Malformed JSON request | 400 | `{ "error": "Malformed JSON: …" }` |
| Missing required input | 400 | `{ "error": "Missing required input: <name>" }` |
| Unknown `operation` (Processing services) | 400 | `{ "error": "Unknown operation: <op>. Supported: <list>" }` |
| Unsupported / invalid AnyContent encoding | 400 | `{ "error": "…" }` |
| Domain failure (IG not found, parse error) | 200 | TAR with `result: FAILURE` (or `UNDEFINED` when the engine threw) — **not** a 5xx |
| Unrecoverable server error | 500 | `{ "error": "Internal error: …" }` |

HTTP 5xx is reserved for server bugs. Domain-level failures return 200 with a TAR explaining what happened.

### 2.7 `GET /<svc>/getModuleDefinition`

Returns `GetModuleDefinitionResponse = { "module": ValidationModule | ProcessingModule }`. The module declares the service's id, metadata, and inputs/outputs (TypedParameters), per `gitb_core.xsd`.

### 2.8 `OperationOutcome → TAR` mapping (validation services)

Validation services produce a TAR. (Strictly any service may return one — the ITB will render it — but in this spec only validation services do.) FHIR `OperationOutcome.issue[]` maps to TAR `items[]`:

| OperationOutcome field | TAR field |
|---|---|
| `issue.severity = fatal\|error` | `items[].level = ERROR`, `counters.nrOfErrors++` |
| `issue.severity = warning` | `items[].level = WARNING`, `counters.nrOfWarnings++` |
| `issue.severity = information` | `items[].level = INFO`, `counters.nrOfAssertions++` |
| `issue.details.text` | `items[].description` |
| `issue.expression[*]` joined `; ` (fallback `issue.location[*]`) | `items[].location` |
| `issue.code` | `items[].type` |
| `issue.diagnostics` | `items[].value` *(only when short — `items[].value` is meant to highlight a specific value the rule mentioned. The full diagnostic is always available via the `operationOutcome` context item, so test authors needing more should post-process from there.)* |

TAR `result` derives from counters and the caller's severity threshold (`failOn` in §3.1):

```
default (failOn = error):
  errors  > 0                 → FAILURE
  errors == 0, warnings > 0   → WARNING
  errors == 0, warnings == 0  → SUCCESS
  engine threw before outcome → UNDEFINED
```

`failOn = warning` flips warnings to FAILURE; `failOn = information` flips any issue to FAILURE.

TAR `context[]` is what's available to a test step that uses `output="$ctx"` on `<verify>` — it's how test authors get downstream values out of the validation result. The validator populates it with:

| Context item (AnyContent `name`) | `forReport` | Notes |
|---|---|---|
| `errorCount`, `warningCount`, `informationCount` | `false` | Counts as text. Available via `$ctx{errorCount}` etc.; not rendered in the report (counters in `report.counters` are rendered). |
| `severity` | `false` | Highest issue severity seen (`fatal`/`error`/`warning`/`information`). |
| `operationOutcome` | `true` | The raw FHIR `OperationOutcome` as JSON. Test authors can post-process this with JSON pointer / JSON path. |
| `content` *(when `inputs.includeContentInReport` is `true`, the default)* | `true` | The validated payload. Enables the ITB inline editor and `content:<line>:<col>` location anchors. |

So a test author who needs counts for assertions captures the verify's context (`output="$ctx"`) and reads `$ctx{errorCount}`. If they need the full FHIR outcome (e.g. to filter by code), they read `$ctx{operationOutcome}` and run JSON pointer over it. See §5.

---

## 3. Validation services

All validation services use the same wire shape:

```http
POST /itb/<svc>/validate
Content-Type: application/json

{
  "sessionId": "abc-123",          // optional
  "config": [                      // optional Configuration entries
    { "name": "version", "value": "4.0" }
  ],
  "input": [                       // AnyContent items
    {
      "name": "contentToValidate",
      "value": "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Smith\"}]}",
      "embeddingMethod": "STRING"
    },
    { "name": "profiles", "value": "http://hl7.org/fhir/StructureDefinition/Patient", "embeddingMethod": "STRING" }
  ]
}
```

> **`mimeType` on inputs.** The ITB does not propagate `mimeType` on input AnyContent items — it's an output-only rendering hint. To declare the format of `contentToValidate` use the explicit `contentType` input below.

Response is a `ValidationResponse`:

```json
{ "report": { /* TAR */ } }
```

### 3.1 `FHIRValidator`

**Path**: `/itb/fhir` — Operation: `validate`.

| Input | Required | Notes |
|---|---|---|
| `contentToValidate` | yes | The FHIR resource to validate, as a string in the format declared by `contentType`. |
| `contentType` | no | `application/fhir+json` (default), `application/fhir+xml`, `text/turtle`. |
| `profiles` | no | Comma-separated profile canonical URLs. |
| `bpWarnings` | no | `Ignore`, `Hint`, `Warning`, `Error`. |
| `resourceIdRule` | no | `OPTIONAL`, `REQUIRED`, `PROHIBITED`. |
| `displayWarnings` | no | `true`/`false`. |
| `failOn` | no | `error` (default), `warning`, `information`. Severity that flips TAR result to FAILURE. |
| `includeContentInReport` | no | `true` (default), `false`. Whether to echo `contentToValidate` in TAR `context`. |

Returns a TAR with the OperationOutcome and (when `includeContentInReport` is true) the validated content in `report.context[]`. See §2.8.

### 3.2 `MatchetypeValidator`

**Path**: `/itb/matchetype` — Operation: `validate`.

| Input | Required | Notes |
|---|---|---|
| `contentToValidate` | yes | Actual resource (FHIR JSON). |
| `matchetype` | yes | Expected pattern (FHIR JSON) — may use `$string$`, `$date$`, `$uuid$`, `$choice:a\|b\|c$` wildcards. |
| `mode` | no | `complete` (default) or `partial`. |

Returns a TAR; mismatches produce `result: FAILURE` with one item per mismatching path.

### 3.3 `FHIRPathAssertion`

**Path**: `/itb/fhirPathAssertion` — Operation: `validate`.

Asserts that a FHIRPath expression evaluates to a singleton Boolean `true`.

| Input | Required | Notes |
|---|---|---|
| `contentToValidate` | yes | The FHIR resource. |
| `expression` | yes | The FHIRPath expression. Should evaluate to a singleton Boolean. |
| `description` | no | Free-text rationale; copied to the TAR item. |

Result mapping:

| FHIRPath result | TAR `result` |
|---|---|
| Singleton `true` | `SUCCESS` |
| Singleton `false` | `FAILURE` |
| Empty collection | `FAILURE` (per FHIRPath conditional semantics) |
| Non-Boolean singleton | `FAILURE` |
| Parse / engine error | `UNDEFINED` |

> **FHIRPath authoring tips (common pitfalls).**
>
> - **Filtering by resource type — don't use `resourceType`.** `resourceType` is a JSON serialisation marker, not a FHIR model property. FHIRPath operates on the typed model, so `.where(resourceType = 'Patient')` always returns empty. Use one of the type-filter operators instead:
>   - `Bundle.entry.resource.ofType(Patient).name`
>   - `Bundle.entry.resource.where($this is Patient).name`
> - **`=` over collections is element-wise.** `Patient.name.text = 'Cristina'` is `true` only when there's exactly one name with that text. With multiple names it returns empty (which the assertion treats as `FAILURE`). Anchor with `.first()` or `.contains(...)` when the path may be multi-valued: `Patient.name.text.first() = 'Cristina'` or `Patient.name.text.contains('Cristina')`.
> - **An empty result is `FAILURE`, not an error.** If a path returns nothing because the data isn't there, you'll see `"Expression returned empty result"` in the TAR — same outcome as `false`. Use `.exists()` to convert presence into an explicit Boolean when that's what you mean.

---

## 4. Processing services

All processing services share four endpoints (`getModuleDefinition`, `process`, `beginTransaction`, `endTransaction`). The validator's processing services are stateless — `beginTransaction` returns a fresh UUID; `endTransaction` is a no-op (HTTP 204).

`process` body:

```http
POST /itb/<svc>/process
Content-Type: application/json

{
  "sessionId": "abc-123",  // optional
  "operation": "evaluate", // operation name (optional when service has only one)
  "input": [
    { "name": "content",    "value": "...", "embeddingMethod": "STRING" },
    { "name": "expression", "value": "Patient.name.family", "embeddingMethod": "STRING" }
  ]
}
```

Response is a `ProcessResponse`:

```json
{
  "output": [
    { "name": "result", "value": "Smith", "embeddingMethod": "STRING", "mimeType": "text/plain" }
  ]
}
```

(Validation-flavoured processing services may also return a `report: TAR` alongside `output[]`; the validator's processing services currently emit only `output[]`.)

### 4.1 `FHIRPathProcessor`

**Path**: `/itb/fhirPath` — Operation: `evaluate`.

Inputs: `content`, `expression`. Output: `result` (the evaluated value as a string; collections are JSON-array-encoded; Booleans `true`/`false`).

> **`contentType` for processing services.** FHIR resources may be serialised in any of three formats:
> - JSON — `application/fhir+json`
> - XML  — `application/fhir+xml`
> - Turtle (RDF) — `text/turtle`
>
> `FHIRPathProcessor` currently assumes `content` is JSON. If callers need to evaluate over an XML or Turtle resource we'd add an explicit `contentType` input on `evaluate` mirroring `FHIRValidator.validate` (§3.1). The same applies to other processing services that accept FHIR content (e.g. `MatchetypeProcessor` if added back as a processing service, `ValidationResultsProcessor` whose `outcome` input is also FHIR JSON today). Not implemented yet — track as a known gap if your tests need it.

For pass/fail assertions, use `FHIRPathAssertion` (§3.3).

### 4.2 `TestDataGenerator`

**Path**: `/itb/testdata` — Operations: `generate`, `generateBundle`, `modify`.

`generate` / `generateBundle` synthesise a fresh resource from a profile.

| Input | Required | Notes |
|---|---|---|
| `profile` | yes | Canonical URL of the StructureDefinition. |
| `mappings` | no | Stringified JSON array of mapping objects. |
| `data` | no | Stringified JSON array of data rows. |
| `requiredOnly` | no | When `"true"`, only required elements (min > 0) are populated. |

Output: `resource` (the generated FHIR resource as JSON). `generateBundle` wraps it in a Bundle.

`modify` mutates an existing resource by applying a sequence of `set` / `add` / `remove` operations.

| Input | Required | Notes |
|---|---|---|
| `resource` | yes | Existing FHIR resource (stringified JSON) to modify. |
| `operations` | yes | Stringified JSON array of `{op, path, value\|parts}` entries. `op` is `set`, `add`, or `remove`. |
| `profile` | no | Canonical URL to validate the result against (used when `enforce=true`). |
| `enforce` | no | When `"true"` (default), the modified resource is validated and the OperationOutcome returned as `output[1]`. When `"false"`, validation is skipped entirely. |

Output: `resource` (the modified resource as JSON), and — iff `enforce=true` — `outcome` (post-modification OperationOutcome).

### 4.3 `ValidationResultsProcessor`

**Path**: `/itb/validationResults` — Operations: `summarize`, `filterBySeverity`, `filterByText`.

Pure JSON utility — does not call the validation engine.

| Operation | Inputs | Outputs |
|---|---|---|
| `summarize` | `outcome` (OperationOutcome JSON) | `errors` (count), `warnings` (count), `information` (count) |
| `filterBySeverity` | `outcome`, `severity` (`fatal\|error\|warning\|information`) | `count`, `outcome` (filtered OperationOutcome) |
| `filterByText` | `outcome`, `text` (substring) | `count`, `outcome` (filtered OperationOutcome) |

### 4.4 `IGManager`

**Path**: `/itb/igManager` — Operation: `loadIG`. Idempotent — re-loading is a no-op.

| Input | Required | Notes |
|---|---|---|
| `ig` | yes | `package#version` (e.g. `hl7.fhir.be.core#2.1.2`). `#current` resolves to the latest build. |

Output: `loaded` (the resolved `package#version`).

A future `listIGs` operation (returning a nested AnyContent list of `{package, version, resources, loadedAt}` per loaded IG) is planned but not implemented.

### 4.5 `FHIRTransformer`

**Path**: `/itb/transform` — Operation: `transform`.

Applies a FHIR `StructureMap` (Mapping Language) to a source resource and returns the transformed result. Same engine path as the legacy native `POST /transform?map=<uri>` handler, exposed in GITB shape so ITB can drive it.

| Input | Required | Notes |
|---|---|---|
| `content` | yes | Source resource (stringified JSON or XML). May be a logical model instance when the StructureMap declares one as its source. |
| `map` | yes | Canonical URL of the `StructureMap` to apply. Must already be in the validator's context — load the IG containing the map via `IGManager.loadIG` first. |
| `contentType` | no | MIME of `content`. Defaults to `application/fhir+json`; use `application/fhir+xml` for XML. |
| `targetFormat` | no | `json` (default) or `xml`. Controls the format of the result. |

Outputs: `result` (the transformed resource as a string) and `targetMime` (`application/fhir+json` or `application/fhir+xml`).

---

## 5. A typical test case

End-to-end flow through the ITB test engine. All handlers use `handlerApiType="REST"`. The handler URI is the service root (the ITB appends operation names per the GITB contract).

> **How outputs are captured.** A test-engine step publishes what it produced to the test-session state via the `output` *attribute* on the step element (not via a child `<output>` element). For:
> - `<process ... output="$myResult">` — `$myResult` receives the operation's `output[]` AnyContent items.
> - `<verify ... output="$ctx">` — `$ctx` receives the **TAR `context[]`** (not the whole TAR). Anything the test author wants to read afterwards must therefore be in the TAR context — that's why the validator publishes counts and the OperationOutcome there (§2.8). The TAR's `report.items[]` and `report.counters` are still rendered in the test report; they're just not in the captured session value.
>
> If you do not bind `output`, the step still passes/fails the test but its data is not retained for later steps.

```xml
<!-- 1) Load the IG -->
<process handler="$DOMAIN{IGManager}" handlerApiType="REST" operation="loadIG">
  <input name="ig">'hl7.fhir.be.core#2.1.2'</input>
</process>

<!-- 2) Generate test data — the operation's output[] is captured into $generated -->
<process handler="$DOMAIN{TestDataGenerator}" handlerApiType="REST" operation="generate" output="$generated">
  <input name="profile">'http://hl7.org/fhir/StructureDefinition/Patient'</input>
</process>

<!-- 3) Validate against the IG. The verify's output captures the TAR context — see §2.8. -->
<verify handler="$DOMAIN{FHIRValidator}" handlerApiType="REST" output="$ctx">
  <input name="contentToValidate">$generated/resource</input>
  <input name="profiles">'http://hl7.fhir.be.core/StructureDefinition/be-patient'</input>
  <input name="failOn">'warning'</input>
</verify>

<!-- 4) Counts are in the captured TAR context (validator publishes them with forReport=false) -->
<assign to="$errorCount">$ctx{errorCount}</assign>
<assign to="$warningCount">$ctx{warningCount}</assign>

<!-- 5) The original FHIR OperationOutcome is also in context — post-process with JSON pointer / JSON path -->
<assign to="$outcomeJson">$ctx{operationOutcome}</assign>

<!-- 6) Or hand the OperationOutcome to ValidationResultsProcessor; bind output via attribute -->
<process handler="$DOMAIN{ValidationResultsProcessor}" handlerApiType="REST" operation="filterByText" output="$filterResult">
  <input name="outcome">$outcomeJson</input>
  <input name="text">'identifier'</input>
</process>
<assign to="$identifierIssueCount">$filterResult/count</assign>

<!-- 7) Boolean assertion via FHIRPathAssertion (a validation service: TAR-emitting). -->
<verify handler="$DOMAIN{FHIRPathAssertion}" handlerApiType="REST">
  <input name="contentToValidate">$generated/resource</input>
  <input name="expression">'Patient.name.given.count() > 0'</input>
</verify>
```

What the test author can read after a validation step (when `<verify ... output="$ctx">` is bound):

| Need | TAR context name | Notes |
|---|---|---|
| Count of errors | `$ctx{errorCount}` | published with `forReport=false` (not in the rendered report) |
| Count of warnings | `$ctx{warningCount}` | same |
| Count of info issues | `$ctx{informationCount}` | same |
| Highest severity | `$ctx{severity}` | `fatal`/`error`/`warning`/`information` |
| The original FHIR `OperationOutcome` | `$ctx{operationOutcome}` | FHIR JSON; post-process with JSON pointer / JSON path |
| The validated payload | `$ctx{content}` | only when `inputs.includeContentInReport` is `true` (the default); use `content:<line>:<col>` locations to drive the ITB inline editor |

Per-issue level/description/location/type/assertionID stay in the rendered TAR `report.items[]` (visible in the ITB report). Test authors who need to drive logic from individual issues should iterate the OperationOutcome with `ValidationResultsProcessor` (or any other JSON-aware processing service).

---

## 6. Operational concerns

### 6.1 Preloading IGs at startup

The existing `-ig` CLI flag pre-populates the engine before any request:

```
java -jar validator_cli.jar http-api -port 8080 -version 4.0 \
  -ig hl7.fhir.be.core#2.1.2 \
  -ig hl7.fhir.uv.ips#2.0.0
```

Test authors SHOULD still emit `IGManager.loadIG` calls so tests stay portable across validator instances; loading an already-loaded package is fast.

### 6.2 Memory

Loaded IGs stay resident for the JVM lifetime. There is no `unloadIG` in v1; restart for memory pressure.

### 6.3 Concurrency

The validator is safe for concurrent reads. Package loads serialise per-package via `synchronized(packageId)`. All `validate` and `process` endpoints are fully concurrent.

### 6.4 Headers

GITB headers are parsed and attached to the SLF4J MDC for the duration of the request, surfacing in structured logs as `testSessionId`, `testCaseId`, `testStepId`.

### 6.5 OpenAPI overlay

`GET /openapi.json` serves the OpenAPI document for these services. The companion file [gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json) is the authoritative machine-readable spec — this markdown is its narrative companion.

---

## 7. Implementation outline

The handlers live in `org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/`:

- `GitbServiceHandler` — base class; HTTP transport, AnyContent helpers, module-definition helpers.
- `GitbValidationServiceHandler` — dispatch base for VS (`getModuleDefinition` + `validate`).
- `GitbProcessingServiceHandler` — dispatch base for PS (`getModuleDefinition` + `process` + `beginTransaction` + `endTransaction`).
- `GitbFhirHandler`, `GitbMatchetypeHandler`, `GitbFhirPathAssertionHandler` — validation services.
- `GitbFhirPathHandler`, `GitbTestDataHandler`, `GitbValidationResultsHandler`, `GitbIgManagerHandler` — processing services.
- `GitbTarBuilder` — `OperationOutcome` → TAR mapping per §2.8.

Routes are wired in `FhirValidatorHttpService.startServer()` under `/itb/<svc>` (one `createContext` per service; sub-paths are handled inside each service).

---

## 8. Resolved decisions

| # | Decision | Rationale |
|---|---|---|
| 1 | One `createContext` per service rooted at `/itb/<svc>`; ITB appends `getModuleDefinition`, `validate`, `process`, etc. | GITB contract — sub-paths are fixed by the kind of service. |
| 2 | `loadIG` lives on a separate `IGManager` Processing Service, not on `FHIRValidator`. | The GITB Validation Service contract has exactly one operation (`validate`); extra ops aren't allowed there. |
| 3 | `FHIRPathAssertion` is a Validation Service (returns TAR), `FHIRPathProcessor` is a Processing Service (returns `output[]`). | An assertion's natural output is a pass/fail TAR; an evaluation's natural output is a value. |
| 4 | Inputs are AnyContent arrays in `input[]`, not flat `inputs: {key: value}`. | GITB schema. |
| 5 | Outputs in `ProcessResponse.output[]` are AnyContent items, not a flat string map. | GITB schema. |
| 6 | The `FHIRValidator.validate` response carries the validated content in `report.context[]` (toggle: `includeContentInReport`, default `true`). | Enables the ITB inline editor + `content:<line>:<col>` location anchors. |
| 7 | A separate `contentType` input replaces using AnyContent's `mimeType` on inputs (per ITB review). | `mimeType` is an output rendering hint — ambiguous on inputs. |
| 8 | URL-fetch (`embeddingMethod: URI`) is SSRF-hardened; can be disabled with `-disable-uri-fetch`. | SSRF is the standard risk for server-side URL fetchers. |
| 9 | `overview.version` = validator Maven version. | Single source of truth; contract version is in OpenAPI's `info.version`. |

---

## 9. References

- Companion machine-readable spec: [gitb-openapi.json](org.hl7.fhir.validation/src/main/resources/org/hl7/fhir/validation/http/gitb-openapi.json)
- GITB Validation Service contract: `gitb-types-development/.../rest/gitb_vs.json` and `schemas/gitb_vs.xsd` / `schemas/gitb_vs.wsdl`
- GITB Processing Service contract: `gitb-types-development/.../rest/gitb_ps.json` and `schemas/gitb_ps.xsd` / `schemas/gitb_ps.wsdl`
- GITB core types (AnyContent, Configuration, TypedParameter, TAR): `schemas/gitb_core.xsd`, `schemas/gitb_tr.xsd`
- Existing native HTTP handlers: `org.hl7.fhir.validation/src/main/java/org/hl7/fhir/validation/http/`
