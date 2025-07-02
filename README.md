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
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
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
mvn test
```

### From your IDE:
- Right-click the test class or `testng.xml`
- Run as TestNG Test

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

For the UI tests, I focused on the key actions that a typical user would perform on the Sauce Demo app — like logging in, adding items to the cart, checking out, and logging out. These are the features that matter most to users and have the biggest impact on the overall experience.

I prioritized these tests to make sure the most important parts of the app are working smoothly. To keep my code clean and easy to maintain, I used the Page Object Model (POM) pattern. This helps me organize the UI elements and interactions in one place, so if the app’s UI changes, updating the tests is much simpler.

I also set up dependencies between tests. For example, you can’t add something to your cart unless you’re logged in, so the “add to cart” test runs only after a successful login. Plus, I run tests across different browsers like Chrome, Firefox, and Edge to catch any browser-specific issues early.

### API Test Selection and Design

On the API side, I focused on the core actions you’d typically perform with the Petstore API — creating pets, retrieving pet details, updating info, and deleting records. These cover the basic “CRUD” operations that form the backbone of most APIs.

To make my tests reliable and repeatable, I generate pet IDs dynamically. This means tests don’t clash with each other or depend on hardcoded data, making them more robust and easier to run in any order.

I also check not just that the API responds, but that it responds correctly — with the right data and the expected structure. I even test for error cases, like what happens if you try to get a pet that doesn’t exist, to make sure the API handles mistakes gracefully.

### Using TestNG to Organize Tests

I use TestNG features to keep everything running smoothly:

- I assign priorities so the most important tests run first.
- I set dependencies so tests run in the right order (like making sure login happens before checkout).
- I run safe tests in parallel to speed things up.
- I group tests logically (UI vs API) so you can run just the tests you need.

### Summary

All in all, this setup focuses on testing what matters most — making sure the user’s main journey works well and the backend API behaves as expected. Using good coding practices and smart test management helps keep the tests stable, easy to maintain, and quick to run. This makes it a great foundation for continuous testing in real-world projects.

