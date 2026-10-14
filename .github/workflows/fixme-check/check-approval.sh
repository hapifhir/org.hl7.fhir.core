#!/bin/bash
# Prints "true" if the PR has at least one APPROVED review from someone other
# than the PR author, considering only each reviewer's most recent review
# (a later "request changes" or "comment" review revokes an earlier approval).
# Prints "false" otherwise.
set -euo pipefail

REPO="${1:?Usage: check-approval.sh <owner/repo> <pr-number> <author>}"
PR_NUMBER="${2:?Usage: check-approval.sh <owner/repo> <pr-number> <author>}"
AUTHOR="${3:?Usage: check-approval.sh <owner/repo> <pr-number> <author>}"

reviews=$(gh api "repos/${REPO}/pulls/${PR_NUMBER}/reviews" --paginate)

echo "$reviews" | jq --arg author "$AUTHOR" '
  group_by(.user.login)
  | map(max_by(.submitted_at))
  | map(select(.state == "APPROVED" and .user.login != $author))
  | length > 0
'
