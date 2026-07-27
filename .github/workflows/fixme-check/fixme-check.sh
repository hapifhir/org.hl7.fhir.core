#!/bin/bash
# Fails if the PR diff introduces new lines containing FIXME in *.java files.
# Only lines *added* by the PR are checked, so pre-existing FIXME comments
# that the PR doesn't touch are left alone.
set -euo pipefail

BASE_SHA="${1:?Usage: fixme-check.sh <base-sha> <head-sha>}"
HEAD_SHA="${2:?Usage: fixme-check.sh <base-sha> <head-sha>}"

exitStatus=0
currentFile=""
newLineNumber=0

while IFS= read -r line; do
  if [[ $line == "+++ "* ]]; then
    currentFile="${line#+++ b/}"
    continue
  fi
  if [[ $line == "--- "* ]]; then
    continue
  fi
  if [[ $line =~ ^@@\ -[0-9]+(,[0-9]+)?\ \+([0-9]+)(,[0-9]+)?\ @@ ]]; then
    newLineNumber="${BASH_REMATCH[2]}"
    continue
  fi
  if [[ $line == "+"* ]]; then
    content="${line#+}"
    if grep -qE '(^|[^A-Za-z0-9_])FIXME([^A-Za-z0-9_]|$)' <<< "$content"; then
      echo "::error file=${currentFile},line=${newLineNumber}::New FIXME comment introduced: ${content}"
      exitStatus=1
    fi
    newLineNumber=$((newLineNumber + 1))
  fi
  # Removed lines and other diff metadata don't advance the new-file line counter.
done < <(git diff --diff-filter=ACMR -U0 "$BASE_SHA" "$HEAD_SHA" -- '*.java')

echo "Check complete."

if (( exitStatus != 0 )); then
  echo "New FIXME comments were introduced in this PR. Existing FIXMEs may remain until addressed, but new/changed code must not add new ones."
else
  echo "No new FIXME comments found."
fi

exit $exitStatus
