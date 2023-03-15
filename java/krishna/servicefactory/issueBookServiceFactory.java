package krishna.servicefactory;

import krishna.service.IRegLibrarianService;
import krishna.service.IssueBookService;
import krishna.service.IssueBookServiceImpl;
import krishna.service.RegLibrarianServiceImpl;

public class issueBookServiceFactory {

	private issueBookServiceFactory() {
	}
	
	private static IssueBookService issueBookService = null;

	public static IssueBookService getIssueBookService() {

		if (issueBookService == null) {
			issueBookService = new IssueBookServiceImpl();
		}
		return issueBookService;
	}

}
