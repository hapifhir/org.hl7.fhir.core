## Validator Changes

* Add format codes ```md``` and ```url``` to FHIRPath escape() and unescape()
* Add second parameter ```s_last``` to FHIRPath join() to use a different separator for the last time (e.g. ```.join(', ', 'and')```)

## Other code changes

* Parse status when parsing FML metadata
* Fix NPE in FHIRPath resolve() for contained resources ([discussion](https://chat.fhir.org/#narrow/stream/179167-hapi/topic/fix.20to.20FHIRPathEngine))