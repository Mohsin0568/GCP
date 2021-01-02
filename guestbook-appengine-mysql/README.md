# Sample App to connect Google Cloud SQL via Spring boot JPA

- Create default app in app engine before deploying app.
   ``` gcloud app create --region=us-central ```
- Update Yaml file and properties files for both projects based on local configurations.
- Create Cloud SQL instance with private IP enable and update its configuration in application-cloud.properties file.
- Create databse and user in Cloud SQL instance.
- Create Serverless VPC to connect Cloud SQL from App engine via private IP.
- Update Serverless VPC name in guestbook-service app.yaml file.
- Deploy both Apss on App Engine using command.
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
