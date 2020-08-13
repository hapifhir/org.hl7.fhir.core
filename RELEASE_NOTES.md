Validator:
* add support for -bundle parameter to allow validating just one resource (/type) in a bundle
* improved reporting of errors and warnings for unknown code systems on required bindings
* pass dependencies to the server for imported value sets etc
* use server side caching for more efficient use of bandwidth 
* Fix NPE loading packages from simplifier or old packages (and don't lazy load packages passed to command line)

Other code changes:
* further work on comparing CapabilityStatements (nearly, but not quite, finished)
* More work on timeouts in terminology client
* Fix for parsing error in R3/R4 sparse arrays for primitives types
* Improve terminology client logging
* don't reload a package if already loaded
* rendering: fix NPEs rendering patient summary, and render expressions for quantities
