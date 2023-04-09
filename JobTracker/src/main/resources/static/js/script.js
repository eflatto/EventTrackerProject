window.addEventListener('load', function(e) {
	console.log('script.js loaded');

	init();

});

function init() {
	console.log('in init');

	document.jobForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let jobId = document.jobForm.jobId.value;
		console.log(jobId)
		if (!isNaN(jobId) && jobId > 0) {
			getJob(jobId);
		}
	});

	document.newJobForm.addJobButton.addEventListener('click', function(evt) {
		evt.preventDefault();
		// Build job application object from form field values
		let form = document.newJobForm;
		let jobApplication = {
			companyName: form.companyName.value,
			jobTitle: form.jobTitle.value,
			jobDescription: form.jobDescription.value,
			notes: form.notes.value,
			dateApplied: form.dateApplied.value
			/*status:{
				statusName:form.status.value
			},
			user: {
				username: form.username.value
			}*/
		};
		console.log(jobApplication);
		addNewJob(jobApplication);
	});

	//Update Character
	document.updateJobForm.updateJobButton.addEventListener('click', function(e) {
		e.preventDefault();
		let form = document.updateJobForm;

		let updateJob = {
			companyName: form.companyName.value,
			jobDescription: form.description.value,
			notes: form.notes.value,
			dateApplied: form.dateApplied.value

		};

		let jobId = form.jobId.value;

		console.log(jobId + updateJob);
		updateAJob(updateJob, jobId);
	});
	
	//Delete Character
	document.deleteJobForm.deleteJob.addEventListener('click', function(e){
		e.preventDefault();
		let form = document.deleteJobForm;
		let jobId = form.jobId.value;
		deleteAJob(jobId);
	});

	loadAllJobApplications();

}

//Retrieve job application data from the server
function loadAllJobApplications() {
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/jobapplications')

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let jobapplication = JSON.parse(xhr.responseText);
				displayJobList(jobapplication);
			}
			else {
				displayError('Error finding job applications: ' + xhr.status);
			}
		}
	};

	xhr.send();
}

//render the job application data in table format
function displayJobList(jobapplication) {
	//DOM stuff
	let tbody = document.getElementById('jobAppTBody');
	tbody.textContent = '';

	for (let job of jobapplication) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);

		let td = document.createElement('td');
		td.textContent = job.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = job.companyName;
		tr.appendChild(td)

		/*td = document.createElement('td');
		td.textContent = job.user.username;
		tr.appendChild(td)*/

		td = document.createElement('td');
		td.textContent = job.notes;
		tr.appendChild(td)

		td = document.createElement('td');
		td.textContent = job.jobTitle;
		tr.appendChild(td)

		td = document.createElement('td');
		td.textContent = job.jobDescription;
		tr.appendChild(td)

		td = document.createElement('td');
		td.textContent = job.dateApplied;
		tr.appendChild(td)

		/*td = document.createElement('td');
		td.textContent = job.status.statusName;
		tr.appendChild(td)*/

	}


}

function getJob(jobId) {

	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/jobapplications/' + jobId);

	xhr.onreadystatechange = function() {

		if (xhr.readyState === xhr.DONE) {
			if (xhr.status === 200) {
				// * On success, if a response was received parse the film data
				//   and pass the film object to displayFilm().
				let jobJson = xhr.responseText;
				let job = JSON.parse(jobJson);
				displayJob(job);
				//getFilmActors(filmId);
			}
			else {
				// * On failure, or if no response text was received, put "Film not found" 
				//   in the filmData div.
				displayError('Job not found: ' + jobId);
			}

		}
	};
	xhr.send();
}


function displayJob(job) {
	let dataDiv = document.getElementById('jobData');
	dataDiv.textContent = '';

	let h1 = document.createElement('h1');
	h1.textContent = job.companyName;
	dataDiv.appendChild(h1);

	let bq = document.createElement('blockquote');
	bq.textContent = job.description;
	dataDiv.appendChild(bq);
	let ul = document.createElement('ul');
	dataDiv.appendChild(ul);
	let li = document.createElement('li');
	/*li.textContent = "User: " + job.user.username;
	ul.appendChild(li);*/
	li = document.createElement('li');
	li.textContent = "Date Applied: " + job.dateApplied;
	ul.appendChild(li);
	li = document.createElement('li');
	/*li.textContent = "Status: "+ job.status.statusName;
	ul.appendChild(li);*/

}
function displayError(errorMsg) {
	let dataDiv = document.getElementById('jobData');


	dataDiv.textContent = errorMsg;
}

function addNewJob(newJob) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/jobapplications');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.readyState === 201) {
				let job = JSON.parse(xhr.responseText);
				displayJob(job);
			}

		}
	};

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	let newJobJson = JSON.stringify(newJob);
	xhr.send(newJobJson); //FIXME





}




function updateAJob(updateJob, jobId) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/jobapplications/' + jobId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let job = JSON.parse(xhr.responseText);
				console.log(job);
				/*displayJob(job);*/
			}
			else {
				console.error('PUT Request failed: ' + xhr.status);
				displayError('Job not updated: ' + xhr.status + " : " + xhr.responseText);
			}
		}
	}
	xhr.setRequestHeader("Content-type", "application/json");
	let updateJobJson = JSON.stringify(updateJob);
	xhr.send(updateJobJson);
}

function deleteAJob(jobId) {
	let xhr = new XMLHttpRequest();
	
	xhr.open('DELETE', 'api/jobapplications/' + jobId, true);
	xhr.onreadystatechange = function() {
		if (xhr.status === 204 && xhr.readyState === 4) {
			
				console.log("Delete Successful");
		} else {
			console.log('Delete Unsuccessful');
		}
	};
	xhr.send();
}













