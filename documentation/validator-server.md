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
| `-version` | FHIR version to load (`4.0`, `4.3`, `5.0`, ...). If not given, it is inferred. |
| `-ig` | IG, package, folder or URL to load at start up. Repeatable. |
| `-tx` | Terminology server to use; `n/a` for no terminology server. |
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
| GET | `/txTest` | Run one terminology ecosystem test against a server |
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
| `checkIpsCodes` | boolean | Report SNOMED CT codes outside the IPS free set. |
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

### POST /loadIG

Loads an IG into the running engine. The value may be a package reference, a URL, or a path on
the server's file system.

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

### GET /txTest

Runs one test from the terminology ecosystem test suite against a terminology server. The test
package (`hl7.fhir.uv.tx-ecosystem#dev`) is downloaded on first use.

```sh
curl 'http://localhost:8080/txTest?suite=SuiteName&test=TestName&server=https://tx.fhir.org/r4'
```

| Parameter | Required | Default |
| --- | --- | --- |
| `suite` | yes | - |
| `test` | yes | - |
| `server` | yes | - |
| `version` | no | `5.0` |
| `externals` | no | `messages-tx.fhir.org.json` (`.json` appended if missing) |
| `modes` | no | `tx.fhir.org,omop,general,snomed` |

A tester is created per `server` value and cached for the life of the process, so `version` and
`externals` only take effect on the first call for a given server. A disabled suite or test
reports success without running. Missing parameters and lookup failures both come back as `500`.

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
