---
name: pre-pr-review
description: Review the current branch against origin/master before opening a pull request in org.hl7.fhir.core. Use when the user asks to review their own changes or branch, or before running gh pr create.
argument-hint: "[spotbugs]"
---

# Pre-PR review

Review the committed changes on this branch the way a separate reviewer would, before a PR is opened. The reviewers are `fhir-core-reviewer` subagents, which start with a fresh context. They don't see this conversation, so they aren't anchored on the reasoning that produced the code. Don't pass them your opinion of the change; give them the diff range and the files.

Arguments: `$ARGUMENTS`. If it contains `spotbugs`, also run step 5.

## 1. Scope

```bash
git fetch -q origin master
BASE=$(git merge-base origin/master HEAD)
HEAD_SHA=$(git rev-parse HEAD)
git status --porcelain --untracked-files=no
git diff --stat "$BASE" HEAD
git log --oneline "$BASE"..HEAD
```

- If tracked files have uncommitted changes, tell the user. The review covers HEAD only, so ask whether to commit first or continue with the committed changes only.
- If `$BASE` equals HEAD, there is nothing to review. Say so and stop.
- Split the changed files into: generated (`// This file is generated code` header), txCache (`**/txCache/**`), other test resources, and hand-written code (main and test).

## 2. Review in parallel

Start `fhir-core-reviewer` agents with the Agent tool (`subagent_type: fhir-core-reviewer`). Send all of them in one message so they run at the same time.
- Up to about 15 hand-written files: start one agent with all of them.
- More than that: start up to 3 agents, split by area. The areas are (a) validator, HTTP and utilities; (b) FHIRPath, context and terminology; (c) renderers, convertors, generated code and test resources.
- Each brief contains: the base and head SHAs, the file list for that agent, and the instruction "Review `git diff <BASE> <HEAD_SHA> -- <files>` following your instructions and return your tables." Nothing else, except: if the diff changes public API, resolve the kindling, fhir-ig-publisher and validator-wrapper paths (see "Sibling repositories" in `CLAUDE.md`). Also ask the user whether to check hapi-fhir (see "Downstream consumers"). If they agree, resolve its path too. Add the paths to the brief.
- Summarise txCache changes yourself, following `.claude/rules/txcache.md`. Don't send them to the agents.

## 3. Verify before reporting

For each finding the agents return:
- Open the cited `path:line` on HEAD and check that the claim holds. Drop findings that don't.
- For Med or High logic findings marked unverified, write a focused test or run an existing one (`mvn test -pl <module> -Dtest=<Class>#<method>`) when that's practical. Agents' logic claims have been wrong before.
- Drop duplicates between agents. Keep the clearer one.

## 4. Report

Show the user the merged tables (Sev / Location / Problem / Fix / Verified) and the "Unsure" list, with the base and head SHAs that were reviewed. Say whether any Med or High findings remain.

If the user fixes findings and commits, HEAD changes, so the review has to be run again to cover the new commits.

## 5. SpotBugs (only if requested)

Use the `spotbugs-diff` skill to compare `$BASE` with `HEAD_SHA`. It takes about 30–40 minutes, so run it in the background while steps 2–3 run. Add the new-issue table to the report. Any new issue within the root `pom.xml` `spotbugs.threshold`/`spotbugs.maxRank` counts as a Med finding.
