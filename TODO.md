Steps taken
Create repo
Install Maven
http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
mvn archetype:generate -DgroupId=com.company.app -DartifactId=todos-webapp -DarchetypeArtifactId=maven-archetype-webapp

Karma
- needs CHROME_BIN
- PhantomJS node karma bug - won't exit in ci mode
- dev mode: karma start todos-web\src\test\scripts\js\conf-dev.js

E2E
mvn verify -P e2e
