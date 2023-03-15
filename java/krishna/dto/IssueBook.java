package krishna.dto;

import java.io.Serializable;

public class IssueBook implements Serializable{

	private String issuedate;
	private String duedate;
	private String bid;
	private Integer sid;
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "IssueBook [issuedate=" + issuedate + ", duedate=" + duedate + ", bid=" + bid + ", sid=" + sid + "]";
	}
	
	
}
