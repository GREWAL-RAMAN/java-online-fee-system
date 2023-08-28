package grewal.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "fee_payment")
public class fee_payment { 
    @Id
	@Column(name = "id")
    int 	id ;
	@Column(name = "st_id")
     int 	st_id ;
	@Column(name = "p_id")
    int 	p_id ;
	@Column(name = "amount")
    double 	amount ; 
	@Column(name = "method_name")
    String	method_name ; 
	@Column(name = "date_time")
	String	date_time ;
	@Column(name = "account_details")
    String	account_details ;
	
	
	
	public fee_payment(int st_id, int p_id,  double amount, String method_name, String date_time,
			String account_details) {
	
		this.st_id = st_id;
		this.p_id = p_id;
		this.amount = amount;
		this.method_name = method_name;
		this.date_time = date_time;
		this.account_details = account_details;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public fee_payment() {
	
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

	public String getMethod_name() {
		return method_name;
	}

	public void setMethod_name(String method_name) {
		this.method_name = method_name;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double  amount) {
		this.amount = amount;
	}
	public String getmethod_name() {
		return method_name;
	}
	public void setmethod_name(String method_name) {
		this.method_name = method_name;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getAccount_details() {
		return account_details;
	}
	public void setAccount_details(String account_details) {
		this.account_details = account_details;
	}
   
	

}
