package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="course")
public class course {
	@Id
	@Column(name="id")
	int id;
	@Column(name="course_name")
	String name;
	@Column(name="cost_perDay")
	String cost_perDay;

	
	
	public course() {
	
	}
	
	public course( String name,  String cost_perDay) {
		this.name = name;
		this.cost_perDay = cost_perDay;

	}

	public void setCourse(course c)
	{
		this.setName(c.name);
		this.setCost_perDay(c.cost_perDay);
		
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

	public String getCost_perDay() {
		return cost_perDay;
	}

	public void setCost_perDay(String cost_perDay) {
		this.cost_perDay = cost_perDay;
	}

		
}
