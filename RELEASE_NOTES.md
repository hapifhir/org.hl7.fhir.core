# Validator changes

* fix FHIRPath error evaluating $this in repeat()
* fix json parser NPE for some incomplete arrays
* Validate using new contentReferenceProfile extension
* disallow extensions on resource.id
* fix issue with multiple languages in internal terminology server
* Applied https://jira.hl7.org/browse/FHIR-56312, which allows htmlChecks to be invoked on 'string' as well as xhtml.  Also fixed issue where htmlChecks was returning 'false' rather than 'empty' when invoked on invalid types.  (Spec says it returns empty.)
* Fix issue with old HTML not being processed properly
* refactor PO pipeline to allow loading a .po file at runtime (-po file)
* Fix version loading issue with cross version extensions

# Other changes

* Fix timeout logic in RegexTimeout (#2447)
* Suppress checkstyle systemout error on main(...) class
* Clean up unchanged file imports
* Fix typo in getLoadedPackages
* cleanup some warnings
* Fix method signatures + cleanup
* add start of support for structural constraints
* move CompliesWIthChecker for advisor support
* Updates jackson version and reorganizes properties file
