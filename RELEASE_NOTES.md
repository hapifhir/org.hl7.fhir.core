## Validator Changes

* fix up caching for new sealed parameter
* fix version bug excluding codes and fix server side handling for excluded valuesets
* improve validation error message for retired codes
* fix tx server addresses to https:
* Fix cache-id double header issue
* rework cache shutdown
* fix htmlChecks() implementation on string in validator
* NPE fix for missing version when doing value set validation

## Other code changes

* RDF R6 move optional concept IRIs + NamingSystem param
* fix canonical extension utility
* fix issue with unescaped input to code generator
* Diff logic isn't handling nested codes (FHIR-54571, FHIR-54489)
* Fix single argument URL constructor calls
* fix broken links in comparisons
* backwards compatibility fix for IValidatorPolicyAdvisor
* Switch SimpleHTTPClient to okhttp3 (#2519)
* Update Dependencies:
  * hapi version to 8.10.0
  * ch.qos.logback:logback-core from 1.5.25 to 1.5.33
  * Jackson -> 2.22.1 + kotlin-stdlib -> 2.4.0
  * Logback -> 1.5.37
  * Saxon HE update 