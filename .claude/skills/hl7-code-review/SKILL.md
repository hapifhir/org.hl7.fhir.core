---
name: hl7-code-review
description: Code review entry point for org.hl7.fhir.core and its sibling repos (fhir-ig-publisher, kindling, fhir-test-cases). Use when asked to review a GitHub PR, or to review or summarise txCache or test-resource changes in a PR.
---

# HL7 Code Review Skill

This skill supports code review for org.hl7.fhir.core and its sibling repos. They are often checked out next to this repo, but not always. Resolve a sibling's real path as described in "Sibling repositories" in `CLAUDE.md` before using it.

## Projects

| Default location (relative to this repo's root) | GitHub repo |
|---|---|
| `.` | `hapifhir/org.hl7.fhir.core` |
| `../fhir-ig-publisher` | `HL7/fhir-ig-publisher` |
| `../kindling` | `HL7/kindling` |
| `../fhir-test-cases` | `FHIR/fhir-test-cases` |

## Offering the Full PR Review Command

When asked to review a GitHub PR (not just its txCache or test resources), first check whether the PR belongs to one of the projects covered by the `/hl7-pr-review` command:

| Project | GitHub Repo |
|---|---|
| org.hl7.fhir.core | `hapifhir/org.hl7.fhir.core` |
| fhir-ig-publisher | `HL7/fhir-ig-publisher` |
| kindling | `HL7/kindling` |

Skip this section if:
- the review is already running under `/hl7-pr-review` (which uses this skill for txCache files),
- the user only asked about txCache or test resources, or
- the user is reviewing their own unpushed branch. Use `/pre-pr-review` for that.

### 1. Identify the project

Use the repo named in the PR URL if one was given. Otherwise, read it from the current repository:

```bash
gh repo view --json nameWithOwner --jq .nameWithOwner
```

If the repo is not one of the three above (for example `FHIR/fhir-test-cases`), don't offer the command. Continue with the sections below as appropriate.

### 2. Work out the command arguments

`/hl7-pr-review` takes a PR number and the local branch name. Fill in whichever one the user didn't give:

```bash
# Branch from a PR number
gh pr view <PR_NUMBER> --json headRefName --jq .headRefName

# PR number from a branch
gh pr view <BRANCH> --json number --jq .number
```

If neither can be determined, use `<PR#>` or `<branch>` as a placeholder in the preview and ask for the missing value.

### 3. Ask the user

Use the AskUserQuestion tool to ask whether to run the full review. Put the exact command that would run in the `preview` field of the first option. For example:

- Question: "PR #2799 is in hapifhir/org.hl7.fhir.core. Run the full review command?"
- Option 1: **Run /hl7-pr-review (Recommended)**. Description: SpotBugs diff against master, a parallel review focused on security and duplication, and a list of areas to review manually. Preview:

  ```
  /hl7-pr-review 2799 2026-10-gg-more

  PR:     #2799  (hapifhir/org.hl7.fhir.core)
  Branch: 2026-10-gg-more
  Steps:  1. SpotBugs on PR head and merge-base (git worktrees, ~15–20 min each)
          2. Parallel review: security, duplication, logic, tests
          3. Writes spotbugs-new-issues.md, code-review.md, manual-review-areas.md
  ```

- Option 2: **Review without the command**. Description: a lighter review using only this skill and the conversation.

If the user picks the command, invoke it with the Skill tool (`skill: "hl7-pr-review"`, `args: "<PR#> <branch>"`). If they decline, do a lighter review: start one `fhir-core-reviewer` agent on the PR diff (`gh pr diff <n>`, or the merge-base diff of the local branch) and report its verified findings.

## Reviewing txCache Changes

When asked to **"review txCache changes"** for a PR in the org.hl7.fhir.core project, follow these steps:

### 1. Identify the PR and its txCache files

```bash
gh pr diff <PR_NUMBER> --name-only | grep txCache
```

### 2. Analyse the changes

For each changed txCache file, examine what changed:

```bash
gh pr diff <PR_NUMBER> -- 'path/to/txCache/file'
```

txCache files are cached terminology server responses stored under `src/test/resources/txCache/` in the `r5`, `standalone`, `validation` and `convertors` modules. They are organised by:
- **Module** (e.g., `org.hl7.fhir.validation`, `org.hl7.fhir.r5`)
- **FHIR version** (e.g., `4.0.1`, `5.0.0`, `r5`)
- **Code system or query type** (e.g., `snomed.cache`, `loinc.cache`, `cs-externals.json`)

Common file types and what to look for:
- `*.cache` files — cached code system or value set validation responses; check if changes reflect legitimate new terminology queries or updated server responses
- `cs-externals.json` / `vs-externals.json` — index of external code systems/value sets; check for new or removed entries
- `system-map.json` — mapping of system URLs; check for new system aliases or corrections
- `servers.ini` / `version.ctl` — server metadata; usually safe to accept without deep review
- `.terminologyCapabilities.*.cache` — server capability snapshots; safe to accept if server URL looks expected

### 3. Output a summary

Summarize the txCache changes in plain language, grouped by FHIR version/module. For example:
- Which code systems have new or changed cached entries
- Whether new cache files were added
- Whether any entries were removed
- Whether the changes look consistent with a terminology server update vs. a bug fix

### 4. Ask the user whether to mark files as reviewed

After presenting the summary, ask:

> Would you like me to mark all txCache files in this PR as reviewed on GitHub?

### 5. Mark files as reviewed (if user says yes)

First, get the PR node ID:

```bash
gh pr view <PR_NUMBER> --json id
# Returns e.g. {"id":"PR_kwDOCd4Was7O4Xvg"}
```

Then mark each txCache file as viewed using the GitHub GraphQL `markFileAsViewed` mutation:

```bash
GH=$(command -v gh)   # resolve once; gh may not be on PATH inside the loop's subshell
PR_NODE_ID="<id from above>"

"$GH" pr diff <PR_NUMBER> --name-only | grep txCache | while read -r path; do
  "$GH" api graphql -f query="
mutation {
  markFileAsViewed(input: {pullRequestId: \"$PR_NODE_ID\", path: \"$path\"}) {
    pullRequest { id }
  }
}" > /dev/null && echo "Marked: $path"
done
```

## Reviewing Other Non-Java Test Resources

The `src/test/resources/` path in each module may contain other non-Java files worth reviewing:

- **`*.json` / `*.xml` / `*.fhir`** — FHIR resource fixtures used in tests; review for correctness of the resource content
- **`*.txt` / `*.csv`** — Test data files; review for expected format and content
- **Snapshot files** — Expected output captured from prior runs; review diffs to confirm they match intentional behavior changes

When reviewing these, focus on whether the changes are consistent with the code changes in the same PR, and whether any expected outputs have changed in ways that suggest regressions rather than intentional updates.
