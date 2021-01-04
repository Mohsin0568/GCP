# Sample App with Google Cloud SQL, App Engine and Spring Cloud Config Server

First run config server application, uncomment property to read property files from local config server and test below URL's from postman using Basic authentication, credentials are available in application-properties file.
- http://localhost:8888/guestbook-backend/cloud
- http://localhost:8888/guestbook-backend/local
- http://localhost:8888/guestbook-frontend/default

Now comment property which we have uncommented property in above step and run above url's to test properties from git repo.


Now run frontend and backend application and check if properties are loaded from config server. Run backend app with 'dev' profile.

Now run application on App Engine using below steps.

- Create default app in app engine before deploying app.
   ``` gcloud app create --region=us-central ```
- Update Yaml file and properties files for all three projects based on local configurations.
- Create Cloud SQL instance with private IP enable and update its configuration in application-cloud.properties file.
- Create databse and user in Cloud SQL instance.
- Create Serverless VPC to connect Cloud SQL from App engine via private IP.
- Update Serverless VPC name in guestbook-service app.yaml file.
- First deploy config-server app and test if properties are loaded from github or not.
- Now run other apps on App Engine using command.
  ```mvn package appengine:deploy```

Create table query:
```
CREATE TABLE guestbook_message (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name CHAR(128) NOT NULL,
  message CHAR(255),
  image_uri CHAR(255),
  PRIMARY KEY (id)
);
```
