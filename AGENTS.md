# AGENTS.md

## Code Quality

Before committing, please ensure the following:

## Code Style

- All problem solutions must implemented as Top Level Function.
- You must not change the the commiting code logic naming included, you can reformat code based on the Detekt check.

### Testing and Linting

Run the following commands:

```bash
./gradlew test
./gradlew detekt
```

Verify that all tests pass and there are no Detekt violations.

---

## Commit Messages

Commit messages should follow the conventional commit format: `type(scope): summary`.

Here are some examples:

* `feat(leetcode): add new solution`
* `chore(build): update dependencies`
* `docs: update instructions`
