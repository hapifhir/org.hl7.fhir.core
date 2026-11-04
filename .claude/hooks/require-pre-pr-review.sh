#!/bin/sh
# PreToolUse hook (Bash): block `gh pr create` until /pre-pr-review has recorded a
# review of the current HEAD in .claude/review-state/<sha>.md.
#
# Exit 0 = allow. Exit 2 = block; stderr is shown to Claude as the reason.
# This is a workflow guard, not a security control. It only sees Claude's own Bash calls.
# To turn it off for a session, start Claude with CLAUDE_SKIP_PRE_PR_REVIEW=1 in the environment.

input=$(cat)

# The settings `if` filter is best-effort, so check the command again here.
printf '%s' "$input" | grep -q 'gh pr create' || exit 0

[ "${CLAUDE_SKIP_PRE_PR_REVIEW:-}" = "1" ] && exit 0

root=${CLAUDE_PROJECT_DIR:-$(git rev-parse --show-toplevel 2>/dev/null)}
sha=$(git -C "$root" rev-parse HEAD 2>/dev/null) || exit 0
state="$root/.claude/review-state/$sha.md"

if [ ! -f "$state" ]; then
  echo "Blocked: no pre-PR review for HEAD $sha. Run /pre-pr-review first, then retry gh pr create. Do not create $state yourself." >&2
  exit 2
fi

if grep -q '^status: clean' "$state" || grep -q '^acknowledged: true' "$state"; then
  exit 0
fi

echo "Blocked: the pre-PR review for HEAD $sha has open Med/High findings ($state). Fix them, commit, and run /pre-pr-review again, or ask the user to accept them by adding 'acknowledged: true' to that file. Do not add it yourself." >&2
exit 2
