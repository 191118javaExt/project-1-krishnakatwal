
function sendLogin() {
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let email = loginForm.email.value;
	let password = loginForm.password.value;

	let loginTemp= {
			email: email,
			password: password,
	};

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			sessionStorage.setItem('currentUser', this.responseText);
			window.location = "http://localhost:8080/project-1/user/home.HTML";
		}
		
		if(this.readyState === 4 && this.status === 204) {
			alert("Failed to login! email or password is incorrect.");
		}
	};

	xhr.open("POST", "http://localhost:8080/project-1/login.html");

	xhr.send(JSON.stringify(loginTemp));
}