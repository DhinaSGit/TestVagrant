# TestVagrant
Assignment for L1 interview
Project Contents:

AssignmentTV 
  >src/main/java 
  >src/main/resources 
  >src/test/java 
    >com.base (reusable methods) 
    >com.Endpoints (contains the URL's) 
    >com.MovieDetails 
      >BrowserFactory.java (Page Object Model of the locators used) 
      >MovieDetails.java (TestRunner class) 
  >src/test/resources 
  >JRE system Libs 
  >Logs (contains the logger info) 
  >Screenshots (contains the screenshots of the test) 
  >POM.xml 
  >testng.xml(xml file for execution from suite level)

Instructions of execution:

Pull the project from Git & integrate in IDE
Open MovieDetails.java from com.MovieDetails and Right click and Run as TestNG
For parallel execution remove the priority keyword from the @Test annotation and Right click on testng.xml file and Run as TestNG Suite
Logger information of each steps can be found in the Logs folder Screenshots of the Test execution can be found in the Screenshots folder

**Note:View as RAW for project content expantions

