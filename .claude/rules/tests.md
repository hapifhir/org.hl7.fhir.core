---
paths:
  - "**/src/test/**"
---

# Test code

Writing tests:
- Use JUnit 5. Use `@Disabled`, not `@Ignore`. Don't make test classes or methods `public` unless they have to be.
- Many test classes take their cases from a `parameters()` method. `@ParameterizedTest` is often inherited from a base class, so a `parameters()` method without the annotation isn't necessarily a mistake.
- Run `mvn test -pl <module> -Dtest=<TestClass>` after changing a test, and report the result.

Reviewing tests:
- Don't suggest defensive programming such as null checks, empty-collection checks or `list.get(0)` guards. An exception in a test is a valid test failure.
- Focus on whether the test checks the intended behaviour. Flag assertions that can't fail, such as `assertTrue(a || b)` when either side is always true, or assertions on the wrong object.
- Flag tests that were disabled or added to a skip list without a reason, and new behaviour that has no test.
- Fixtures under `src/test/resources` should match the code change in the same PR. A changed expected output that isn't explained by the change may hide a regression.
