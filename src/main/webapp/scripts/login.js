
function sendLogin() {
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let email = loginForm.email.value;
	let password = loginForm.password.value;
console.log("this is inside log in js");
	let loginTemp= {
			"email": email,
			"password": password,
	};
	console.log(loginTemp);
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			sessionStorage.setItem('currentUser', this.responseText);
			console.log(this.responseText);
			console.log(sessionStorage.getItem('currentUser'));
			window.location = "http://localhost:8080/project-1/user/home.HTML";
		}
		
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! email or password is incorrect.");
		}
	};

	xhr.open("POST", "http://localhost:8080/project-1/login");

	xhr.send(JSON.stringify(loginTemp));
};