# Kotlin Starter
[![CircleCI](https://circleci.com/gh/maxkramer/kotlin-starter/tree/master.svg?style=svg)](https://circleci.com/gh/maxkramer/kotlin-starter/tree/master)
[![codecov](https://codecov.io/gh/maxkramer/kotlin-starter/branch/master/graph/badge.svg)](https://codecov.io/gh/maxkramer/kotlin-starter)

The Kotlin Starter is a very barebones project for getting started building a Kotlin backend with Spring Boot, leveraging some of the best practices I have come across while working with Kotlin over the past two years.

This project contains a very simple GET endpoint "/greet" which takes a single "name" parameter and returns a greeting with this name.

The greetings are loaded from the database via a `Repository` and the "business logic" can be found in a `Service`, following along from the well known [MVCS][1] paradigm.

Although this is completely overkill for simply saying hello to whoever is passed in, the point was to demonstrate how to test the different layers of the application.

## Aim

To provide you with a very simple and pre-configured Spring Boot project that you can clone and immediately get going with, without having to waste time configuring everything.

## Features

- Environment based configuration
- Linting ([Ktlint][2] - fix all issues with `$ ktlint -F`), Code coverage metrics
- Example CI setup with [CircleCI][3]
- Example tests
- Pre-configured embedded Postgres database for tests (no it does not slow down your tests)
- Configurable [log levels][4]
- Integration with micrometer for Statsd integration (easily replaceable with Prometheus)
- Dependency reports (lists outdated dependencies via `$ ./gradlew dependencyUpdates` i.e. [example][5]

## Getting started
### Prerequisites

- ≥ Java 11: I'd recommend [Jabba][6] for managing your Java installations.
- Running postgres database. By default, the application looks for a database named `kotlin-starter` running on `localhost:5432` with username `postgres` and password `password`. If your configuration does not match, please update the [application.yml][7].

### Running the app
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

[1]: https://daymoframework.wordpress.com/2010/07/01/the-daymo-approach-to-model-view-controller/
[2]: https://ktlint.github.io/
[3]: https://circleci.com/gh/maxkramer/kotlin-starter/tree/master
[4]: https://github.com/maxkramer/kotlin-starter/blob/master/src/main/resources/logback-spring.xml
[5]: https://62-192011124-gh.circle-artifacts.com/0/tmp/workspace/build/reports/dependencies/report.txt
[6]: https://github.com/shyiko/jabba
[7]: https://github.com/maxkramer/kotlin-starter/blob/master/src/main/resources/application.yml
