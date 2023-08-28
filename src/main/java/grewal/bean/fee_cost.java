package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "fee_cost")
public class fee_cost {

	
	@Column(name = "st_id")
	private int st_id;
	@Id
	@Column(name = "co_id")
	private int co_id;
	@Column(name = "co_name")
	private String co_name;

	@Column(name = "cost")
	private double cost;

	@Column(name = "payed")
	private double payed;

	@Column(name = "status")
	private String status;

	public fee_cost() {

	}

	public fee_cost(int st_id, int co_id, String co_name, double cost, double payed, String status) {

		this.st_id = st_id;
		this.co_id = co_id;
		this.co_name = co_name;
		this.cost = cost;
		this.payed = payed;
		this.status = status;
	}

	public int getCo_id() {
		return co_id;
	}

	public String getCo_name() {
		return co_name;
	}

	public double getCost() {
		return cost;
	}

	public double getPayed() {
		return payed;
	}

	public int getSt_id() {
		return st_id;
	}

	public String getStatus() {
		return status;
	}

	public void setCo_id(int co_id) {
		this.co_id = co_id;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setPayed(double payed) {
		this.payed = payed;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
