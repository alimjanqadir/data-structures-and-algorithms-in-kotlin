# AGENTS.md

## Code Quality

Before committing, please ensure the following:

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
