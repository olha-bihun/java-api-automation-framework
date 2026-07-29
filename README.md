# 🚀 Java API & Microservices Test Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![REST Assured](https://img.shields.io/badge/REST%20Assured-5.3.2-green.svg)
![TestNG](https://img.shields.io/badge/TestNG-7.8.0-blue.svg)
![Allure](https://img.shields.io/badge/Allure-Report-yellow.svg)

Production-ready API Test Automation Framework designed for testing RESTful microservices, event streams, and backend workflows.

## 🏗️ Tech Stack & Key Features
* **Language:** Java 17
* **API Client:** REST Assured
* **Test Runner:** TestNG
* **Reporting:** Allure Reports
* **Data Mapping:** Jackson Databind
* **CI/CD:** GitHub Actions workflow integration

## 📂 Architecture Overview
The framework follows a modular, service-oriented architecture:
* `models/` - Strong-typed Request and Response POJOs.
* `services/` - Service wrappers defining API endpoints and business flows.
* `tests/` - Test classes containing assertions, TestNG annotations, and Allure meta-data.

## ⚙️ How to Run Tests Locally

### Prerequisites
* JDK 17+
* Maven 3.8+

### Execution Commands
Run all test suites:
```bash
mvn clean test
```

Generate and open Allure Report:
```bash
mvn allure:serve
```
