## Validator Changes

* no changes

## Other code changes

* Packages: examples are now written to `package/examples/` (as the package spec says) instead of `package/example/`, and everything that reads examples from a package looks in both (`NpmPackage.EXAMPLE_FOLDERS`, `listExamples()`, `loadExample()`). Also fixes `PackagedResourceFile.isExample()`, which was false for examples in packages loaded from the package cache
* Performance: generated `visitChildren()` on the model classes, used by `Base.forEachChild()` / `visitDescendants()`, `getChildValues("*")`, `assertModelContext()` and `changeModelContext()` instead of walking `listChildren()`
