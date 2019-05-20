# Recipe-to-basket-Matcher
Recipes Recommendation System
#
#
1.	Download and Install the necessary software
JAVA software development kit should be installed. 
The version I used is 1.8.x
Download and install the following software
1.	MySQL Community Installer 
When setting up the server, keep a note of what password are you setting up for the database, I have given the username & password as root, root respectively.
2.	Apache Tomcat v9.0 (use this version only)
It is usually an archive folder which can be extracted to anywhere in the computer
3.	Eclipse IDE (Latest version is advised but should work with any version)
#
#
2.	Import the Data base Schema (MySQL)
a) In current repository you can find the folder Database Data, that contains SQL script for loading the data required to run Recipe-Matcher system.
b)	Open the MySQL workbench and connect to local host. Enter the credential as username = "root" and password = "root", which you set during the installation of server.
c)	Go to file create new SQL script. Copy the contain of recipe-matcher-sql-dump.sql from sql folder in point 1.
d)	Run the script.
e)	This script contains the schema for Creating all the tables & inserting the records into table. 
f)	Once the scripts are executed you will be able to see a new schema name: “recipe_matcher” on left side, if not click on the refresh button.
g)	The database is set up and ready to use.
#
#
3.	Import the code
a)	Open eclipse 
b)	If it is a first time it may ask you to select a workspace, select one and continue.
Workspace is a folder where all your codes and projects reside. You can have multiple workspace in a single system.
c)	Go to file, Import, existing project.
d)	Select the project (here the project name is "Recipe-Matcher"), it may ask you to set a runtime instance. Here you will specify the server you installed step 2. Select the appropriate version and location where it exists.
e)	Once the import wizard is done, go to project and then clean and select the imported project. This will ensure all the libraries and installed and ready to use.
f)	Once all the dependencies are downloaded select the project and click on run. 
If ask for which runtime environment select the Tomcat version you downloaded and the give the path where it is installed. Then continue.
g)	Once the server boots up a new window should open with:
url: http://localhost:8080/Recipe-Matcher/index.jsp
h)	Click on "Register/Login"  & Enter the credentials to login:
a.	User: apoorva.12993@gmail.com
b.	Password: 12993
While adding ingredients through excel file, don't forget to change the path of the folder in the following  files:
a. In the source code go to: com.recipes.controller
Open ProcessIngredients.java and go to line 25. Change the value of variable "UPLOAD_DIRECTORY" to the path of folder where your excel file is present. 
b. In the source code go to: com.recipes.dao
Open ProcessExcelFile.java and go to line 38. 
String FILE_PATH = "C:/Users/ApoorvaK/Documents/uploads/user_" + Integer.toString(id) + ".xlsx"  ;
In the above line only change "C:/Users/ApoorvaK/Documents/uploads/" part, keep everything else as it is. 
#
#
4.	Key Point to remember:
1.	Database Connection
a.	In the source code go to: com.recipes.util
b.	Open DBConnection.java
c.	The code for database connection exists here.
d.	If you have used different password when installing the MySQL server. Change the value of PASSWORD at line 10.
Or if you have change the port or the user or are using different system as database then change the IP address of that system.
e.	The variable DB holds the value of the schema where all your table reside for the system. 
f.	If you are using some different database to use with this system, write the code for that in the method createConnection().
#
Web files: All the JSP files are in WebContent folder

