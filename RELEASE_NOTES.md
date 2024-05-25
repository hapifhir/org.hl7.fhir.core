## Validator Changes

* Fix issue validating codes with + in them
* Fix (well, hack) R4 vital signs issue with component units

## WHO I18n Project

* QA on i18n constants - remove spurious entries, add anything missing
* Remove test case for i18n coverage
* Generate properties translation files without blank entries
* Add transifex configuration
* Fix up .po file generation so that POEdit is supported, and remove duplicate constants (#1592)
* Most strings translated to Dutch, unchecked.
* Add utility to infer locale from region code

## Other code changes

* Remove Accept-Charset header
* Fix typos around CODESYSTEM_CONTENT_COMPLETE
