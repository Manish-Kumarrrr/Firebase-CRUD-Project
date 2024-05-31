# Firebase CRUD Project

This project is a simple CRUD (Create, Read, Update, Delete) application built using Firebase as the backend database. It allows users to perform basic operations on a dataset stored in Firestore.

## Demo Video

[![Watch the video]](https://drive.google.com/file/d/1OzfqMnHMuQlYtjXUC4SAA2XyscBS_Zou/view?usp=sharing)

Click on the image above to watch the demo video.
## Features

- Create new records in the database
- Read existing records from the database
- Update existing records in the database
- Delete records from the database
- All Exceptions are handled

## Setup

### 1. Project Setup

1. Clone this repository to your local machine.
2. Import the project into your preferred IDE.
3. Ensure you have Java and Maven installed on your system.
4. Configure your IDE to use the JDK and Maven.
5. Build the project using Maven: `mvn clean install`
6. 
### 2. Firebase Setup

1. Go to the [Firebase Console](https://console.firebase.google.com/) and create a new project.
2. Enable Firestore as your database.
3. Generate a service account key for your project and download the JSON file. Rename it to `firebase-adminsdk.json` and place it in the `resources` directory of your project.
4. Also, give your database URL in the CrudApplication (main file)



### 3. Running the Application

1. Run the application from your IDE or using the command: `mvn spring-boot:run`
2. The application will start and be accessible at `http://localhost:8080`

## Usage

- Once the application is running, you can use any HTTP client (e.g., Postman) to interact with the REST API endpoints.
- The following endpoints are available:

    - `GET /api/user`: Retrieve all objects from the database.
    - `GET /api/user/{id}`: Retrieve a specific object by its ID.
    - `POST /api/user`: Create a new object.
    - `PUT /api/user`: Update an existing object.
    - `DELETE /api/user/{id}`: Delete an object by its ID.

- Send HTTP requests to these endpoints to perform CRUD operations on the database.

## Technologies Used

- Java
- Spring Boot
- Firebase Firestore

## Dependencies

- com.google.firebase:firebase-admin:9.3.0
- org.springframework.boot:spring-boot-starter-web

## Author

- [Manish Kumar]


