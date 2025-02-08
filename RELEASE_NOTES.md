## Announcement

This release marks the beginning of a process of refactoring the HAPI core code.
We are trimming and refactoring the core model code to reduce dependencies. As part 
pf this, we will be culling all the old unmaintained code in the older versions. In
addition, we will be moving all the terminology, rendering, view definition, and 
validation related code to a new partner package for R4, R4B, and R5. 

This change is planned for July 2025. This release starts the process of marking the
code with annotations to indicate it's proposed fate:
- @Deprecated classes will be deleted in July 2025 unless users raise issues with that 
- @MarkedToMoveToAdjunctPackage is code that will move the other package
- Code with no annotations will not move or be deleted (r2-r4 + r5) or has not yet been reviewed (R4B)

## Validator Changes

* no changes

## Other code changes

* no changes