 ## UIAutomation Workshop 

#### Run via Command Line

 $` gradle clean test -PsuiteFile=testing.xml` 

#### Application Under Test
:point_right: https://spree-vapasi.herokuapp.com/


#### Branches
* ###### _[Level1] - Initial Project Structure with gradle as build tool with selenium and reporting dependencies and sample testing xml files._
* ###### _[Level2] - Automate Basic Login Fail and Login Pass Flows and define common flows using testng Before and After annotations_ 
* ###### _[Level3] - Extract Configurations from tests like url, username and password_
* ###### _[Level4] - Automation One End 2 End User Journey_
* ###### _[Level5] - Create Framework by Using PageFactory and define BasePage for the pages and modify test to use framework for the E2E Journey_
* ###### _[Level6] - Creating Data Driven Test for the Login Scenarios_
* ###### _[Level7] - Use Factory Pattern to Create Driver Factory_
* ###### _[Level8] - Use testng xml for Parallel execution of test/Cross Browser Testing  and sample tests demonstrating remote execution on Selenium Grid._ 
* ###### _[Level9] - Integrating RemoteWebDriver into Framework and IntroduceDriver Manager_
* ###### _[Level10]- Use docker-compose.yml file to setup grid infrastructure_
* ###### _[Level11] - Running Selenium Tests inside a container using dockerfile._
       

#### Selenium Grid Setup

Steps -
1) Download Selenium Standalone server
2) Register a Hub  `java -jar selenium-server-standalone-3.141.59.jar -role hub`
   ###### See Console on local - http://localhost:4444/grid/console 
3) Download Chrome/Firefox or any other browser on which you want to execute the tests
4) Register Nodes command examples 

  * `java -jar -Dwebdriver.chrome.driver=<Path For Chrome Driver> selenium-server-standalone-3.141.59.jar -role node -hub   http://localhost:4444 `

  * `java -jar -Dwebdriver.gecko.driver=<Path For gecoDriver for firefox> selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444 `

  * `java -jar -Dwebdriver.chrome.driver=<Path For Chrome Driver> -Dwebdriver.gecko.driver=<Path For gecoDriver for firefox> selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444 `


References -
* Selenium Standalone Server  
:point_right: https://www.selenium.dev/downloads/ . - Download Latest stable version 3.141.59
* Grid Documentation  
:point_right: https://www.selenium.dev/documentation/en/grid/
* Chrome Driver
:point_right: https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/
* Firefox Driver
:point_right:https://github.com/mozilla/geckodriver/releases/tag/v0.26.0
