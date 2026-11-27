# Claude Code setup for org.hl7.fhir.core

This directory holds shared [Claude Code](https://code.claude.com/docs) configuration. It's picked up automatically when you run `claude` in this repo; there's nothing to copy into `~/.claude/`. The first time, Claude Code asks you to trust the folder. The hook below applies only after you accept. After that, it runs automatically before every Bash command Claude runs, without a permission prompt, including after you pull changes to it. You can see registered hooks with `/hooks`, and turn all hooks off by adding `"disableAllHooks": true` to your `.claude/settings.local.json`.

## What's here

| Path | What it does | How to use it |
|---|---|---|
| `../CLAUDE.md` | Loaded into every session: the module map, per-version copies, generated code, downstream consumers, build commands. | Automatic. |
| `rules/*.md` | Extra guidance that loads only when Claude reads or edits matching files: tests, txCache, per-version copies, generated code. | Automatic. |
| `agents/fhir-core-reviewer.md` | A read-only review subagent with the team's review rules and an HL7-specific checklist. It runs on Opus at high effort, because review quality is the point; expect it to use more of your usage than a normal turn. | Used by the review skills. You can also ask Claude to "use the fhir-core-reviewer agent on <files>". |
| `skills/pre-pr-review/` | Reviews your branch against `origin/master` in fresh-context subagents, verifies the findings, and records the result for the hook. | `/pre-pr-review`, or `/pre-pr-review spotbugs` to add a SpotBugs diff (about 30–40 min). |
| `skills/hl7-large-code-review/` | Full review of someone else's large PR: SpotBugs diff, a 3-way parallel review, verification, and three report files. | `/hl7-large-code-review <PR#> <branch> [output-dir]`, or ask "review PR <n>" and accept the offer. |
| `skills/hl7-code-review/` | Entry point when you ask Claude to review a PR. It offers `/hl7-large-code-review`, and summarises txCache and test-resource changes (and can mark them as viewed on GitHub). | Ask "review PR <n>" or "review the txCache changes in PR <n>". |
| `skills/spotbugs-diff/` | Runs SpotBugs on two commits in temporary worktrees and lists the new issues, using `scripts/spotbugs_diff.py`. | `/spotbugs-diff [<base> <head>]`. |
| `skills/regex/` | ReDoS and correctness checks for regexes (OWASP/OpenSSF guidance, `npx safe-regex2`). | Loads when a regex is involved. Needs Node/npx for `safe-regex2`. |
| `hooks/require-pre-pr-review.sh` | Blocks Claude's `gh pr create` until `/pre-pr-review` has a clean (or user-acknowledged) result for the current HEAD. | Automatic. See below. |
| `settings.json` | Registers the hook. It grants no permissions, so Claude asks before running commands unless you allow them yourself. | Automatic. Put personal settings in `settings.local.json` (gitignored). See "Optional: pre-approve review commands" below. |

## Before opening a PR

1. Commit your work.
2. Run `/pre-pr-review`. It writes `.claude/review-state/<HEAD-sha>.md` (gitignored) with `status: clean` or `status: findings`.
3. Fix the findings and commit. That changes HEAD, so run `/pre-pr-review` again. If you decide to accept the remaining findings, add a line `acknowledged: true` to the review-state file yourself.
4. Now `gh pr create` from Claude goes through.

The hook only checks commands Claude runs. `gh pr create` in your own terminal isn't affected. To turn the hook off for a session, start Claude with `CLAUDE_SKIP_PRE_PR_REVIEW=1 claude`.

## Recommended local setup (optional)

- Check out `kindling`, `fhir-ig-publisher` and `fhir-test-cases` anywhere you like. The reviewers grep kindling and fhir-ig-publisher before calling code unused or a public API change safe. The first time a task needs one, Claude looks for it in the folders next to this repo, by git remote rather than folder name. If it isn't there, Claude asks for the path or offers to clone it. With auto-memory on (the default), Claude remembers the answer in your own `~/.claude/projects/...`, not in this repo. With it off, Claude finds siblings next to this repo in every session without asking, but asks again each session for any that are elsewhere. See "Sibling repositories" in `../CLAUDE.md`. Without the checkouts, the reviewers fall back to `gh search code`, which is slower and less complete.
- Install and log in to `gh`.
- Settings that have worked well for large reviews. Put them in your own `~/.claude/settings.json`, not the shared file: `"model": "opus"` and `"alwaysThinkingEnabled": true`.
- The `security-guidance` plugin (`/plugin install security-guidance@claude-plugins-official`) adds security checks on edits and commits. It also runs model reviews on commit and push, so it uses extra usage.

## Optional: pre-approve review commands

The shared `settings.json` deliberately grants no permissions, so nobody gets elevated permissions just by opening the repo. The review skills run many `git` and `gh` commands, and you'll be asked to approve each one. To skip those prompts, add the rules below to your own `.claude/settings.local.json` (gitignored). If that file already has a `permissions.allow` list, merge them into it.

```json
{
  "permissions": {
    "allow": [
      "Bash(git diff:*)",
      "Bash(git log:*)",
      "Bash(git status:*)",
      "Bash(git show:*)",
      "Bash(git merge-base:*)",
      "Bash(git rev-parse:*)",
      "Bash(git fetch:*)",
      "Bash(git worktree add --detach:*)",
      "Bash(gh pr view:*)",
      "Bash(gh pr diff:*)",
      "Bash(gh search code:*)"
    ]
  }
}
```

Most of these are read-only. The exceptions are `git fetch`, which updates your remote-tracking refs, and `git worktree add --detach`, which creates a worktree on disk for `/spotbugs-diff`. The `gh` rules call the GitHub API with your credentials. Leave out any rule you'd rather approve each time.

## Changing this setup

These files are code that runs on contributors' machines (hooks) or steers Claude (everything else). Review changes to them like any other code. Keep `CLAUDE.md` short, and put file-specific guidance in `rules/` with a `paths:` filter.
