Steps taken
Create repo
Install Maven
http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
mvn archetype:generate -DgroupId=com.company.app -DartifactId=todos-webapp -DarchetypeArtifactId=maven-archetype-webapp

Karma
- needs CHROME_BIN
- PhantomJS node karma bug - won't exit in ci mode
- dev mode: karma start todos-web\src\test\scripts\js\conf-dev.js
- add to build: automatically install karma and karma-coverage if absent

E2E
mvn verify -P e2e

Build
- fix some file encoding warnings

Manual cargo start
- currently cargo:run can be used only from todos-e2e but it still deploys a wrong war

Thucydides
- when checking non-existense of elements move parent element to member with FindBy annotation. this asserts that the parent does exist
-- limitation of $() is that in case of missing element the error message is not clear "Expected enabled element '<Undefined web element>' was not enabled"
- log4j configuration TBD