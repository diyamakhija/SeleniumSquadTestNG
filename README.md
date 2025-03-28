# SeleniumSquadTestNG

This is a basic TestNG-based automation framework for testing the [dsportalapp.herokuapp.com](https://dsportalapp.herokuapp.com/) application.

## 🔧 Tech Stack
- Java 1.8
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager
- Log4j2
- Apache POI
- ExtentReports / Allure for Reporting

## 🚀 How to Run
1. Clone the repo
2. Run `mvn clean test` to execute tests
3. Use `mvn allure:report` to generate Allure report

## 📁 Project Structure
- `base/`: Base test class
- `tests/`: Test classes
- `utils/`: Utility classes (DriverManager, ExcelUtils, etc.)
- `pages/`: Page Object Models
