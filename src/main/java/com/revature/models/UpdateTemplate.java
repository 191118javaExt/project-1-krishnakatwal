package com.revature.models;

public class UpdateTemplate {
private int id;
private int  status_id;

public UpdateTemplate(int id, int status_id) {
	super();
	this.id = id;
	this.status_id = status_id;
}

public UpdateTemplate() {
	super();
}

public final int getId() {
	return id;
}

public final void setId(int id) {
	this.id = id;
}

public final int getStatus_id() {
	return status_id;
}

public final void setStatus_id(int status_id) {
	this.status_id = status_id;
}

}
