package grewal.bean;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "st_course")
public class st_course {
	
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "st_id")
	int st_id;
	@Column(name = "st_name")
	String st_name;
	@Column(name = "co_id")
	int co_id;
	@Column(name = "co_name")
	String co_name;
	@Column(name = "start_date")
	String start_date;
	@Column(name = "end_date")
	String end_date;


	public st_course() {
	
	}
	public void st_courses(st_course s) {
		this.st_id =s.getSt_id();
		this.st_name=s.st_name;
		this.co_id =s.getCo_id();
		this.co_name=s.co_name;	
		this.start_date=s.start_date;
		this.end_date=s.end_date;
	}
	
	
	
	public st_course( int co_id, String co_name, String start_date, String end_date) {
		this.co_id = co_id;
		this.co_name = co_name;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public st_course(int st_id, String st_name, int co_id, String co_name, String start_date, String end_date) {
		this.st_id = st_id;
		this.st_name = st_name;
		this.co_id = co_id;
		this.co_name = co_name;
		this.start_date = start_date;
		this.end_date = end_date;
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

	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
	public int getCo_id() {
		return co_id;
	}
	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}
	
}
