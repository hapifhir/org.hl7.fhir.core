---
paths:
  - "**/txCache/**"
---

# txCache files

`src/test/resources/txCache/` (in `r5`, `standalone`, `validation` and `convertors`) holds recorded terminology server responses that tests replay. Tests rewrite these files when they run against a live server. Don't edit them by hand.

What the files are:
- `*.cache`: cached code system or value set validation responses. Check that changes come from legitimate new queries or updated server responses.
- `cs-externals.json` / `vs-externals.json`: an index of external code systems and value sets. Check entries that were added or removed.
- `system-map.json`: maps system URLs. Check new aliases and corrections.
- `servers.ini`, `version.ctl`: server metadata. They are usually safe to accept.
- `.terminologyCapabilities.*.cache`: server capability snapshots. They are safe to accept if the server URL is the expected one.

When reviewing, summarise the changes by module and FHIR version. Say whether they look like a server update or a change caused by the code. Use the `hl7-code-review` skill to mark the files as viewed on GitHub.
