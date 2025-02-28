# weatherTest

The automation framework used TestNG/Cucumber for Java.
For Task 1, uses Appium for mobile automation, Cucumber for BDD, and TestNG as the test runner.
For Task 2, uses Rest Assured for API testing, Cucumber for BDD, and TestNG as the test runner.
It follows the Page Object Model (POM) for maintainability and scalability.

# Setup Guide for MyObservatory Automation Framework

## Prerequisites
1. **Java JDK**: Install JDK 1.8+ (e.g., OpenJDK).
2. **Maven**: Install Maven for dependency management.
3. **Appium**: Install via npm: `npm install -g appium`.
4. **Android SDK**: Install via Android Studio; set `ANDROID_HOME` environment variable.
5. **Emulator/Device**: Configure an Android emulator or connect a real device.

## Setup Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/edwardkstam/weatherTest.git
   cd weatherTest
2. **Clone the Repository**:
   ```bash
   mvn clean install

3. Configure src/test/java/org/test/TestRunner.java file for your devices Capability
4. Start the Appium server manually:
   ```bash
   appium

5. Run the src/test/resources/testng.xml file as TestNG test or Maven:
   ```bash
   mvn test

## Result:

Task1:
<img width="1221" alt="image" src="https://github.com/user-attachments/assets/5234348f-a022-4b88-a8b9-0516e3fadf3b" />


Task2:
![image](https://github.com/user-attachments/assets/1eb67b24-2802-495a-9770-61cb37ff40aa)

## Open-Source Library find it useful
cucumber-reporting for create report 
