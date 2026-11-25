## Project Conventions

This is a Java project using Maven and JUnit 5. Tests use parameterized tests, @Disabled annotations (not @Ignore), and do not use unnecessary `public` modifiers on test classes/methods. Always run `mvn test -pl <module>` after making test changes to verify they pass.

## Module map

- `org.hl7.fhir.utilities`: shared utilities. Every other module depends on it.
- `org.hl7.fhir.dstu2`, `dstu2016may`, `dstu3`, `r4`, `r4b`, `r5`: per-version models plus their FHIRPath, terminology, renderers and context code. These models used to be generated; they are now maintained by hand.
- `org.hl7.fhir.model`: the R6 model. `org/hl7/fhir/model/core/**` is **generated** (see below).
- `org.hl7.fhir.services`: the R6 FHIRPath engine, terminology, renderers, elementmodel and conformance code (`IModelContext` implementations).
- `org.hl7.fhir.standalone`: a standalone R6 `IWorkerContext` (context and terminology) for command-line use.
- `org.hl7.fhir.convertors`: version-to-version converters.
- `org.hl7.fhir.validation`, `org.hl7.fhir.validation.cli`: the validator and its CLI/HTTP server.
- `org.hl7.fhir.core.generator`: the R6 code generator. It is **not** a Maven module of the root pom. See its `readme.md`.
- `org.hl7.fhir.report`: only aggregates reports.

## Per-version copies

A lot of logic exists in several copies: r4, r4b and r5 (`fhirpath`, `terminologies`, `renderers`, `context`), plus the R6 copies in `services`, `standalone` and `model/utilities`. Examples are `FHIRPathEngine`, `CodeSystemUtilities`, `ValueSetExpander`, `ValueSetValidator` and `BaseWorkerContext`.
- When you change one copy, find the others (`find . -name <Class>.java -not -path '*/target/*'`) and decide whether they need the same change. Usually r5 and its R6 copies do.
- The copies existing is expected; don't report it as duplication. Copies that have **diverged** without a reason are a finding.

## Generated code

Files that start with `// This file is generated code - do not edit it.` (mainly `org.hl7.fhir.model/src/main/java/org/hl7/fhir/model/core/**`) are produced by `org.hl7.fhir.core.generator`. To change them, edit the templates in `org.hl7.fhir.core.generator/configuration` or `add-ons-config*`, not the output.

## Downstream consumers

`kindling` (HL7/kindling) and `fhir-ig-publisher` (HL7/fhir-ig-publisher) import core classes directly. For example, kindling's `RdfGenerator` uses `org.hl7.fhir.dstu3.formats.TurtleLexer`. So "no callers in this repo" does **not** mean dead code.
- Before you delete or call unused any public class or method, or change a public signature, grep the kindling and fhir-ig-publisher checkouts (see "Sibling repositories").
- If they aren't checked out, say so, and use `gh search code --repo HL7/kindling --repo HL7/fhir-ig-publisher <Symbol>` instead.

## Sibling repositories

Developers clone these wherever they like, so never assume a path.

| Name | GitHub repo | Default location to try |
|---|---|---|
| kindling | `HL7/kindling` | `../kindling` |
| fhir-ig-publisher | `HL7/fhir-ig-publisher` | `../fhir-ig-publisher` |
| fhir-test-cases | `FHIR/fhir-test-cases` | `../fhir-test-cases` |

When a task needs one of them, resolve its path in this order:
1. **Memory.** Use the `sibling-repo-paths` auto-memory if it exists. Check that the remembered path still exists. If it doesn't, treat the repo as unknown.
2. **Default location.** Accept the default location only if `git -C <path> remote -v` shows a URL containing the GitHub repo name.
3. **Ask.** Use AskUserQuestion with these options: clone it to the default location (`gh repo clone <GitHub repo> <path>`, recommended), give another path (verify it as in step 2), or "not checked out, use `gh search code`".
4. **Remember.** Write or update the `sibling-repo-paths` memory (type `reference`, one line per repo with an absolute path or "not checked out") in your auto-memory directory, and its `MEMORY.md` pointer. Record "not checked out" too, so you don't ask again. Never store these paths under this repo's `.claude/`.

Subagents can't ask the user or read your memory. Resolve the paths first and put them in the subagent's brief.

## Build and analysis

- Compile without tests: `mvn -B -Dmaven.test.skip install`. Single module tests: `mvn test -pl <module> -Dtest=<TestClass>`.
- For SpotBugs, see the "SpotBugs" section of `README.md`. To compare a branch's SpotBugs results with master, use the `spotbugs-diff` skill.
- Test resources come partly from the `fhir-test-cases` artifact. `txCache` directories hold recorded terminology server responses (see `.claude/rules/txcache.md`).

## Before opening a pull request

Run `/pre-pr-review` before `gh pr create`. It reviews the branch in a fresh context and records the result under `.claude/review-state/`. A hook in `.claude/settings.json` blocks `gh pr create` until a review exists for the current HEAD.
- Never create or edit files in `.claude/review-state/` yourself. Only the user may add `acknowledged: true` to accept the remaining findings.
- See `.claude/README.md` for the full set of shared Claude Code skills, agents and rules.
