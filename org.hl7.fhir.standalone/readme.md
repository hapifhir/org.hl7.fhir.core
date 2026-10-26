## Warning

This code is experimental, and subject to further changes as 
R6 itself is developed, and as we start to test and work with
this code. 

## Thread Safety

This module is not thread safe, and is not meant to be. The worker context, the canonical
resource manager and the terminology services here assume a single thread: they load
resources lazily and derive state from them on first use. Don't add synchronization to
code in this module. (`org.hl7.fhir.model` and `org.hl7.fhir.services`, on the other hand,
are expected to be thread safe.) See "Thread Safety" in the top level README.md.
