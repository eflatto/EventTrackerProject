window.addEventListener('load', function(e) {
	console.log('script.js loaded');
	init();
});

function init() {
	console.log('in init');

	loadAllJobApplications();
}


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
		
		td = document.createElement('td');
		td.textContent = job.user.username;
		tr.appendChild(td)
		
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
		
		td = document.createElement('td');
		td.textContent = job.status.statusName;
		tr.appendChild(td)





	}

}