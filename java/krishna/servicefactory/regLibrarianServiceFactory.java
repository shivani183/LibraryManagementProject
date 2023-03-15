package krishna.servicefactory;

import krishna.service.IRegLibrarianService;
import krishna.service.RegLibrarianServiceImpl;

public class regLibrarianServiceFactory {

	private regLibrarianServiceFactory() {
	}
	
	private static IRegLibrarianService librarianService = null;

	public static IRegLibrarianService getRegLibrarianService() {

		if (librarianService == null) {
			librarianService = new RegLibrarianServiceImpl();
		}
		return librarianService;
	}

}
