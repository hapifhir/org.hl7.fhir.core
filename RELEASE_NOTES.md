Validator:
* More rules around URL validation, instead of just marking them as errors
* Don't report errors for extensible bindings when profiles apply required bindings

Other code changes:
* fix rendering issue with profile references
* only use c:\temp for logs if it's writeable