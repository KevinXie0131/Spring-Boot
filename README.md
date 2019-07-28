#Java Assignment

The purpose of the assignment is to read cities from a database and perform the following operations:
- List all cities,
- CRUD operations, and
- Calculate distance between two cities (chosen by user) using the provided latitude and longitude.

You have the option of implementing the above operations as a REST API or as a web application.  The goal of the
test is not to judge the front end therefore your pages can be simplistic.

You are provided three source files to mock a database (don't be concerned that the data is not persisted
when the app is restarted):
- ./src/main/java/com/leonardo/data/CityDatabase.java:  the class that provides the data.  Don't access directly, see DAO below.
- ./src/main/java/com/leonardo/data/CityDAO.java:  the DAO for the City database. You may modify if required.
- ./src/main/java/com/leonardo/model/City.java:  object representing a City. You may modify if required.

You are free to chose any framework as long as the backend is written in Java.

NOTE: Please submit the assignment by uploading to Google Drive, Microsoft
OneDrive, Dropbox, or a similar service.