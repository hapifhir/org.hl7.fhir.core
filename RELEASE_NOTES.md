## Validator Changes

* Test concept map code validity
* Rework type checking on target profiles to support imposesProfile
* Fix imposesProfile extension being missed on primary profile
* Add support for IPS-AU
* Fix warning/error message about experimental property on CodeSystems and ValueSets
* Fix unknown code message to include code system version
* Add provisional SHLinks validation

## Other code changes

* Render Requirements.reference
* Convert Requirements.reference between versions
* Fix test that breaks on local machines + Fix system path for FileSystemPackageCacheManager
* Update to cqframework 2.11 and remove unused common-beanutils declaration (#1419)
* Better xhtml logging for debugging
* Fix DF markdown engine to escape < properly
* Support for sub-packages in packagelist.json
* NPE proofing property handling for Code Systems
* rework the way intermediary content is handled in the validator
* Restore CodeQL regex queries (#1422) + Whitelist BSD 3-clause license


