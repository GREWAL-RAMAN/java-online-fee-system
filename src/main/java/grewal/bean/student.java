package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "student")
public class student {
	@Id
	@Column(name ="id" )
	int id;
	
	@Column(name = "st_name")
	String name;
	
	@Column(name = "st_email")
	String email;
	
	@Column(name = "st_contact")
	String contact;
	
	@Column(name = "st_address")
	String address;

	
 
public student() {
		
	}
public student(String name, String email, String contact, String address) {

	this.name = name;
	this.email = email;
	this.contact = contact;
	this.address = address;
}
public void setStudent(student my_) {
	this.setName(my_.name);
	this.setContact(my_.contact);
	this.setEmail(my_.email);

	this.setAddress(my_.address);
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "student [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", address=" + address
			+ " ]";
}

 
}
