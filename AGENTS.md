# AGENTS.md

## Code Quality

Before committing, please ensure the following:

### Code Style

- All problem solutions must implemented as Top Level Function.
- You must not change the the commiting code logic naming included, you can reformat code based on the Detekt check.

### Testing and Linting

Run the following commands:

```bash
./gradlew test
./gradlew detekt
```

Verify that all tests pass and there are no Detekt violations.

### Code Organization
- You can't create new packages.
- Problem solutions must be inside the `problems` package. 
- General Data Strcutures the problems use should put inside the `datastructure` package.
- General Algorithm demonstration must be inside the `algorithms` package.
- Test code must be inside the `test` module, no test code is allowed to be inside the `main` module. 

### Commit Messages

Commit messages should follow the conventional commit format: `type(scope): summary`.

Here are some examples:

* `feat(leetcode): add new solution`
* `chore(build): update dependencies`
* `docs: update instructions`
