# Test Task

### Prerequisities
- Java 8+
- Maven 
- Allure Binaries
- IDE (IntelliJ Idea, Eclipse etc.)
- GIT 

### Tech stack:
- Java 11
- Maven
- Selenium WebDriver
- TestNG
- Allure
- Please see pom.xml file for more details on application modules

### Supports Browsers
- Chrome (latest version)
- Firefox (latest version)

### How to run with Maven

Type from terminal for running tests in different browsers:

```
mvn clean test -Dbrowser="chrome"
mvn clean test -Dbrowser="firefox"
```

Type from terminal for running report:

```
allure serve target/allure-results

```

