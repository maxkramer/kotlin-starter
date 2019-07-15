# Kotlin Starter
[![CircleCI](https://circleci.com/gh/maxkramer/kotlin-starter/tree/master.svg?style=svg)](https://circleci.com/gh/maxkramer/kotlin-starter/tree/master)

The Kotlin Starter is a very barebones project for getting started building a Kotlin backend with Spring Boot, leveraging some of the best practices I have come across while working with Kotlin over the past two years.

This project contains a very simple GET endpoint "/greet" which takes a single "name" parameter and returns a greeting with this name.

The greetings are loaded from the database via a `Repository` and the "business logic" can be found in a `Service`, following along from the well known MVCS paradigm.

Although this is completely overkill for simply saying hello to whoever is passed in, the point was to demonstrate how to test the different layers of the application.

## Aim

To provide you with a very simple and pre-configured Spring Boot project that you can clone and immediately get going with, without having to waste time configuring everything.

## Features

- Environment based configuration
- Linting (Ktlint - fix all issues with `$ ktlint -F`), Code coverage metrics
- Example CI setup (CircleCI)
- Example tests
- Pre-configured embedded Postgres database for tests (no it does not slow down your tests)
- Configurable log levels
- Integration with micrometer for Statsd integration (easily replaceable with Prometheus)
- Dependency reports (lists outdated dependencies via `$ ./gradlew dependencyUpdates`

## Getting started

### Prerequisites

- >= Java 11: I'd recommend [Jabba][1] for managing your Java installations.
- Running postgres database. By default, the application looks for a database named `kotlin-starter` running on `localhost:5432` with username `postgres` and password `password`. If your configuration does not match, please update the [application.yml][2].

Clone the repository:
```$ git clone git@github.com:maxkramer/kotlin-starter.git```

Change directory into the kotlin-starter and run the application.

```
$ cd kotlin-starter
$ ./gradlew bootRun

```

To run the tests:

```
$ ./gradlew test
```

## FAQ (WIP)

- Why two environments?
- How to configure statsd?
- CI?


[1]: https://github.com/shyiko/jabba
[2]: https://github.com/maxkramer/kotlin-starter/blob/master/src/main/resources/application.yml



