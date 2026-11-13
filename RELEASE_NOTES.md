## Validator Changes

* Reject abnormal ip address patterns when applying SSRF checks
* Server Mode Fix: -autoLoadPackages loads the package that defines a canonical URL the validator doesn't have (it was supposed to, but wasn't)
* The tx log (-txLog) records a request that got no response - a timeout, or a failed connection - with the error and how long it ran
* When a terminology server says it doesn't have the client's cache the client automatically recovers
* Terminology: $subsumes answers from the server are cached (they were asked again every time); $lookup can ask for designations
* Ecosystem: only send requests to servers known to support code systems
* Terminology Fix: validating a code against a value set with a language no longer puts that language on the caller's validation options, where it applied to whatever was validated next
* Terminology Change: a terminology server is asked about an unknown code system once per run, not once per code
* Remember $lookup failtures for the run, not persisted in the terminology cache as not found, so the next run asks again
* LOINC answer list value sets (http://loinc.org/vs/LL...) go to the terminology server by their implicit url
* a note that a coding isn't in the value set (tx-issue-type this-code-not-in-vs) is no longer reported as the reason a code failed validation when another coding decided the outcome
* New Validation checks:
  * Check for an empty JSON array of a primitive element, or of its `_element`
  * a warning when a coding has no version, but its code system says versionNeeded = true
  * Warnings when an Observation (or component) doesn't fit its LOINC code properties (units, time aspect, scale). Same for profiles on observation
  * Warnings when SNOMED CT code properties don't fit. e.g. code type, status, laterality. Same for profiles
  * Error if SNOMED CT codes in medications are not medications 
  * warnings if there are double negatives in Condition, Allergy etc (refuting the refutation)

## Other code changes

* Ecosystem fixes: Excludes in value sets that terminology servers expand results in the valueset being sent whole to a single server 
* Narrative: ValueSet expansions show the issues the expansion reports (expansion-issue extension, most severe first) and the reason the value set is unclosed, as notes about the expansion
* Narrative: CapabilityStatement server-wide search parameters (rest.searchParam) are shown (they never were)
* Narrative: ExampleScenario diagrams - an operation with no request payload no longer runs into the next line of the PlantUML source
* Narrative: StructureDefinition mappings from a ConceptMap use the map's title or id when it has no name, and link element ids with [x] to the _x_ anchors (from oliveregger's core PR 2751)
* Narrative: Questionnaire display items have a blank cardinality cell
* Narrative: fix the XIG usage link in the French and Swedish translations
* NPM package index: only root properties of a resource are indexed - a complex element such as Media.type or DocumentReference.content was taken as the index's type/content, and a property inside it (e.g. content.url) as a root property; a file that can't be read is left out; the .index.db is written in one transaction (much faster for large packages), and each index builder has its own database (they were shared when several packages were built at once)
* Fix file handles that were left open across the parsers, the terminology cache, comparison, and the validator utilities
* Terminology client: the tx log records requests that got no response in the R4 and R4B clients too
* Terminology cache files: $lookup properties are written without HTML escaping, so they stay readable
* FHIR client (R4 and R5): executeAsBatch sends the request headers (they were dropped)
* txTests: a test case can let the server choose between answers by HTTP status ("http-code" : "200|4xx" with "response:200" and "response:4xx")
* FHIRPathExpressionFixer: faster
* Add the FHIRsmith terminology cache error messages
* Dependency updates: guava 33.8.0, ognl 3.4.17, opentelemetry 1.68.0 (instrumentation 2.33.1)
