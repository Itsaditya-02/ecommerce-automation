E-Commerce UI Automation

Automated UI checks for [SauceDemo](https://www.saucedemo.com/) using Java, Selenium WebDriver, TestNG, and Maven. The suite covers the main customer journey, from signing in and selecting products to checkout and logout.

## What the suite covers

There are **17 TestNG test cases** across the following areas:

| Area | Coverage |
| --- | --- |
| Login | Valid credentials, invalid credentials, blank username, and locked-out user |
| Products | Price verification and sorting by name or price |
| Cart | Add and remove product, badge count, displayed product and price, and continue shopping |
| Checkout | Complete an order and validate required first name, last name, and postal code |
| Logout | Sign out and verify the login screen appears |

## Technology

- Java 17
- Selenium WebDriver 4.52.0
- TestNG 7.12.0
- Maven
- Page Object Model (POM)

## Project layout

```text
ecommerce-automation/
├── pom.xml
├── testng.xml
└── src/
    ├── main/java/com/ecommerce/App.java
    └── test/
        ├── java/com/ecommerce/
        │   ├── pages/       # Login, products, cart, and checkout page objects
        │   ├── tests/       # TestNG tests and shared browser setup
        │   └── utils/       # Configuration, waits, and screenshots
        └── resources/
            └── config.properties
```

## Prerequisites

- Java 17 or newer
- Maven installed and available on `PATH`
- Google Chrome installed
- Internet access to reach SauceDemo on test runs

The test URL and standard SauceDemo credentials are configured in `src/test/resources/config.properties`. Change these values there if needed.

## Run the suite

From the project directory (the folder containing this `pom.xml`):

```powershell
mvn clean test
```

Maven uses `testng.xml` to run the configured suite. Surefire reports are written under `target/surefire-reports/`; failure screenshots are saved in `screenshots/`.

## Framework notes

- Page classes keep locators and browser actions separate from test assertions.
- `BaseTest` starts and closes Chrome for each test and captures a screenshot on test failure.
- `WaitUtil` provides explicit waits for visible and clickable elements.
