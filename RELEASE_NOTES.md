Validator:
* fix problem with min getting set to 1 on slices.
* fix problem with element definition resolution in profiles for contentReference
* don't apply warning about reference content when it's used as a pattern

Other code changes:
* fix problem with rendering unchanged terminology bindings in profiles
* fix problem rendering canonical URLs with | in them
* fix problem rendering multiple manifestations for an allergy reaction
* fix for NPE in version string comparison
* add styling when adding markdown to table