# assignment
Execution steps:

1. Download the attached project named as assignment and extract it.

2. Open eclipse >> File >> Import >> Click Existing Maven Project >> Location of the project in Root Directory >> Select pom.xml >> Finish

3. Go to src/test/resources >> configFiles >> browserConfig.properties >> give browser name (either chrome or firefox) and save the changes

4. Open the pom.xml file >> update the "webdrivermanager" dependency version 2.1.1-SNAPSHOT for Firefox browser and for Chrome. browser, update 5.3.0 webDriver manager version.
5. Right click on project (assignment) >> Run as >> mvn install (download and install all the dependencies)

6. Right click on project (assignment) >> Run as >> mvn test

7. After execution, report can be seen at test-output folder >> click on emailable-report.html
