## Introduction

This project aims to ensure the Registration Form accurately captures user information according to defined requirements.

## Project Structure

- The project is designed based on the Page Object Model (POM) design pattern.
- It is implemented with
    ```
      - Maven build automation tool
      - Selenium WebDriver
      - TestNG
      - Cucumber BDD framework
      - Gherkin syntax
      - Allure reports
     ```
- For managing WebDrivers the Selenium Manager library is used
  - No manual `ChromeDriver` or `geckodriver` downloaded
  - No `bonigarcia/webdrivermanager` used. Because with the new version of Selenium, the `Selenium Manager` is a built in solution and `Boni Garcia` himself is also in that team. 
- `Data-driven testing (DDT)` is applied with the Scenario Outline annotation of Cucumber Framework
- `Behavior-driven development` is applied
- Source code does not contain any test data. I reach it via *.feature files in resources package
- StepDefinitions does not contain page object. There is a separate package to store the page objects. `pageObjects` 
  Assertions are in step definition classes with test data coming from the features
- `config.properties` file is introduced to keep the source code independent. 
  - For now only the browser type can be updated there. Chrome, Firefox and Edge browsers are supported.
  - In case of need, the username, password, etc. can be put there. 
  - When `CI/CD integration` is needed, then these credentials can be put in `Jenkins` or `Bamboo` credentials and pulled from there without exposing.
- `DRY (Don't repeat yourself) principle` is applied. All test cases are handled under one test scenario outline, to keep the code clean, readable and as less as possible. See here `features/Form.feature`
- Implemented the reusable functions to improve maintainability
- Validated that the test will actually fail - `negative testing`
- Applied `Single Responsibility Principle`
- Unique and simple locators are used to locate the elements
- Consistent and reliable tests are written to avoid Flaky Tests. No static wait is used. Instead, explicit wait is used.
- `Screenshot` is attached in the `Allure report` for the failing scenario 

### Class naming conventions

The following examples are working on `Foo` instances:
- `*Step` for step definitons (e.g. `FooStep`)
- `*Page` for page objects (e.g. `FooPage`)
- `*Helper`, `*Utils`, or plural form
  (e.g. `FooHelper`, `FooUtils`, `Foos`)

### Pre-requisites

- Java Development Kit (JDK) installed on your machine
- Maven build tool installed
- IDE is installed (IntelliJ IDEA, Eclipse, VSCode)


## Project Usage

1. Clone this repository
    ```
    $ git clone https://github.com/kameronessi/RegistrationForm
    ```
2. Run the application with the `mvn clean test` command.
3. Generate Allure Reports after the execution with `mvn allure:serve`


## `.feature` file structure

- The form contains all the fields and their values
- In each scenario only the field under `fieldID` column is changing
- The other values are proper values and do not change. 
- Other values are there because if one is missing, then that field will throw a pop-up message


## Important Note:

- I implemented 13 test scenarios
- 12 of them are passing
- 1 of them is failing, which actually meets the requirements, but still fails.
  - it is Password field and `P@ss` value, test case ID `TC21`
  - So I included it in the Test Execution Report. The screenshot can be seen in Allure Plugin report

## Author

Kamran Ibiyev - Sr QA Automation Engineer
kamran.ibiyev@gmail.com
