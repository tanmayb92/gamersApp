Steps to Run : 

	1. After downloading the project as zip from github repo, extract it to a location.
	2. To run : 
			2.1 : Go to /src/main/resources/frontend/GamersApp and run 'npm install'
			2.2 : Go to root dir and run 'mvn package'. This will generate a project snapshot jar in target folder.
			2.3 : Go /target and run 'java -jar XXXX.jar'. This will run the project on server(8080).
			2.4 : Project homepage can be accessed at http://localhost:8080 and other api's can be tested.
			or 
			'mvn spring-boot:run' can be run after 2.1
			
	3. swagger api documentation can be accessed on : http://localhost:8080/swagger-ui.html		
	

Challenges/Decisions : - Related to Geographical location of gamer. Could have taken directly Geo in Gamer Model but decided 
						 to go for Country and map it with Geographical location.
	
