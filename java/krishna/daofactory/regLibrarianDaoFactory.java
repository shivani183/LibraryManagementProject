
package krishna.daofactory;

import krishna.dao.IRegLibrarianDao;
import krishna.dao.RegLibrarianDaoImpl;

public class regLibrarianDaoFactory {

	private regLibrarianDaoFactory() {}

	private static IRegLibrarianDao registerLibrarianDao = null;

	public static IRegLibrarianDao getRegLibrarianDao() {
		if (registerLibrarianDao == null) {
			registerLibrarianDao = new RegLibrarianDaoImpl();
		}
		return registerLibrarianDao;
	}
}
