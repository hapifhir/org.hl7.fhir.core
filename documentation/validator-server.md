# The Validator HTTP Server

The FHIR validator can run as a small HTTP server instead of validating a set of files and
exiting. In this mode the validator loads its definitions, terminology configuration and
implementation guides once, and then serves requests against that already-warmed engine, which
removes the multi-second start up cost from every validation.

The server is also more than a validation endpoint: the same engine is exposed for FHIRPath
evaluation, format and version conversion, snapshot and narrative generation, StructureMap
execution, test data generation, matchetype comparison and terminology ecosystem testing.

An OpenAPI 3.0 description of the API lives beside this document in
[`validator-server.openapi.yaml`](validator-server.openapi.yaml), and the JSON form the server
itself serves at `/openapi.json` is
`org.hl7.fhir.validation/src/main/resources/validator-http-openapi.json`.

## Starting the server

```sh
java -jar validator_cli.jar server <port> [options]
```

The port is a positional parameter and is required. Everything the `validate` command accepts
for configuring the engine works here too:

```sh
java -jar validator_cli.jar server 8080 -version 4.0 \
  -ig hl7.fhir.us.core#6.1.0 \
  -tx https://tx.fhir.org
```

| Option | Meaning |
| --- | --- |
| `<port>` | Port to listen on. Must be 1-65535; anything else exits with an error. |
| `-allowNetworkAccess` | Bind to all interfaces instead of loopback only. See [Security](#security). |
| `-txTests` | Turn on the [terminology ecosystem test](#terminology-ecosystem-tests-txtest) endpoints (`/txTest`). Off by default. |
| `-version` | FHIR version to load (`4.0`, `4.3`, `5.0`, ...). If not given, it is inferred. |
| `-ig` | IG, package, folder or URL to load at start up. Repeatable. |
| `-tx` | Terminology server to use; `n/a` for no terminology server. Nominating a server turns the terminology ecosystem off unless `-ecosystem` is given too. |
| `-ecosystem` | Terminology ecosystem coordination server (tx-reg) to consult for routing; `n/a` to turn the ecosystem off. Default `https://ecosystem.hl7.org/tx-reg`. |
| instance validator options | `-profile`, `-level`, `-best-practice`, `-check-display`, ... - these become the *defaults* for every request, and each can be overridden per request by a query parameter. |

Any remaining positional arguments after the port are treated as sources, but in server mode
they are used only to infer the FHIR version when `-version` is absent - they are not validated
and their content is not loaded.

The server runs until it is stopped with Ctrl-C or by a `POST /stop`.

## How it works

* A single `ValidationEngine` is created at start up and shared by every request. Per-request
  query parameters build a fresh `InstanceValidatorParameters` for that request; they do not
  change the engine.
* `POST /loadIG` *does* change the engine, for every subsequent request, permanently - there is
  no unload.
* The server is a `com.sun.net.httpserver.HttpServer` created with the default executor, so
  requests are handled sequentially on the dispatcher thread. It is designed for one developer,
  one build pipeline, or one test suite at a time - not as a shared multi-tenant service.
* Progress logging (`ResourcePercentageLogger`, validation progress) is suppressed, so the
  console stays readable while the server runs.

### Security

By default the server binds to the loopback address, so only the local machine can reach it.
`-allowNetworkAccess` binds to all interfaces and logs a warning when it does. There is no
authentication, no authorization, no TLS and no rate limiting, and several endpoints will read
from the server's file system (`/loadIG` with a path) or make outbound calls (`/loadIG` with a
package or URL, `/txTest`). If you expose the port beyond localhost, securing it is entirely
your responsibility.

`/txTest` is off unless the server is started with `-txTests`. It exists to run the terminology
ecosystem tests from a build pipeline: it connects to the terminology server the caller names, and
writes the expected and actual output of every test, and the reports, to a folder under the
server's temporary directory - a folder the caller can also name. That is what a pipeline wants,
and not something a public server should offer, so don't combine `-txTests` with
`-allowNetworkAccess` unless the network is one you control. When the server is not bound to
loopback, `/txTest` will only test servers configured in `fhir-settings.json` (a `403` otherwise).

The server is intended for a closed environment - a build pipeline, or a developer's machine. If
it has to be reachable from anywhere else, don't expose it directly: put it behind nginx (or an
equivalent reverse proxy or API gateway) that provides TLS, authentication, and rate and request
size limits, and restrict which endpoints are reachable to the ones you need.

Outbound requests go through the validator's managed web access, so SSRF protection applies
(non-https requests and non-public hosts are blocked) unless it has been turned off - which you
may have to do to point `/txTest` at a terminology server on `localhost` or your own network. With
SSRF protection off, anyone who can reach the server can make it send requests to any host it can
reach, and see some of what comes back. See [SECURITY.md](../SECURITY.md).

## Request and response conventions

**Input format** comes from `Content-Type`: a media type containing `xml` means XML, anything
else - including a missing header - means JSON.

**Output format** comes from `Accept`: a media type containing `xml` means XML, anything else
means JSON. `/convert` and `/transform` use this to pick their output format. `/snapshot`,
`/narrative` and `/version` return the same format they were given, and `/testdata` uses the
`format` field in its body.

**Errors** are FHIR `OperationOutcome` resources, served as `application/fhir+json` or
`application/fhir+xml`. The one exception is a wrong HTTP method, which returns `405` with a
`text/plain` body of `Method not allowed`.

**Paths are context prefixes.** Each endpoint is registered as an `HttpServer` context, so a
longer path with the same prefix also matches: `POST /validateResource/patient-example` is
handled by `/validateResource`. The extra path segments are ignored.

**Success is not signalled by the status code.** A validation that finds errors still returns
`200`; the errors are issues inside the returned `OperationOutcome`. Check issue severities, not
the HTTP status.

## Endpoints

| Method | Path | Purpose |
| --- | --- | --- |
| POST | `/validateResource` | Validate a resource |
| POST | `/fhirpath` | Evaluate a FHIRPath expression against a resource |
| POST | `/matchetype` | Compare a resource against a matchetype pattern |
| POST | `/testdata` | Generate test data for a profile |
| POST | `/loadIG` | Load an IG into the running engine |
| POST | `/convert` | Convert a resource between JSON and XML |
| POST | `/version` | Convert a resource between FHIR versions |
| POST | `/snapshot` | Generate the snapshot for a StructureDefinition |
| POST | `/narrative` | Generate the narrative for a resource |
| POST | `/transform` | Run a StructureMap over a resource |
| GET | `/compile` | Fetch a StructureMap by canonical URL |
| POST | `/txTest/setup` | Start a run of the terminology ecosystem tests against a server |
| GET | `/txTest` | Run one terminology ecosystem test in a run |
| POST | `/txTest/teardown` | End a run, and get its reports |
| POST | `/stop` | Shut the server down |
| GET | `/openapi.json` | The OpenAPI description of this API |
| GET | `/docs` | Swagger UI over `/openapi.json` |
| GET | `/redoc` | Redoc over `/openapi.json` |

### POST /validateResource

The body is the resource; the query string is the validation configuration. The response is an
`OperationOutcome` with one issue per validation message.

```sh
curl -X POST 'http://localhost:8080/validateResource?profile=http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient&level=errors' \
  -H 'Content-Type: application/fhir+json' \
  --data-binary @patient.json
```

Unrecognised query parameter names are rejected. Any name not in the table below produces a
`400` with `Unable to process param <name>=<value>`, which makes typos loud rather than silent.

| Parameter | Values | Notes |
| --- | --- | --- |
| `profile` | canonical URL | Validate against this profile as well as the base spec. Repeatable. Must already be loaded. |
| `extension` | URL domain, or `any` | Extension domains to allow. Repeatable. |
| `bundleValidationRule` | resource name, index, or both | Selects Bundle entries to validate against a profile. Repeatable; paired positionally with `bundleValidationProfile`. |
| `bundleValidationProfile` | canonical URL | The profile for the matching rule. |
| `jurisdiction` | e.g. `US`, `uv`, `global` | Jurisdiction to validate in. |
| `expansionParameters` | reference | Fixed code system / value set versions for expansions. |
| `level` | `hints`, `warnings`, `errors` | Minimum severity reported. Default `hints`. |
| `bestPractice` | `Ignore`, `Hint`, `Warning`, `Error` | **Case sensitive** - matched against the enum constant name. |
| `checkDisplay` | `Ignore`, `Check`, `CheckCaseAndSpace`, `CheckCase`, `CheckSpace` | **Case sensitive.** |
| `resourceIdRule` | `optional`, `required`, `prohibited` | Applies to the outermost resource only. |
| `questionnaire` | `none`, `check`, `required` | QuestionnaireResponse handling. |
| `htmlInMarkdown` | `ignore`, `warning`, `error` | Level for HTML found in markdown. |
| `r5BundleRelativeReferencePolicy` | `default`, `never`, `always` | R5 relative reference resolution rule. |
| `assumeValidRestReferences` | boolean | Infer types from RESTful-looking references. |
| `hintAboutNonMustSupport` | boolean | Hint on elements not marked mustSupport. |
| `wantInvariantsInMessages` | boolean | Include invariant FHIRPath in messages. |
| `noInvariants` | boolean | Skip invariant checking. |
| `unknownCodeSystemsCauseErrors` | boolean | Unknown code systems become errors, not warnings. |
| `forPublication` | boolean | Also check the `Shareable*` profiles. |
| `noUnicodeBidiControlChars` | boolean | BiDi control characters become errors. |
| `verbose` | boolean | Shorthand for crumb trails plus `showMessageIds`. |
| `showMessageIds` | boolean | Include message ids. |
| `allowExampleUrls` | boolean | Treat `example.org` references as valid. |
| `showReferenceMessages` | boolean | Include messages from validating referenced resources. |
| `securityChecks` | boolean | Reject HTML-like tags in string content. |
| `noExperimentalContent` | boolean | Reject experimental content. |
| `txRouting` | boolean | Report which terminology server served each request. |
| `implicitFhirpathStringConversions` | boolean | Restore pre-5.6.48 FHIRPath string conversions. |
| `allowDoubleQuotesInFhirpath` | boolean | Accept legacy double-quoted FHIRPath. |
| `maxValidationMessages` | integer | Stop after this many messages and return what was found. Values <= 0 ignored. |
| `validationTimeout` | milliseconds | Stop after this long and return what was found. |
| `codeSystemValidationSizeLimit` | integer | Max codes checked per include/group/supplement; `0` for no limit. Default 1000. |
| `htmlOutput` | filename | Accepted, but **no effect** in server mode. |
| `outputStyle` | style name | Accepted, but **no effect** in server mode - the response is always an OperationOutcome. |

Booleans are `true`/`false`; anything that is not `true` (case insensitive) is false.

### POST /fhirpath

Evaluates an expression against the posted resource and returns a `Parameters` resource holding
the expression and the string form of the result.

```sh
curl -X POST 'http://localhost:8080/fhirpath?expression=Patient.name.family' \
  -H 'Content-Type: application/fhir+json' \
  --data-binary @patient.json
```

### POST /matchetype

Compares an actual resource against a matchetype - a resource-shaped pattern whose values may be
wildcards such as `$string$`, `$date$` or `$uuid$`. Both go in one JSON wrapper (this endpoint is
JSON only):

```json
{
  "resource":   { "resourceType": "Patient", "name": [{ "family": "Doe" }] },
  "matchetype": { "resourceType": "Patient", "name": [{ "family": "$string$" }] }
}
```

The response is an `OperationOutcome`; no error issues means it matched.

### POST /testdata

Generates conformant example data for a profile. One resource is produced per row of `data`,
with `mappings` binding row columns to element paths. With no `data`, a single row of defaults is
used.

```json
{
  "profile": "http://hl7.org/fhir/StructureDefinition/Patient",
  "data": [{ "familyName": "Doe", "givenName": "John" }],
  "mappings": [
    { "path": "Patient.name.family", "expression": "column('familyName')" },
    { "path": "Patient.name.given",  "expression": "column('givenName')" }
  ],
  "format": "json",
  "bundle": "true"
}
```

`bundle` is compared as the *string* `"true"`, so a JSON boolean `true` does not switch it on.
`requiredOnly` works the same way, and restricts generation to the elements the profile makes
mandatory at the resource's top level.

### POST /loadIG

Loads an IG into the running engine. The value may be a package reference or a URL. A path on
the server's file system is accepted only while the server is bound to loopback (the default);
with `-allowNetworkAccess` a path is refused with 400.

```sh
curl -X POST http://localhost:8080/loadIG \
  -H 'Content-Type: application/json' \
  -d '{"ig": "hl7.fhir.us.core#6.1.0"}'
```

### POST /convert and POST /version

`/convert` re-serialises between JSON and XML (`Content-Type` in, `Accept` out). `/version`
converts between FHIR versions:

```sh
curl -X POST 'http://localhost:8080/version?targetVersion=5.0' \
  -H 'Content-Type: application/fhir+json' \
  --data-binary @observation-r4.json
```

Target versions are `1.0`, `1.4`, `3.0`, `4.0`, `4.3` and `5.0`. Version conversion in server
mode uses the native convertors only, which requires the resource to have a `url` element;
StructureMap-based conversion is not available here and a resource without a `url` fails with a
`500`.

### POST /snapshot and POST /narrative

`/snapshot` takes a StructureDefinition with a differential and returns it with the snapshot
generated (the base definition must be loaded). `/narrative` returns the posted resource with a
generated narrative in `text.div`. Both echo the format they were given.

### POST /transform and GET /compile

`/transform` runs a StructureMap over the posted resource; `/compile` returns the StructureMap
the engine holds for a canonical URL. In both cases the map must already be loaded, via `-ig` at
start up or `/loadIG`.

```sh
curl -X POST 'http://localhost:8080/transform?map=http://example.org/StructureMap/Example' \
  -H 'Content-Type: application/fhir+json' \
  -H 'Accept: application/fhir+json' \
  --data-binary @source.json

curl 'http://localhost:8080/compile?url=http://example.org/StructureMap/Example'
```

`/compile` does not check the HTTP method, so POST and other methods behave the same as GET.

### Terminology ecosystem tests: /txTest

These run the terminology ecosystem tests (the `hl7.fhir.uv.tx-ecosystem` package) against a
terminology server one test at a time, so that your own test framework can report a result per
test. They are for a build pipeline, and are off unless the server was started with `-txTests`;
when they are off, every `/txTest` request is a `404`. A run has three steps.

**`POST /txTest/setup`** starts a run. The body is a JSON object with the things that can't change
during it:

| Property | Required | Default |
| --- | --- | --- |
| `server` | yes | - |
| `test-version` | no | `current` - the version of the test cases (e.g. `1.9.6`), not a FHIR version |
| `externals` | no | none - the *content* of an externals file, as a JSON object, not a file name |
| `folder` | no | the server's host name - the run's folder in the temporary directory |
| `tester` | no | `HL7 Ecosystem Test Runner` - for `TestReport.tester` |

The test cases are loaded and the server is connected to at this point. The server's FHIR
version (from `$versions`, or `/metadata`) decides the version the tests run in; it is not a
setting. The response gives the `session` id, along with the test version that was loaded, the
server's FHIR version, software and declared features, and the output folder.

```sh
curl -X POST http://localhost:8080/txTest/setup -H 'Content-Type: application/json' \
  -d '{"server": "https://tx.fhir.org/r4", "test-version": "1.9.6"}'
```

**`GET /txTest`** runs one test, and returns an `OperationOutcome`: no error-severity issue means
the test passed, otherwise `details.text` is the failure message.

```sh
curl 'http://localhost:8080/txTest?session={id}&suite=SuiteName&test=TestName&modes=general,snomed'
```

| Parameter | Required | Default |
| --- | --- | --- |
| `session` | yes | - |
| `suite` | yes | - |
| `test` | yes | - |
| `modes` | no | `general,snomed,omop,mimetypes,icd-11,icf,loinc` (everything except `tx.fhir.org`) |
| `label` | no | none - a subfolder of the run's folder for this test's expected/actual files |

A test that doesn't run - it is disabled, or gated on a mode that wasn't asked for, a feature the
server doesn't declare, or a FHIR version the server isn't - is an error to ask for, and the
outcome says why; but it is not counted in the run's results. Passing a parameter that setup fixes
(`server`, `test-version`, `externals`, `folder`, or `version`) with a session is a `400`; an
unknown session, suite or test is a `404`.

**`POST /txTest/teardown?session={id}`** ends the run, and returns the two reports the command line
writes, as `{"session", "output", "test-results", "report"}`: `test-results.json`, and
`report.json` - a FHIR `TestReport` with a score and an overall pass/fail. Both are written to the
run's output folder as well. A test run more than once counts once, with its last result.

The older form of `GET /txTest`, with `server` in place of `session` (and optionally `externals`,
naming a file in the test package, and `folder`), still works: the first call for a server makes
an implicit run for it with the `current` test cases, and `POST /txTest/teardown?server=...` ends
it. Runs that are never torn down last for the life of the process.

What the client is expected to do:

* **Own the session.** Whoever calls setup makes the test calls and the one teardown. Sessions
  aren't protected from each other: anyone who has the session id can use it or end it.
* **Tear down once, after the last test has returned.** Teardown ends the session before it
  writes the reports, so a test call for the session after that is a `404`, and so is a second
  teardown. Results are copied once, at teardown: a test still running then (possible only if a
  client sends a test and the teardown concurrently) is not in the reports.
* **Tear down every session you start.** A session that isn't torn down keeps its tester, and its
  `test.log` capture, until the process ends.
* The server handles requests one at a time, so sending test calls in parallel doesn't make a run
  faster; it is allowed, though, and each test's result is recorded safely.

Run one session at a time. Sessions are kept apart in memory, but not on disk: each run's
`test.log` captures everything the process logs (including other sessions) until any run is torn
down, and two runs against the same host - or given the same `folder` - write to the same output
folder, so the last teardown's reports overwrite the others.

### POST /stop

Responds, then stops the server and exits the JVM roughly 100ms later. POST only - a GET
returns `405`.

## Documentation endpoints

`/openapi.json` serves the OpenAPI description (with `Access-Control-Allow-Origin: *`), and
`/docs` and `/redoc` serve Swagger UI and Redoc pages over it. Both UIs load their assets from a
CDN, so the browser needs internet access even though the server itself is local.

The document served at `/openapi.json` is the classpath resource
`validator-http-openapi.json` in `org.hl7.fhir.validation`. Edit that file to change the served
API description; `documentation/validator-server.openapi.yaml` is the same document in YAML for
reading and diffing.

## The bundled client

The CLI includes a matching client command:

```sh
java -jar validator_cli.jar client -port 8080 patient.json
java -jar validator_cli.jar client -host http://localhost:8080 patient.json
```

It translates the usual instance validator options into the query parameters described above,
POSTs each file to `/validateResource`, renders the returned outcome, and exits with `1` if any
file produced errors. `-port` defaults to `80`, `-hostname` to `localhost`; `-host` takes a
hostname and port together.

`-stop` POSTs to `/stop` instead of validating, and exits with `1` if the server did not accept
the request:

```sh
java -jar validator_cli.jar client -port 8080 -stop
```

## Known limitations

* One request at a time; the engine is shared and mutable, so concurrent or unrelated callers
  can affect each other through `/loadIG`.
* No authentication or TLS in any mode.
* `htmlOutput` and `outputStyle` are accepted on `/validateResource` but do nothing.
* An unrecognised `r5BundleRelativeReferencePolicy` value raises an unhandled exception instead
  of returning a `400` OperationOutcome, because the underlying `fromCode` throws
  `FHIRException` rather than `IllegalArgumentException`.
