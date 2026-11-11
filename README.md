# Selenium Automation Framework

A Java-based Selenium WebDriver automation framework built using TestNG, Maven, and Page Object Model (POM). The framework supports end-to-end web application testing, reusable automation components, Allure reporting, automated report distribution through Email and Google Chat, and CI execution using GitHub Actions.

## Key Features

- **Page Object Model (POM):** Separates page-specific elements and actions from test logic for better maintainability and reusability.
- **Selenium WebDriver:** Automates browser interactions and end-to-end application workflows.
- **TestNG:** Organizes and executes test cases using structured test suites and custom listeners.
- **Dynamic Test Data:** Uses JavaFaker to generate test data.
- **WebDriver Management:** Uses WebDriverManager to manage browser driver binaries.
- **Allure Reporting:** Integrates Allure with TestNG for detailed test execution reporting.
- **Email Notifications:** Automatically sends execution summaries, Allure results ZIP files, and available screenshots.
- **Google Chat Integration:** Sends test execution summaries, suite details, and report links through Google Chat webhooks.
- **GitHub Actions:** Supports manually triggered CI execution with automated result extraction and notifications.
- **Maven:** Manages project dependencies and test execution.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver 4.29.0 | Browser automation |
| TestNG 7.10.2 | Test execution and management |
| Maven | Build and dependency management |
| Page Object Model | Framework design pattern |
| JavaFaker 1.0.2 | Dynamic test data generation |
| WebDriverManager 5.9.2 | Browser driver management |
| Allure TestNG 2.23.0 | Test reporting |
| JavaMail | Email integration |
| Google Chat Webhook | Chat notifications |
| GitHub Actions | CI execution |
| SLF4J | Logging |

## Project Structure

```text
selenium-automation-framework/
│
├── .github/
│   └── workflows/
│       └── test-execution.yml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       ├── listeners/
│   │       ├── pages/
│   │       └── utils/
│   │
│   └── test/
│       ├── java/
│       │   └── tests/
│       └── resources/
│           └── testng.xml
│
├── pom.xml
├── .gitignore
└── README.md
```

*Note: The structure above represents the main framework organization. Generated reports, build output, and local configuration files are excluded from version control.*

## Test Execution

The framework uses a TestNG XML suite to organize end-to-end test workflows.

The suite covers the following scenarios:

1. Login and add a new employee.
2. Re-login and apply for leave.
3. Re-login as Admin and approve or reject leave.
4. Re-login as Employee and verify leave status.
5. Re-login as Admin and delete the created employee.

The suite is configured for sequential execution rather than parallel execution.

### Prerequisites

- Java JDK 17 or a compatible configured JDK.
- Apache Maven.
- Google Chrome browser.
- Git.

### Clone the Repository

```bash
git clone https://github.com/Charan-Abhinav-Pyd/selenium-automation-framework.git
```

Navigate to the project directory:

```bash
cd selenium-automation-framework
```

### Install Dependencies

```bash
mvn clean install
```

### Execute Tests

```bash
mvn clean test
```

The Maven build executes the configured TestNG tests.

## Allure Reporting

The framework integrates Allure with TestNG to capture and present test execution results.

Generate the Allure report:

```bash
mvn allure:report
```

The framework also creates a ZIP archive of the Allure results during its email-reporting workflow.

## Email Report Integration

The framework uses JavaMail and Gmail SMTP to distribute test execution reports.

The email notification includes:

- Test suite execution summary.
- Passed, failed, skipped, and total test counts.
- Allure results ZIP attachment.
- Available execution screenshots.

Email credentials are read through the framework's configuration utility rather than being embedded as passwords in the email implementation.

## Google Chat Integration

The framework integrates with Google Chat using an incoming webhook.

The notification provides:

- Test suite name.
- Triggered-by information.
- Passed, failed, skipped, and total test counts.
- Allure report link.

This integration helps share execution outcomes with the team without manually distributing test results.

## GitHub Actions – CI Execution

The project includes a GitHub Actions workflow for manually triggered test execution.

### Workflow Capabilities

- Manual execution using `workflow_dispatch`.
- Ubuntu-based execution environment.
- JDK 17 setup.
- Chrome and ChromeDriver installation.
- Maven dependency caching.
- Automated TestNG execution.
- Extraction of passed, failed, skipped, and total test counts.
- Allure report generation step and artifact upload.
- Email execution summary notification.
- Google Chat execution summary notification.

### Required GitHub Secrets

Configure the following secrets in the repository's GitHub Actions settings:

| Secret | Purpose |
|---|---|
| `EMAIL_USERNAME` | Email sender configuration |
| `RECIPIENT_EMAIL` | Notification recipient |
| `GOOGLE_CHAT_WEBHOOK` | Google Chat incoming webhook |

Never commit passwords, webhook URLs, access tokens, or other sensitive configuration values to the repository.

## Configuration and Security

The framework supports externalized configuration for credentials and test account details.

Configure the required values locally or through the appropriate environment variables. Keep local properties files containing credentials out of Git version control.

Recommended environment variables:

- `MAIL_PASSWORD`
- `CHAT_WEBHOOK_URL`
- `TEST_USERNAME`
- `TEST_PASSWORD`

For CI execution, configure the corresponding GitHub Actions secrets.

## Repository

**GitHub:** https://github.com/Charan-Abhinav-Pyd/selenium-automation-framework

