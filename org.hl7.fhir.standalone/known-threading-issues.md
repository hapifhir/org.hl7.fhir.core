# Known threading issues

Problems that have been found but deliberately not fixed yet. The current behaviour is the best for single-threaded
use, which matters most. They do matter when one worker context is shared by several threads, for example the
validator in server mode, where each request runs on its own thread.

See "Thread Safety" in readme.md for what this module, `org.hl7.fhir.services` and `org.hl7.fhir.model` are expected
to guarantee.

## 1. `ContextUtilities.allStructures()` fills its list as it goes

- **Where:** `org.hl7.fhir.services/.../context/ContextUtilities.java`, `allStructures()` and its field
  `allStructuresList`. The r5 copy, `org.hl7.fhir.r5/.../context/ContextUtilities.java`, has the same code.
- **How it's shared:** `FHIRPathEngine` stores a `FHIRPathAnalysis` in the worker context (`storeAnalysis`). Every
  FHIRPathEngine that uses that context shares it, and it includes a `ContextUtilities` (`analysis.cu`). The type
  checks call `analysis.cu.allStructures()`, which is used to find a type and its descendants.
- **The problem:** the first call fills an `ArrayList` one item at a time. It decides whether to start by checking
  `allStructuresList.isEmpty()`, and there's no locking. So when two threads make the first call at the same time:
  - a second thread can see the list as soon as the first item is added, and gets a partial list. FHIRPath type checks
    then miss types.
  - both threads can fill it, so it has duplicates, or the `ArrayList` is corrupted by two threads adding at once.
- **How to fix it:** build the list in a local variable and publish it complete. For example, use a `volatile` field
  that's assigned once the list is finished, and treat null as "not built yet". Or stop sharing the
  `ContextUtilities` through the stored analysis, and give each FHIRPathEngine its own. That costs one
  `allStructures()` build per engine.

## 2. `ContextUtilities.oidCache` is a plain `HashMap`

- **Where:** `org.hl7.fhir.services/.../context/ContextUtilities.java`, the field `oidCache` and `oid2Uri()`. The r5
  copy has the same code.
- **How it's shared:** the same way as item 1. The `ContextUtilities` stored in the shared `FHIRPathAnalysis` is used
  by every FHIRPathEngine on the context.
- **The problem:** `oid2Uri()` reads the map and adds to it on every lookup it hasn't seen before, with no locking. A
  `HashMap` written to by two threads at once can lose entries or be corrupted, and reading it while another thread
  writes can give wrong results. It also stores null for an OID that isn't known, and uses `containsKey` and then
  `get`, which is two steps that another thread can come between.
- **How to fix it:** a `ConcurrentHashMap`. Note that it can't hold null, so an unknown OID needs a marker value
  instead.
