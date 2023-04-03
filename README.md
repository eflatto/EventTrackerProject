## EventTrackerProject
### Description
The Job Application Tracker is a REST API that allows users to keep track of the job applications they have submitted. Users can create, read, update, and delete job applications, as well as filter and sort their applications by various criteria. The application also allows users to associate each job application with a specific user account.

You can checkout all the current job applications here: 

http://18.213.24.90:8080/JobTracker/api/users

### Technologies Used
<ul>
<li>Java</li>
<li>Spring Boot</li>
<li>JUnit</li>
<li>MySQL</li>
<li>REST</li>
<li>Gradle</li>
<li>Spring Data JPA</li>
</ul>

## Entities
### JobApplication Class
This entity is the most important entity in the project it contains the following attributes:

<ul>
<li>id: an integer representing the unique identifier of the job application.</li>
<li>notes: a String representing any notes or comments about the job application.</li>
<li>salary: a Double representing the salary associated with the job application.</li>
<li>companyName: a String representing the name of the company the job application is for.</li>
<li>jobTitle: a String representing the title of the job application.</li>
<li>jobDescription: a String representing the description of the job application.</li>
<li>dateApplied: a LocalDate representing the date the job application was submitted.</li>
</ul>

### Status and User Class
The Status entity represents the status of the job application, each application only has three options: Applied, Rejected,Accepted.

The User Entity contains two main fields username and password representing the unique user who is tracking job applications.

## Repositories, Services, and Controllers
### Repositories
The repositories provide database access to the service classes. The repositories allow users to retrieve job applications by various queries to retrieve specific information about job applications or users.

### Services
The service classes use the autowired repository object to easily query the database. 

for example the JobServiceImpl class provides the following methods:

findAll
getJobById
create
update
deleteById
findAllByOrderBySalaryDesc
count()
findByDateAppliedRange

these methods make use of the JobApplicationRepository object which provides access to to the database through various Spring Data JPA query method. The JobServiceImpl class uses these methods to easily perform CRUD and other operations on the job application data in the database.

### Controllers
The controller  classes are Spring REST controllers that provide endpoints for performing the CRUD operations on the Job and User entities. The controller classes make use and is dependent on the autowired service classes to perform all its operations.


## Lessons Learned
Testing is essential part of the development process, i got a better understanding of using @SpringBootTest to test the endpoints.

Using @JsonIgnoreProperties over @JsonIgnore to ignore certain properties related to entities in order to stop infinite recursion without ignoring the whole object itself.



 

