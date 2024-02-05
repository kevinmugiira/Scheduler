# Scheduler Spring Boot Report Generation App

This Spring Boot application allows you to generate timely reports from a FAULU BANK database.

## Features
1. **_Report Generation:_** Generate reports based on data from FAULU database.
2. **_Customizable:_** Easily configure the database connection via the application.yml file and report generation parameters.
3. **_Scheduled Reporting:_** Set up scheduled tasks to generate reports at specific intervals.

## Prerequisites
* Java Development Kit (JDK) installed on your machine.
* Maven installed for building the application.
* Access to a Microsoft SQL server with the FAULU BANK database.

## Setup Instructions
* Clone the repository to your local machine:
*     git clone git@github.com:kevinmugiira/Scheduler.git
* Navigate to the project directory on your local machine:
*     cd <directory_with_the_app_folder>/Scheduler
* Configure the application properties in application.yml to connect to the database.
* Build the application using Maven: 
*     mvn clean install
* Run the application:
*     java -jar target/scheduler-0.0.1-SNAPSHOT.jar 
     

## Accessing the Application
Once the application is running, you can access it using a web browser or through HTTP requests.

* **_Web Interface_**: Open a web browser and navigate to http://localhost:8081 to access the application's user interface.
* **_RESTful API_**: The application will expose RESTful endpoints for report generation. "http://localhost:8081/report/txttypereport"

## Additional Configuration
* Adjust the scheduled reporting intervals in the @Scheduled annotation in the 'ReportGenerationScheduler.java' within the scheduler package.
* Customize the report generation logic and templates according to your requirements.

## Troubleshooting
* Check the application logs for any errors or exceptions.
* Ensure that the database connection settings are correct.
* Verify that the required dependencies are installed and configured properly.


## Support
For any issues or questions, please contact 
*     mugiira.john@eclectics.io
