## Validator Changes

* Add check for duplicate ids on contained resources
* fix bug looking up code system
* fix bug for cross-version extension containing escaped [x]
* Look for cs on other server in missed location
* fix bug accessing code system from other terminology server if no version specified
* upgrade tx tests to make optionality dependent on mode
* upgrade tx-task in validator to handle more repackaging functionality (and fix bugs)
* Add matchetype pattern validation
* validate displaylanguage when validating codes
* policyAdvisor for CodeSystem and Valueset validation

## Other code changes

* Possible fix for an NPE reported bu a user with no context
* Use BCP 47 language tag instead of Java Locale toString
* fix bug parsing `script` tag in xhtml - handling `<` characters
