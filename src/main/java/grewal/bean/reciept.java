package grewal.bean;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "reciept")
public class reciept {
    @Id
    @Column(name = "id")
	int id;
    @Column(name = "date_time")
	String datetime; 
    @Column(name = "st_id")
	int st_id;  
    @Column(name = "method_name")
	String method_name ; 
    @Column(name = "amount")
	String amount ; 
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String date) {
		this.datetime = date;
	}

	public int getSt_id() {
		return st_id;
	}

	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}

	public String getmethod_name() {
		return method_name;
	}

	public void setmethod_name(String method_name) {
		this.method_name = method_name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	

	@Override
	public String toString() {
		return "reciept [id=" + id + ", datetime=" + datetime + ", st_id=" + st_id + ", method_name=" + method_name
				+ ", amount=" + amount ;
	}

	public reciept() {
	
	}

	public reciept(String datetime, int st_id, String method_name, String amount, String discount, String final_amount) {
	
		this.datetime = datetime;
		this.st_id = st_id;
		this.method_name = method_name;
		this.amount = amount;
	}
 
	public void setreciept(reciept myre)
	{
		this.setAmount(myre.amount);
		this.setDatetime(myre.datetime);
		this.setmethod_name(myre.method_name);
		this.setSt_id(myre.st_id);
	
	}
	
	
}
