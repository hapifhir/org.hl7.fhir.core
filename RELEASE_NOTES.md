## Validator Changes

* Fix NPEs checking compliesWith on profile discriminators (resolve() paths, CodeableReference, slices without a profile). When a discriminator value can't be determined, a warning is reported instead of failing or reporting that no slice was found
* compliesWith check: a slice with a profile discriminator now matches when its profiles are, derive from, impose or claim to comply with the profiles of the claimed slice. Before, a broader slice matched and a stricter, derived one didn't. When several slices match one claimed slice, their cardinalities are added up
* compliesWith check: target profiles are now checked. Each target profile of the claimee must be, derive from, impose or claim to comply with one of the target profiles of the claimed profile. This can report errors on profiles that passed before
* Accept compliesWithProfile when a derived profile narrows a reference target profile, as is already done for imposeProfile

## Other code changes

* no changes
