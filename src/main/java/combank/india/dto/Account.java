package combank.india.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accNo;
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getAccHldrName() {
		return accHldrName;
	}
	public void setAccHldrName(String accHldrName) {
		this.accHldrName = accHldrName;
	}
	public Double getAccBal() {
		return accBal;
	}
	public void setAccBal(Double depBal) {
		this.accBal = depBal;
	}
	@Column
	private String accHldrName;
	@Column
	private Double accBal;

}
