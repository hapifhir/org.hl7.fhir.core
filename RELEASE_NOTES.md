## Validator Changes

* Improve performance of supplement processing
* Add support for validating xml:space
* Fix NPE validating maps
* Fix duplicate removal code that caused missed WARNING messages (#1698)
* Fix interaction between terminology cache and validation location  (#1700)
* Better concept map validation
* Improved base64 parsing error
* Add support for unknown code system version validating concept maps
* Fix bug using wrong profile when profiling recursive properties

## Other code changes

* Return null for all toCode enum params that are null
* fix bugs adding publishing WG in element mode
* Fix equality method that caused missed WARNING messages
* fix rendering issues
  * rendering fixes for R6 build
  * don't throw error for wrong rendering mode
  * Document rendering fixes - subject and section
  * more work on forcing valid html generation
  * more hyperlink validation improvements
  * further fixes to link validation
  * fix list inside paragraph
  * fix actor capabilities in wrong place
  * Support missing datatypes
  * Fill out missing anchors
  * Fix wrong handling of contained resources)
  * #1678 - add div to children when exploring Narrative

