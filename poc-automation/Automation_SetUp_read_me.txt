
1. Download latest maven binary zip code from 

	source : http://maven.apache.org/download.cgi
	
	Unzip on any location and set up environment variable
	
	eg.
	M2_HOME 
	D:\Datta\Techinal\Jbehave\apache-maven-3.1.0-bin\apache-maven-3.1.0
	
	M2
	%M2_HOME%\bin

2. Download chrome driver from http://chromedriver.storage.googleapis.com/index.html?path=2.9/ according to system
	and unzip in required location
	
3. Download IE driver from https://code.google.com/p/selenium/downloads/list?can=1&q=&colspec=Filename+Summary+Uploaded+ReleaseDate+Size+DownloadCount according to system
	and unzip in required location

4. Setup up and chrome driver in path variable

5. download and unzip poc-automation.rar 

6. go to project location in command prompt

7. execute following command (First time it will take to download all required jar for executing automation)
		mvn eclipse:eclipse

8. open eclipse and import generated project (steps 7) in eclipse

9. Install TestNg plug in for eclipse (This is just to run tests using eclipse)	. Eclipse help > Install New Software
	http://beust.com/eclipse

10. Go to automation project properties
		Project > Properties > Java build Path > Libraries > Add variables >  configure variables > New > 
		M2_REPO
		F:/Desktop/.m2/repository
		
		Above path is maven repository path. 
		To get M2_REPO value , need to execute command following on command prompt
		mvn -X
		
		After completing it will take time to set build path.
11. Now automation project is ready to execute (via eclipse/maven)	


12. Execution:
		a. Using eclipse:
			Open com.mycompany.myproject.testscripts.Logintest.java
			
			Right click and Run As TestNG test
			
	
		b. Open command prompt and navigate to project location(pom.xml)
		
			1. Following command will execute all test  on default browser, browser can pick from driver.properties
				mvn clean test
					
				Execution result can be found in 
				
				//project location/test-output/emailable-report.html
			
			2. Run time browser change
				
				mvn clean test -Dtest.browser=chrome
				mvn clean test -Dtest.browser=ie
				mvn clean test -Dtest.browser=firefox
			
			Execution result will be placed in 
			//project location/target/surefire-reports/emailable-report.html