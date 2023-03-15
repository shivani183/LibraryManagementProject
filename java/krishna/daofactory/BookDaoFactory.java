
package krishna.daofactory;

import krishna.dao.BookDaoImpl;
import krishna.dao.IBookDao;

public class BookDaoFactory {

	private BookDaoFactory() {}

	private static IBookDao bookDao = null;

	public static IBookDao getBookDao() {
		if (bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
}
