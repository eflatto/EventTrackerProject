# EventTrackerProject

# Description
The Job Application Tracker is a REST API that allows users to keep track of the job applications they have submitted. Users can create, read, update, and delete job applications, as well as filter and sort their applications by various criteria. The application also allows users to associate each job application with a specific user accounts

# Technologies Used

<ul>
<li>Java</li>
<li>Spring Boot</li>
<li>JUnit</li>
<li>MySQL</li>
<li>REST</li>
<li>Gradle</li>
<li>Spring Data JPA</li>
</ul>

# Entities

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

The User Entity contains two main fields username and password representing the unique user who is tracking job applications


# Repositories and Services

### Repositories
The repositories provide database access to the service classes. The repositories allows users to retrieve job applications by various queries to retrieve specific information about job applications or users.

### Services
The service classes use the autowired repository object to easily query the database

methods like
``` @Override
	public List<JobApplication> findByDateAppliedRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
	 return repo.findByDateAppliedBetween(startDate, endDate);
	} ```



