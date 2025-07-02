# Java Selenium TestNG Framework

## Overview

This is a **Selenium WebDriver** test automation framework built using **Java** and **TestNG**. It aims to streamline automated testing of web applications with a focus on **modularity**, **maintainability**, and **scalability**.

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
