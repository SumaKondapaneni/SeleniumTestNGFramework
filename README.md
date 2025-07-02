# Java Selenium TestNG Framework

## Overview

This automation framework provides comprehensive testing capabilities for both UI and API layers of a sample application.

- **UI Testing:** Utilizes Selenium WebDriver to automate functional tests on the [Sauce Demo](https://www.saucedemo.com/) web application. The framework follows the Page Object Model design pattern to ensure clean, maintainable code and supports cross-browser testing with Chrome, Firefox, and Edge.

- **API Testing:** Employs Rest Assured to validate endpoints of the [Swagger Petstore API](https://petstore.swagger.io/), allowing dynamic testing of common CRUD operations on pet data.

- Test execution is managed using **TestNG**, supporting prioritized, dependent, and parallel tests.
- Reporting and logging are enhanced via TestNG’s native reports and optional **Allure** integration for rich, visual test results.
- The framework is fully configurable through property and TestNg.xml files, and uses **Maven** for build and dependency management.
- WebDriver binaries are automatically managed using **WebDriverManager** for ease of setup.

This setup is ideal for quickly validating functional flows with flexibility for expansion and integration into CI/CD pipelines.

---

## 🚀 Features

- **Selenium WebDriver** for browser automation  
- **TestNG** for test orchestration and reporting  
- **Page Object Model (POM)** for code reusability and readability  
- **Cross-browser support**: Chrome, Firefox, Edge  
- **Logging and reporting** using TestNG and optionally **Allure Reports**  
- **Configurable** via `config.properties` or `testng.xml`  
- **Parallel execution** with TestNG  
- **Build tool integration** with Maven  
- **Driver management** via  **WebDriverManager**

---

## 🔧 Prerequisites

- **Java JDK 21**
- **Maven** 
- IDE like **IntelliJ IDEA** or **Eclipse**
- Browsers: Chrome, Firefox, Edge


---

## 📦 Getting Started

### 1. Clone the repository

```bash

git clone https://github.com/SumaKondapaneni/SeleniumTestNGFramework.git

Then, navigate into the project folder:

cd SeleniumTestNGFramework
```

### 2. Install dependencies

**Using Maven:**

```bash
mvn clean install
```

### 3. Configure browser drivers

 Use **WebDriverManager**.

### 4. Set up environment configuration

Edit the `config.properties` or `testng.xml` file to update:
- Base URLs
- Browser type

---

## ▶️ Running Tests

### Using Maven:

```bash

mvn clean test

```

### From your IDE:
- Right-click the test class or `testng.xml`
- Run as TestNG Test


### Generate and serve the Allure report:
```bash
mvn allure:serve

This command will generate the Allure report from the test results and automatically open it in your default browser.

If you want to just generate the report without opening the browser, use:

mvn allure:report
```


---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.example.framework/
│   │       ├── base/           # WebDriver setup and teardown
│   │       ├── pages/          # Page Object classes for UI tests
│   │       ├── model/          # POJO classes for API tests
│   │       └── utils/          # Utility classes (e.g., config reader)
│   └── resources/
│       └── config.properties   # Configuration properties file
├── test/
│   ├── java/
│   │   ├── apitests/           # TestNG classes for API tests
│   │   └── webtests/           # TestNG classes for UI tests
│   └── resources/
│       ├── createPet.json      # Sample JSON payload for creating a pet
│       └── testng.xml          # TestNG suite configuration
pom.xml                          # Maven build configuration
```

---

## 🧪 Usage Tips

- Create page objects for each screen under `pages/`.
- Write test classes using TestNG annotations:
  - `@BeforeMethod`, `@AfterMethod`, `@Test`, etc.
- can use `@DataProvider` or external files for test data.
- Keep all config and test data outside code for reusability.
- Use loggers and reporting hooks for maintainability.

---

## 📊 Reporting

- **TestNG** generates:
 	 - HTML and XML reports under `test-output/`
- **Allure Reports** (optional, for rich UI and insights):
  - Add Allure dependencies
  - Run:
    ```bash
    allure serve target/allure-results
    ```

---

## 📚 Dependencies and Versions

| Dependency           | Version      |
|----------------------|--------------|
| Selenium WebDriver   | 4.33.0       |
| TestNG               | 7.11.0       |
| Allure TestNG        | 2.25.0       |
| RestAssured          | 5.4.0        |
| JsonPath             | 5.4.0        |
| WebDriverManager     | 5.7.1        |


See `pom.xml` for the complete list.

## Test Design Explanation



### UI Test Selection and Design

For the UI tests, I focused on the core user workflows within the Sauce Demo application — such as logging in, adding items to the cart, proceeding to checkout, and logging out. These represent the most critical features from a user’s perspective and significantly impact the overall user experience.

To ensure robustness, I prioritized these tests so that the most essential functionalities are verified first. The test design follows the Page Object Model (POM) pattern, which promotes clean, modular, and maintainable code by encapsulating UI elements and interactions in dedicated classes. This approach simplifies updates whenever the UI changes.

Additionally, I implemented test dependencies to reflect real-world usage flows. For example, the test that adds items to the cart depends on a successful login test, preventing false failures caused by unmet preconditions. Finally, cross-browser testing is incorporated with Chrome, Firefox, and Edge to identify and address browser-specific issues early in the development cycle.

### API Test Selection and Design

The API testing strategy focuses on validating the core CRUD operations of the Petstore API, specifically the creation, retrieval, update, and deletion of pet records. These operations constitute the fundamental interactions necessary to verify the API’s correctness and reliability.

To promote test independence and ensure repeatability, pet IDs are generated dynamically during test execution. This methodology mitigates the risk of data collisions and eliminates reliance on hardcoded values, thereby enabling tests to be executed in any order and supporting parallel test runs.

Validation extends beyond verifying HTTP response status codes to include thorough assertions on response payloads, ensuring the returned data conforms to the expected schema and values. Furthermore, negative test cases, such as attempting to retrieve a non-existent pet, are incorporated to assess the API’s error handling and resilience under invalid or edge-case scenarios.

### Using TestNG to Organize Tests

I use TestNG features to keep everything running smoothly:

- I assign priorities so the most important tests run first.
- I set dependencies so tests run in the right order (like making sure login happens before checkout).
- I run safe tests in parallel to speed things up.
- I group tests logically (UI vs API) so you can run just the tests you need.

### Summary

All in all, this setup focuses on testing what matters most — making sure the user’s main journey works well and the backend API behaves as expected. Using good coding practices and smart test management helps keep the tests stable, easy to maintain, and quick to run. This makes it a great foundation for continuous testing in real-world projects.

