## Validator Changes

* Reworked terminology caching and re-enabled client caching in the validator
* Hardened resource processing against malicious input
  * Bounded excessive decompressed sizes
  * Stack overflow prevention
  * Escape script tags during scanning + escape HTML output properly
  * Handle empty SHC content
* Fixed handling of secondary displays in the wrong language
* Fixed version comparison in the worker context

## Other code changes

* Cross-version RDF/Turtle support (TurtleParserR4 redirect, JSON to Turtle)
* Fixed Turtle-as-HTML formatting
* Fixed NPEs in the diagnostic report renderer
* Fixed a whitespace issue parsing XML
* Unload xhtml in loaded resources to reduce memory load
* Updated sqlite-jdbc to 3.53.2.0
* Fix SpotBugs annotations dependencies for downstream projects
