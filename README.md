**BDD Cucumber API Testing Framework**

Overview

This repository contains a BDD (Behavior-Driven Development) API testing framework built with Cucumber and Java. The framework is designed for automated testing of REST APIs using the Cucumber BDD approach. It is organized into five main packages:

    Common Methods
    Runner
    Repository
    Step Definition
    Features

The framework also integrates Extent Reports for detailed test reporting and includes retry functionality for test reliability.
Package Breakdown

1. Common Methods

The common package includes essential classes and methods for executing API tests:

    API Trigger Methods: Methods for sending API requests and handling responses.
    Utility Class: Contains utility functions for reading Excel data, creating log files, and other common tasks.
    Extent Listener Class: Configures Extent Reports for generating test execution reports.
    Retry Method: Implements IRetryAnalyzer to retry failed tests automatically.

2. Runner

The runner package manages the execution of the Cucumber test suite:

    Test Runner: Configures the Cucumber options and integrates with the Maven build process.

3. Repository

The repository package handles the storage and management of:

    Environmental Variables: Configuration settings and credentials for different environments.
    Request Body: Templates for API request payloads.

4. Step Definition

The Step Definition package contains step definitions and Hooks

5. Features

The features package contains Cucumber feature files written in Gherkin syntax. Each feature file describes the behavior of the API and is linked to step definitions in the test package.

Reporting

Test results are reported using Extent Reports. The reports are generated automatically and can be found in the target/extent-reports directory after running the tests.