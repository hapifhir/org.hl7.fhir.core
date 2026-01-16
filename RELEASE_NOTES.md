## Validator Changes

* The command line interface has been rewritten. This is a backward compatible change detailed [here](https://github.com/hapifhir/org.hl7.fhir.core/pull/2254) for changes

## Other code changes

* minor changes for rewriting tx.fhir.org
* Fix XHTMLToMarkdownConverter - it was removing spaces around bolded and similar elements.  (See updated test cases)
* Added a removeLanguageTranslation method to ExtensionUtilities
* Added constants, messages, and rendering phrases (with translations) to support enhanced rendering of requirements statements
  make json parsing more robust
* Fixes for concurrent access of package cache in Windows environments
