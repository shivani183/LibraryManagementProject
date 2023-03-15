
package krishna.daofactory;

import krishna.dao.IssueBookDao;
import krishna.dao.IssueBookDaoImpl;

public class issueBookDaoFactory {

	private issueBookDaoFactory() {}

	private static IssueBookDao issueBookDao = null;

	public static IssueBookDao getIssueBookDao() {
		if (issueBookDao == null) {
			issueBookDao = new IssueBookDaoImpl();
		}
		return issueBookDao;
	}
}
