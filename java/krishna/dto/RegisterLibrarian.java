package krishna.dto;

import java.io.Serializable;

public class RegisterLibrarian implements Serializable{

	private String lname;
	private String lusername;
	private String lpassword;
	
	@Override
	public String toString() {
		return "RegisterLibrarian [lname=" + lname + ", lusername=" + lusername + ", lpassword="
				+ lpassword + "]";
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLusername() {
		return lusername;
	}
	public void setLusername(String lusername) {
		this.lusername = lusername;
	}
	public String getLpassword() {
		return lpassword;
	}
	public void setLpassword(String lpassword) {
		this.lpassword = lpassword;
	}
	
	
}
