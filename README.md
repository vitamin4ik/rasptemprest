# rasptemprest


- download package RaspRESTExample_1.0-1.all.deb into your home folder.

         $ wget -O- -q --no-check-certificate https://github.com/vitamin4ik/rasptemprest/downloads | grep -o -l -e 'RaspRESTExample_0.1.1_all.deb' 

- install int via dpkg suite
    
         $ sudo dpkg -i RaspRESTExample_0.1.1_all.deb
      
  after successful execution you should have tomcat7 and jdk installed, if you didn't have them before, and your webapp (WAR file) 
  deployed into 
  
        /var/lib/tomcat7/webapps
     
- to execute this app tomcat should have access and right to  use it. If user tomcat.tomcat doesn't have it yet, use
     
        $ sudo chown tomcat:tomcat /var/lib/tomcat7/webapps/
     
- to test web application launch browser and type this URL in address bar:

        http://localhost:8080/RaspRESTExample/
     
You should see the information about  the current core temperature of <b><i>BCM2835/6/7</i></b>
