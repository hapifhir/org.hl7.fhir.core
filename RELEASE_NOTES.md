## Validator Changes

* no changes

## Other code changes

* Performance: generated `visitChildren()` on the model classes, used by `Base.forEachChild()` / `visitDescendants()`, `getChildValues("*")`, `assertModelContext()` and `changeModelContext()` instead of walking `listChildren()`
