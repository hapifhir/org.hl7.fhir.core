---
name: hl7-pr-review
description: Full review of a large org.hl7.fhir.core, fhir-ig-publisher or kindling PR - SpotBugs diff, parallel review, and a list of areas for manual review. Long-running. Start it only when the user types /hl7-pr-review or confirms it through the hl7-code-review skill's question.
argument-hint: "<PR#> <branch> [output-dir]"
---

# Full PR review

Arguments: `$ARGUMENTS` = PR number, local branch name, and optionally an output directory. If no directory is given, ask for one, or use `./target/pr-review-<PR#>/` (gitignored) if the user doesn't mind.

## Ground rules

The `fhir-core-reviewer` agent (`.claude/agents/fhir-core-reviewer.md`) holds the review rules and the HL7 checklist. Don't restate them in briefs; the agent already has them. Also:
- Diff against the merge-base, not a moving master.
- Don't touch the user's checkout: no branch switching, no stash, no commits. Use worktrees for anything that needs another commit checked out.
- Before relaying a reviewer's logic claim, verify it yourself: re-read the code, or write and run a focused test. Mark the findings you verified yourself with ✔. A subagent's claim has been wrong before.

## Step 1: Scope

```bash
gh pr view <PR#> --json title,body,commits,headRefOid,baseRefName
git fetch -q origin
BASE=$(git merge-base origin/master <branch>)
git diff --stat "$BASE" <branch>
```

- Check that the local branch head matches `headRefOid`. If it doesn't, tell the user, and review `headRefOid` (fetch it if needed).
- Separate generated model code (`// This file is generated code` header), txCache files and other test resources, and hand-written code.
- If the PR changes public API, resolve the kindling and fhir-ig-publisher paths now (see "Sibling repositories" in `CLAUDE.md`), so the step 3 agents can check them.

## Step 2: SpotBugs, in the background

Use the `spotbugs-diff` skill with `$BASE` and the PR head. It takes about 30–40 minutes, so start it first and do steps 3–4 while it runs.

## Step 3: Parallel review

Start about 3 `fhir-core-reviewer` agents in one message (`subagent_type: fhir-core-reviewer`), one per area:
- **Validator, HTTP and utilities**
- **FHIRPath, context and terminology**, including the per-version copies
- **Renderers, convertors, generated code and test resources**

Each brief: the base and head SHAs, that agent's file list, the sibling paths resolved in step 1 (if any), and "Review `git diff <BASE> <HEAD> -- <files>` following your instructions and return your tables." For large areas, split further rather than give one agent hundreds of files.

For txCache files, follow the txCache section of the `hl7-code-review` skill yourself.

## Step 4: Verify

Re-check every Med or High finding against the code on the PR head. For logic claims, write a focused test where that's practical, run it on the PR head, and keep the test file in the output directory, not in the repo. Drop anything that doesn't hold up.

## Step 5: Write three concise files to the output directory

1. `spotbugs-new-issues.md`: the `spotbugs-diff` report. New issues only (rank, type, class.method, line), the counts, and any coverage gaps.
2. `code-review.md`: the head SHA and merge-base, then tables for Security, Logic, Duplication and Tests (Sev / Location / Problem / Fix / ✔), then an "Unsure" list.
3. `manual-review-areas.md`: ordered by risk. For each area: what the change is meant to do, and why a human needs to look at it.

Then tell the user where the files are, and give the top findings in a few lines.
