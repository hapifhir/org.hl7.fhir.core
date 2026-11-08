## Validator Changes

* Fix NPEs checking compliesWith on profile discriminators (resolve() paths, CodeableReference, slices without a profile). When a discriminator value can't be determined, a warning is reported instead of failing or reporting that no slice was found
* compliesWith check: a slice with a profile discriminator now matches when its profiles are, derive from, impose or claim to comply with the profiles of the claimed slice. Before, a broader slice matched and a stricter, derived one didn't. When several slices match one claimed slice, their cardinalities are added up

## Other code changes

* no changes
