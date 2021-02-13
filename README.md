## FOXSports UI Coding challenge

This UI Framework was developed using below components
 * Maven
 * TestNG
 * Page Object Model(Design pattern)

## Installation (Pre-requisites)
* jdk1.8 or higher
* Maven
* IntelliJ IDEA(preferred)

## How to run tests
* mvn clean test (or) 
* Navigate to Foxsports/src/test/java/com/au/foxsports/test/FoxSportsTest.java and right click Run As > TestNG Test (or)
* Navigate to Foxsports/testng.xml and right click Run As > TestNG Suite

## Result
* On completion of maven command (mvn clean test),reports will be generated in folder
<path-to-project-folder>/test-output/screenshots/AutomationReport.html

## Things to Improve(if time permits):

* Screenshot can be added in each test assertion on the extent report
* Include Logger to have more info if any test case fail/pass/skip
* More efficient way of identifying UI objects
