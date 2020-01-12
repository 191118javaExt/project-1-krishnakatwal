function submitReimbursement(){
	
	let form = document.ExpenseReimbursementForm;
	
	let amount = form.amount.value;
	
	
	let description = form.description.value;
	
	let type_id = form.type_id.value;
	
	let user = sessionStorage.currentUser;
	
	let current = JSON.parse(user);
	
	let ExpenseReimbursementobj = {
			author_id: current.id,
			amount: amount,
			description: description,
			type_id:type_id,
	}
	console.log(ExpenseReimbursementobj);
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(this.readyState === 4 && this.status === 200) {
			alert("Reimbursement Successfull.")
			sessionStorage.setItem("currentReimbursement", this.responseText);
			window.location = "http://localhost:8080/project-1/user/ViewReimb.html";
		}
		
		else if(this.readyState === 4 && this.status === 204){
			alert("Reimbursement failed.")
		}
	};
	
	xhr.open("POST","http://localhost:8080/project-1/SubmitReimbursement")
	xhr.send(JSON.stringify(ExpenseReimbursementobj));
	
};
