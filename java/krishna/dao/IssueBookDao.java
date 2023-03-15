package krishna.dao;

import java.sql.ResultSet;

import krishna.dto.IssueBook;

public interface IssueBookDao {

	public String addIssueBook(IssueBook issueBook);

	ResultSet checkdue(Integer sid);
	
	public String returnBook(Integer sid, String bid);

}

