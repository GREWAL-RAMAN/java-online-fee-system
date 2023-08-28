package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity(name = "course_cost")
public class course_cost {

     @Id
	@Column(name = "st_co_id")
	int id;
	
     @Column(name = "st_id")
	int st_id;
	
	@Column(name = "co_name")
	String nameCourse;
	
	@Column(name = "cost")
	String cost;

	public course_cost() {
	}

	public course_cost(int id, int st_id, String nameCourse, String cost) {
		this.id = id;
		this.st_id = st_id;
		this.nameCourse = nameCourse;
		this.cost = cost;
	}

	public void setCourse_Cost(course_cost myCourse_cost) {
		this.id = myCourse_cost.getId();
		this.st_id = myCourse_cost.getSt_id();
		this.nameCourse = myCourse_cost.getNameCourse();
		this.cost = myCourse_cost.getCost();
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

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
      
	
	
}
