package grewal.bean;

public class FeeCostP {
	int st_id;
	int p_id;
    String purpose;
	double cost;
	double payed;
	public FeeCostP() {
	
	}
	public FeeCostP(int st_id, int p_id, String purpose, double cost, double payed) {

		this.st_id = st_id;
		this.p_id = p_id;
		this.purpose = purpose;
		this.cost = cost;
		this.payed = payed;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPayed() {
		return payed;
	}
	public void setPayed(double payed) {
		this.payed = payed;
	}
	
	
	
	

}
