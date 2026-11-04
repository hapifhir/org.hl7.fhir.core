---
name: spotbugs-diff
description: Run SpotBugs on two commits of org.hl7.fhir.core (for example a PR head and its merge-base with master) and list the issues the change introduces. Use when asked to run SpotBugs for a PR or branch, or to compare SpotBugs results between commits.
argument-hint: "<base-commit> <head-commit>"
---

# SpotBugs diff

Arguments: `$ARGUMENTS`, the base and head commits. Default: `git merge-base origin/master HEAD` and `HEAD`. Compare against the merge-base, not a moving `origin/master`.

The SpotBugs settings (`spotbugs.threshold`, `spotbugs.maxRank`) are in the root `pom.xml`. See the "SpotBugs" section of `README.md` for the plain commands.

## 1. Check out both commits as worktrees

Use detached worktrees in a scratch directory, so the user's checkout and branch aren't touched:

```bash
WT=$(mktemp -d)/spotbugs
git worktree add --detach "$WT/base" <base>
git worktree add --detach "$WT/head" <head>
```

## 2. Run SpotBugs in each, one after the other, in the background

```bash
mvn -B -fae -DskipTests -Danimal.sniffer.skip=true -pl '!org.hl7.fhir.report' \
    package spotbugs:spotbugs > spotbugs.log 2>&1
```

- Use `-DskipTests` with `package`, not `-Dmaven.test.skip`. `org.hl7.fhir.validation.cli` needs the `utilities` and `convertors` test-jars, and `-Dmaven.test.skip` doesn't build them, so that module silently isn't analysed.
- Each run takes about 15–20 minutes on an idle machine, longer with an IDE open. Run the two one after the other, not at the same time.
- If a module logs `SpotBugs execution timed out`, rerun it with `-Dspotbugs.timeout=3600000`.
- For a lower threshold, add `-Dspotbugs.threshold=Low -Dspotbugs.maxRank=20` to both runs.

## 3. Diff

```bash
python3 -I "${CLAUDE_SKILL_DIR}/scripts/spotbugs_diff.py" "$WT/base" "$WT/head"
```

The script matches issues by `(type, instanceHash)`, which is stable across line shifts. It prints per-module counts, new issues, removed issues, and any module that has no results on one side.

## 4. Report

Write the output concisely: the command and threshold you used, the count table, the new issues (rank, type, class.method, file:line), and any coverage gaps. Report coverage gaps explicitly; never treat a missing module as "0 new issues". For each new issue, open the cited line on the head commit and say in one line what the problem is.

## 5. Clean up

```bash
git worktree remove --force "$WT/base"; git worktree remove --force "$WT/head"
```
