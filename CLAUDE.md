## Project Conventions

This is a Java project using Maven and JUnit 5. Tests use parameterized tests, @Disabled annotations (not @Ignore), and do not use unnecessary `public` modifiers on test classes/methods. After changing a test, run it with `mvn test -pl <module> -Dtest=<TestClass>` and report the result.

## Module map

- `org.hl7.fhir.utilities`: shared utilities. Every other module depends on it.
- `org.hl7.fhir.dstu2`, `dstu2016may`, `dstu3`, `r4`, `r4b`, `r5`: per-version models plus their FHIRPath, terminology, renderers and context code. These models used to be generated; they are now maintained by hand.
- `org.hl7.fhir.dstu3.support`: DSTU3 worker context (`SimpleWorkerContext`), terminology (value set expansion and checking), `ProfileUtilities`, `NarrativeGenerator` and the DSTU3 `FHIRToolingClient`, moved out of `org.hl7.fhir.dstu3`. Used by `convertors` and `validation`, and by fhir-ig-publisher.
- `org.hl7.fhir.model`: the R6 model. `model/core/**` is **generated** by the core generator, and `model/api`, `fml`, `testing` and `tools` by `ig-codegen` (see `.claude/rules/generated-code.md`).
- `org.hl7.fhir.services`: the R6 FHIRPath engine, terminology, renderers, elementmodel and conformance code (`IModelContext` implementations).
- `org.hl7.fhir.standalone`: a standalone R6 `IWorkerContext` (context and terminology) for command-line use.
- `org.hl7.fhir.convertors`: version-to-version converters.
- `org.hl7.fhir.validation`, `org.hl7.fhir.validation.cli`: the validator and its CLI/HTTP server.
- `org.hl7.fhir.core.generator`: the R6 code generator. It is **not** a Maven module of the root pom. See its `readme.md`.
- `org.hl7.fhir.support`: standalone maintenance tools, almost all run through a `main()` method: terminology importers (VSAC, CPT, LOINC and others), package building and fixing, IG and search parameter analysis, and test data generators. It depends on most other modules, and only `org.hl7.fhir.report` depends on it.
- `org.hl7.fhir.report`: only aggregates reports.

## Per-version copies and generated code

Much of this code exists in several per-version copies, including the `conv*_50` and `conv*_N` convertor clones, and some of it is generated. Before you change or review code in r4, r4b, r5, `services`, `standalone`, `model` or `convertors`, read `.claude/rules/per-version-copies.md` and `.claude/rules/generated-code.md`. They load on their own when you open a matching file, but not when you only read a diff.

## Downstream consumers

`kindling` (HL7/kindling) and `fhir-ig-publisher` (HL7/fhir-ig-publisher) import core classes directly. For example, kindling's `RdfGenerator` uses `org.hl7.fhir.dstu3.formats.TurtleLexer`. So "no callers in this repo" does **not** mean dead code.
- Before you delete or call unused any public class or method, or change a public signature, grep the kindling and fhir-ig-publisher checkouts (see "Sibling repositories").
- If they aren't checked out, say so, and use `gh search code --repo HL7/kindling --repo HL7/fhir-ig-publisher <Symbol>` instead.

## Sibling repositories

Developers clone these wherever they like and name the folders as they like, so never assume a path.

| Name | GitHub repo | Clone location if missing |
|---|---|---|
| kindling | `HL7/kindling` | `../kindling` |
| fhir-ig-publisher | `HL7/fhir-ig-publisher` | `../fhir-ig-publisher` |
| fhir-test-cases | `FHIR/fhir-test-cases` | `../fhir-test-cases` |

Paths are relative to this repo's root (`git rev-parse --show-toplevel`). When a task needs one of these repos, resolve its path in this order:
1. **Memory.** If you have auto-memory, use the `sibling-repo-paths` memory if it exists. Check that the remembered path still exists and still matches (see step 2). If it doesn't, treat the repo as unknown.
2. **Scan the parent folder.** Check every folder next to this repo: `for d in ../*/; do git -C "$d" remote -v 2>/dev/null | sed "s|^|$d |"; done`. A folder matches if any remote URL ends in the repo name, with or without `.git`, for example `.../kindling.git`. This also catches forks whose `upstream` is the HL7 repo.
   - Exactly one match: use it.
   - Several matches: ask which one to use.
3. **Ask.** If nothing matches, ask the developer, with AskUserQuestion if you have it. Offer three options: clone it to the location in the table (`gh repo clone <GitHub repo> <path>`, recommended), give another path (verify it as in step 2), or "not checked out, use `gh search code`".
4. **Remember.** If you have auto-memory, write or update the `sibling-repo-paths` memory (type `reference`, one line per repo with an absolute path or "not checked out") and its `MEMORY.md` pointer. Record "not checked out" too, so you don't ask again. Without auto-memory, reuse the answer for the rest of the session. Never store these paths in this repo, including `.claude/`.

Subagents can't ask the user or read your memory. Resolve the paths first and put them in the subagent's brief.

## Build and analysis

- Compile without tests: `mvn -B -Dmaven.test.skip install`. Single module tests: `mvn test -pl <module> -Dtest=<TestClass>`.
- Ask the developer before you start full-reactor or multi-module runs (for example `mvn install` across modules). They take a long time, and they rewrite `target/` directories that the developer's own test runs may be using. Say which modules or tests you want to run and why.
- For SpotBugs, see the "SpotBugs" section of `README.md`. To compare a branch's SpotBugs results with master, use the `spotbugs-diff` skill.
- Test resources come partly from the `fhir-test-cases` artifact. `txCache` directories hold recorded terminology server responses (see `.claude/rules/txcache.md`).

## Before opening a pull request

Run `/pre-pr-review` before `gh pr create`. It reviews the branch in a fresh context and reports the verified findings.

See `.claude/README.md` for the full set of shared Claude Code skills, agents and rules.
