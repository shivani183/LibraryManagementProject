package krishna.dto;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer sid;
	private String sname;
	private String scourse;
	private Long sphone;
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScourse() {
		return scourse;
	}
	public void setScourse(String scourse) {
		this.scourse = scourse;
	}
	
	public Long getSphone() {
		return sphone;
	}
	public void setSphone(Long sphone) {
		this.sphone = sphone;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", scourse=" + scourse + ", sphone=" + sphone + "]";
	}

	

}
