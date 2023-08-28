package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "student_login")
public class student_login {
	@Id
	@Column(name = "st_id")
	int id;
	@Column(name="username")
	String username;
	@Column(name = "password")
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public student_login(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public student_login() {
	
	}
	public void setstudent_login(student_login my_s) {
	        this.setUsername(my_s.getUsername());
	        this.setPassword(my_s.getPassword());
	}
	
	
}
