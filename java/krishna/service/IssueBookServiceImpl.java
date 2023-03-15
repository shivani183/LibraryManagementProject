package krishna.service;


import krishna.dao.IRegLibrarianDao;
import krishna.dao.IssueBookDao;
import krishna.daofactory.BookDaoFactory;
import krishna.daofactory.issueBookDaoFactory;
import krishna.daofactory.regLibrarianDaoFactory;
import krishna.dto.IssueBook;
import krishna.dto.RegisterLibrarian;

//service layer logic
public class IssueBookServiceImpl implements IssueBookService {

	private IssueBookDao issueBookDao;

	
	@Override
	public String addIssueBook(IssueBook issueBook) {
		issueBookDao=issueBookDaoFactory.getIssueBookDao();
		return issueBookDao.addIssueBook(issueBook);
	}
	


}
