package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "assign")
public class assign {
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "st_id")
	int st_id ;
	@Column(name = "st_name")
	String st_name ;
	@Column(name = "course_id")
	int course_id ; 
	@Column(name = "co_name")
	String co_name ;
	@Column(name = "transport_id")
	int transport_id ; 
	@Column(name = "tp_distance")
	String tp_distance ;
	@Column(name = "date")
	String date ; 
	@Column(name = "status")
	String status ;
	
	
	public assign(int id, int st_id, String st_name, int course_id, String co_name, int transport_id,
			String tp_distance, String date, String status) {
		this.st_id = st_id;
		this.st_name = st_name;
		this.course_id = course_id;
		this.co_name = co_name;
		this.transport_id = transport_id;
		this.tp_distance = tp_distance;
		this.date = date;
		this.status = status;
	}

	public assign() {
	
	}
	
	
	
	@Override
	public String toString() {
		return "assign [id=" + id + ", st_id=" + st_id + ", st_name=" + st_name + ", course_id=" + course_id
				+ ", co_name=" + co_name + ", transport_id=" + transport_id + ", tp_distance=" + tp_distance + ", date="
				+ date + ", status=" + status + "]";
	}

	
	public String getSt_name() {
		return st_name;
	}

	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public String getTp_distance() {
		return tp_distance;
	}

	public void setTp_distance(String tp_distance) {
		this.tp_distance = tp_distance;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getTransport_id() {
		return transport_id;
	}
	public void setTransport_id(int transport_id) {
		this.transport_id = transport_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setassign(assign myasi)
	{
		this.setCourse_id(myasi.course_id);
		this.setDate(myasi.date);
		this.setTransport_id(myasi.transport_id);
		this.setStatus(myasi.status);
		this.setSt_id(myasi.st_id);
		
	}
	
	

	
}
