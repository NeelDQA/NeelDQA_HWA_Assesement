# Music Management Web Application
Coverage: 98.1 % (Back End)

This project involved creating a full stack web application that had a multi-tier architecture as well as allowing the users to have full CRUD functionality on one entity. When running the .jar file, the user will be able to go to a localhost webpage and create, read, update and delete songs.
The web app was responsive and functions well on computers and handheld devices.

   
## Getting Started

1. Download GIT bash from:https://git-scm.com/
2. Fork the repository to your own account
3. Click on green code button to clone repo
4. Open up git bash and git clone the https link
5. If you have an IDE, you can import the project or follow links below
6. Download Spring 
7. Download MySQL
8. Run the file by typing java -jarims-0.01-jar-with-dependencies.jar
9. Go onto a web browser and go to http://localhost:9092 to view the application. 


## Prerequisites
```
1.MySQL - https://dev.mysql.com/downloads/installer/
2.Eclipse IDE - https://www.eclipse.org/downloads/
3.MAVEN - https://maven.apache.org/
4.JAVA - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
5.JUnit dependancy - <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>
6. Spring - https://spring.io/tools (or through Eclipse Marketplace)
7. Visual Studio Code - https://code.visualstudio.com/
8. Selenium dependancy -  <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
 9. ChromeDriver - https://chromedriver.storage.googleapis.com/index.html
    EdgeDriver - https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
    FirefoxDriver - https://github.com/mozilla/geckodriver/releases
    Safari - Built-in
 10. SonarQube - https://www.sonarqube.org/downloads/
```

## Installing
```
JAVA For Windows:
1. Get the JDK(Java development kit) - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
2. Click on the download link and download
3. Keep clicking next until it is installed
4. Press the Windows button and select "Edit the system environment variables"
5. Click Environmental variables
6. Click new
7. Write "JAVA_HOME" as variable name and click OK
8. Click  Edit Path under System Variables
9. Append the path by writing %JAVA_HOME%\bin;

JAVA for Ubuntu:
1.Open terminal
2.Type: "sudo apt install openjdk-8-jdk -y"
3.Verify by running java -versuon


MySQL:
1.Download the installer from the link above 
2.Choose your system preference
3.Pick MySQL server 8 and MySQL Workbench
4.Click next
5.Open a command prompt and type:  cd C:\Program Files\MySQL\MySQL Server 8.0\bin
6.Then write:  mysqld --console --initialize
7.Check if it has initialised by: mysqld --console
8.Open a new prompt and type: cd C:\Program Files\MySQL\MySQL Server 8.0\bin
 mysql -u root -p
9. Resest the password:  ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

MAVEN:
Download from above and add dependancies in the pom.xml file

JUnit:
JUnit 5 can be found on the Maven repository. 
Copy and paste the dependance and place it in the pom.xml file.
It should look like:
xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qa</groupId>
    <artifactId>maven-example</artifactId>
    <version>1.0.0-SNAPSHOT</version>

    <properties>
        <junit.version>4.12</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

Eclipse: 
Eclipse can be downloaded from the website above

Spring:
STANDALONE:
1. Go to the Spring Tools page as specified in the Prerequisites and download the file specified for your system.
2. Extract the files and  inside the folder, run the SpringToolSuite4 application.

ECLIPSE:
1. Open Eclipse IDE
2. Click on the help tab
3. Navigate to the Eclipse Marketspace
4. Search for Spring in the searchbar and the latest version should be displayed
5. Click Install

SonarQube: 
1. Navigate to the link above to and download SonarCube Community Edition
2. Unzip the file 
3. In the command line interface(command prompt) execute - C:\sonarqube\bin\windows-x86-xx\StartSonar.bat
4. Alternatively it is possible to manually navigate  to execute StartSonar.bat
5. Once SonarQube is running, got to a web browser and navigate to https://localhost:9000
``` 

## Testing

### Unit Tests 

Unit tests are test where bits of code or classes are tested individually. The SongServiceUnitTest class runs the unit tests in this project. It used Mockito to mock the behaviour of the SongRepo class to ensure that only the Service class was tested hes making it a unit test.
Before running the test, ensure that the active profile is test by going into the src/main/resources file and setting spring.profiles.active=prod. Then left click on the test class and run with JUnit. The tests should all run and pass successfully.

### Integration Tests

Unlike unit tests, integration tests focus on testing multiple modules together ensuring they work as expected. The SongController response status and content of the API requests were tested with pre-poupulated data in an sql database. To run these tests simply ensure that the test profile is active and then left-click on the class and run with JUnit.

### Selenium

Selenium is a tool that allows us to automate web browsers for testing, essentially testing the Front End HTML and JavaScript files. The Selenium tests in this project are in the musicmanagement-selenium folder. To run the tests, ensure that required driver for your system is downloaded from the links above. Once the file has downloaded, place it in the src/test/resources folder. Then navigate to the test package and run IndexTest.java as a JUnit test.

### SonarQube

 SonarCube is a statistical analysis tool used to help write cleaner and safer code. It checks for bugs, vulnerabilites and security hotspots in our code and tells us how to fix any issues.
First follow the instructions above in the install section to install SonarQube and ensure the application is running. To send the project to SonarCube:
1. Navigate to the project directory and Git Bash Here
2. Enter the following:
 mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 
 -Dsonar.login=admin -Dsonar.password=admin
 3. If the build is successfull, you should navigate to localhost:9000 and the project should be visible.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Agile Board
[JIRA] https://team-1616578727154.atlassian.net/secure/RapidBoard.jspa?projectKey=MWA&useStoredSettings=true&rapidView=5&atlOrigin=eyJpIjoiZjM3N2M0ZWZhZThlNDU5ODlhZjkwM2ZjMzA4YzgyMjciLCJwIjoiaiJ9

## Authors

* **Neel Dudhia** - * - [NeelDudhia](https://github.com/NeelDQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*

## Acknowledgments
Thank you to Savannah, Aswene, and Vinesh for all their help throughout the project.
