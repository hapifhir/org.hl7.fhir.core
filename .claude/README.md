# Claude Code setup for org.hl7.fhir.core

This directory holds shared [Claude Code](https://code.claude.com/docs) configuration. It's picked up automatically when you run `claude` in this repo; there's nothing to copy into `~/.claude/`. The first time, Claude Code asks you to trust the folder. The permissions and hooks below apply only after you accept.

## What's here

| Path | What it does | How to use it |
|---|---|---|
| `../CLAUDE.md` | Loaded into every session: the module map, per-version copies, generated code, downstream consumers, build commands. | Automatic. |
| `rules/*.md` | Extra guidance that loads only when Claude reads or edits matching files: tests, txCache, per-version copies, generated code. | Automatic. |
| `agents/fhir-core-reviewer.md` | A read-only review subagent with the team's review rules and an HL7-specific checklist. It runs on Opus at high effort, because review quality is the point; expect it to use more of your usage than a normal turn. | Used by the review skills. You can also ask Claude to "use the fhir-core-reviewer agent on <files>". |
| `skills/pre-pr-review/` | Reviews your branch against `origin/master` in fresh-context subagents, verifies the findings, and records the result for the hook. | `/pre-pr-review`, or `/pre-pr-review spotbugs` to add a SpotBugs diff (about 30–40 min). |
| `skills/hl7-pr-review/` | Full review of someone else's large PR: SpotBugs diff, a 3-way parallel review, verification, and three report files. | `/hl7-pr-review <PR#> <branch> [output-dir]`, or ask "review PR <n>" and accept the offer. |
| `skills/hl7-code-review/` | Entry point when you ask Claude to review a PR. It offers `/hl7-pr-review`, and summarises txCache and test-resource changes (and can mark them as viewed on GitHub). | Ask "review PR <n>" or "review the txCache changes in PR <n>". |
| `skills/spotbugs-diff/` | Runs SpotBugs on two commits in temporary worktrees and lists the new issues, using `scripts/spotbugs_diff.py`. | `/spotbugs-diff [<base> <head>]`. |
| `skills/regex/` | ReDoS and correctness checks for regexes (OWASP/OpenSSF guidance, `npx safe-regex2`). | Loads when a regex is involved. Needs Node/npx for `safe-regex2`. |
| `hooks/require-pre-pr-review.sh` | Blocks Claude's `gh pr create` until `/pre-pr-review` has a clean (or user-acknowledged) result for the current HEAD. | Automatic. See below. |
| `settings.json` | Registers the hook and pre-approves read-only `git`/`gh` commands. | Automatic. Put personal settings in `settings.local.json` (gitignored). |

## Before opening a PR

1. Commit your work.
2. Run `/pre-pr-review`. It writes `.claude/review-state/<HEAD-sha>.md` (gitignored) with `status: clean` or `status: findings`.
3. Fix the findings and commit. That changes HEAD, so run `/pre-pr-review` again. If you decide to accept the remaining findings, add a line `acknowledged: true` to the review-state file yourself.
4. Now `gh pr create` from Claude goes through.

The hook only checks commands Claude runs. `gh pr create` in your own terminal isn't affected. To turn the hook off for a session, start Claude with `CLAUDE_SKIP_PRE_PR_REVIEW=1 claude`.

## Recommended local setup (optional)

- Check out `kindling`, `fhir-ig-publisher` and `fhir-test-cases` anywhere you like. The reviewers grep kindling and fhir-ig-publisher before calling code unused or a public API change safe. The first time a task needs one, Claude checks `../<name>`. If it isn't there, Claude asks for the path or offers to clone it, then remembers the answer in your own auto-memory (`~/.claude/projects/...`), not in this repo. See "Sibling repositories" in `../CLAUDE.md`. This needs auto-memory on, which is the default. With it off, Claude asks once per session. Without the checkouts, the reviewers fall back to `gh search code`, which is slower and less complete.
- Install and log in to `gh`.
- Settings that have worked well for large reviews. Put them in your own `~/.claude/settings.json`, not the shared file: `"model": "opus"` and `"alwaysThinkingEnabled": true`.
- The `security-guidance` plugin (`/plugin install security-guidance@claude-plugins-official`) adds security checks on edits and commits. It also runs model reviews on commit and push, so it uses extra usage.

## Changing this setup

These files are code that runs on contributors' machines (hooks) or steers Claude (everything else). Review changes to them like any other code. Keep `CLAUDE.md` short, and put file-specific guidance in `rules/` with a `paths:` filter.
