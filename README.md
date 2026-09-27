# E-Commerce Website Automation Testing Framework

A Selenium-based automation testing framework built using Java, Selenium WebDriver, TestNG, and Maven to automate and validate key workflows of an e-commerce website.

## 📌 Project Overview

This project automates the testing of the [SauceDemo](https://www.saucedemo.com/) e-commerce website.

The framework validates important user workflows including:

- User Login
- Invalid Login Validation
- Product Verification
- Add Product to Cart
- Remove Product from Cart
- Checkout
- Order Confirmation
- User Logout

## 🛠️ Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Git & GitHub**
- **Page Object Model (POM)**

## 🏗️ Framework Architecture

The project follows the **Page Object Model (POM)** design pattern to separate page-specific actions and locators from test cases.

```text
ecommerce-automation
│
├── pom.xml
├── testng.xml
├── .gitignore
├── README.md
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── ecommerce
    │               └── App.java
    │
    └── test
        ├── java
        │   └── com
        │       └── ecommerce
        │           ├── pages
        │           │   ├── LoginPage.java
        │           │   ├── ProductsPage.java
        │           │   ├── CartPage.java
        │           │   └── CheckoutPage.java
        │           │
        │           ├── tests
        │           │   ├── BaseTest.java
        │           │   ├── LoginTest.java
        │           │   ├── ProductTest.java
        │           │   ├── CartTest.java
        │           │   ├── RemoveCartTest.java
        │           │   ├── CheckoutTest.java
        │           │   └── LogoutTest.java
        │           │
        │           └── utils
        │               ├── ConfigReader.java
        │               ├── WaitUtil.java
        │               └── ScreenshotUtil.java
        │
        └── resources
            └── config.properties
