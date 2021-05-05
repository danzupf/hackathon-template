# App Template for Bonding Hackathon 2021

This project is a template for the Frankfurt Bonding Hackathon on 2021-05-06/7.

It comprises a frontend and a backend to help you get started.
You are free to start from scratch in any language/framework you want of course.
There are no bonus points for using the provided project :-)

The provided backend implements an in-memory database as well as requests to query and fill the database.
The provided frontend offers basic interaction with the backend.
From this starting point you can either implement a strong backend or a strong frontend.  
A strong **backend** implements most of the logic and offers specific requests for the frontend to call.  
A strong **frontend** implements most of the logic and queries the backend only for raw data.  
You could even skip the backend and put all functionality into the frontend (or skip the frontend and extend the backend with e.g. vaadin to offer user interaction).


## Backend

### Requirements
  -   JDK: Java 11 (e.g. https://docs.aws.amazon.com/de_de/corretto/latest/corretto-11-ug/downloads-list.html)
  -   We suggest to use IDEA IntelliJ as IDE (others are also possible).

### Run Backend

    cd Backend
    # on a windows machin use gradlew.bat instead of ./gradlew
    ./gradlew build
    ./gradlew bootRun

### Endpoints:

  -   http://localhost:8080/v3/api-docs api as json
  -   http://localhost:8080/v3/api-docs.yaml as yaml
  -   http://localhost:8080/swagger-ui.html     endpoints defined by you or provided by the system in nice layout (you may have to explicitly paste `/v3/api-docs` in the explore-search-bar.
  -   http://localhost:8080/actuator/mapppings  all mappings
    
  to generate the specification as a json file you can use
  
    ./gradlew clean generateOpenApiDocs

### Database:
  -   http://localhost:8080/h2-console
  -   jdbc:h2:mem:testdb

### Lombok
  
  The project uses lombok to save you time typing out boilerplate methods, such as getter, setter, equals. 
  Make sure lomok is setup for your IDE https://projectlombok.org/setup/overview

## Frontend
The frontend is an Angular (https://angular.io/) app with bootstrap (https://getbootstrap.com/) used 
for styling.
This is ONLY a demo! This demo does not indicate how your app should function or look like. Use this demo
to get an understanding of Angular and Bootstrap which may help you to build your webapp. Also, please be aware that you are free to use any other framework or language you wish for the frontend. 

### Requirements
  -   Node.js  (https://nodejs.org)
  -   NPM 
### Run demo app
    cd Frontend/angular-bootstrap-demo
    npm install -g @angular/cli
    npm install --save bootstrap jquery
    ng build
    ng serve
    # reachable @ http://localhost:4200/
### Helpful links
  -   https://angular.io/guide/http
  -   https://www.smashingmagazine.com/2019/02/angular-application-bootstrap/
  -   https://getbootstrap.com/docs/5.0/getting-started/introduction/
  -   https://tburleson-layouts-demos.firebaseapp.com/#/docs
  -   https://css-tricks.com/snippets/css/a-guide-to-flexbox/
  -   https://angular.io/guide/example-apps-list