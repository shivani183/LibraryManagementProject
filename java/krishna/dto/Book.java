package krishna.dto;

import java.io.Serializable;

public class Book implements Serializable{

	private String bid;
	private String bname;
	private String bauthor;
	private String bsubject;
	private Integer quantity;
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBsubject() {
		return bsubject;
	}
	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", bsubject=" + bsubject
				+ ", quantity=" + quantity + "]";
	}
	
}
