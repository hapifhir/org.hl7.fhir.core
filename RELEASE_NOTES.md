## Validator Changes

* Server Mode Fix: -autoLoadPackages loads the package that defines a canonical URL the validator doesn't have (it never did: the lookup failed with a ClassCastException, and then a NullPointerException, both swallowed)
* Terminology Change: the tx log (-txLog) records a request that got no response - a timeout, or a failed connection - with the error and how long it ran (it showed the request with nothing after it, so a request that held validation up for a minute went unnoticed)

## Other code changes

* no changes
