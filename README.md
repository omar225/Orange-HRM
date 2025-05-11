# Orange HRM Software Testing Project

## Introduction
This repository is dedicated to testing the Orange HRM (Human Resource Management) platform. The project aims to explore and implement different software testing methodologies to ensure the system's functionality, security, and performance. As we progress, we will design test cases, automate testing processes, and document findings to enhance the overall quality of the Orange HRM platform.


## Group 1 Members  
- Abdulrhman Ahmed Ibrahim  
- Farah Mahmoud Mohamed  
- Makram Ehab Makram  
- Mirna Hatem Mohammed  
- Omar Mohamed Ahmed  
- Sondos Saeed Sophy  

## Project Scope
Our focus will be on:
- Understanding the Orange HRM system  
- Designing and executing test cases  
- Implementing automated and manual testing approaches  
- Identifying and reporting defects  

## Automation Project Structure
- **`src/test/java/tests`**: Contains all test classes.
  - `BaseTest.java`: Sets up and tears down the WebDriver for each test.
  - `DashboardTest.java`: Tests related to the Dashboard page.
  - `Admin/UserManagementTest.java`: Tests for the User Management module.
- **`src/main/java/pages`**: Page Object Model (POM) classes for different pages.
- **`pom.xml`**: Maven configuration file for managing dependencies.

## Features
- Automated login functionality.
- Navigation and verification of the Dashboard page.
- User Management tests, including:
  - Searching for users.
  - Filtering users by role and status.
  - Resetting filters.
  - Verifying the Add User button functionality.
- Integration with Allure for detailed test reporting.

## Technologies Used
- **Java**: Programming language for writing test scripts.
- **Selenium WebDriver**: For browser automation.
- **TestNG**: Test framework for organizing and running tests.
- **Allure**: For generating detailed test reports.
- **Maven**: Build and dependency management tool.

## Prerequisites
- Java 11 or higher installed.
- Maven installed.
- Chrome browser installed.
- ChromeDriver compatible with your Chrome version.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/omar225/orangehrm-automation.git
 
## Jira CSV File
[Jira Export CSV (all fields) 20250511042611.csv](https://github.com/user-attachments/files/20146492/Jira.Export.CSV.all.fields.20250511042611.csv)

## Jira CSV File
[Test_Summary_Report.pdf](https://github.com/user-attachments/files/20148140/Test_Summary_Report.pdf)
