package krishna.servicefactory;

import krishna.service.BookServiceImpl;
import krishna.service.IBookService;

public class BookServiceFactory {

	private BookServiceFactory() {
	}
	private static IBookService bookService = null;

	public static IBookService getBookService() {

		if (bookService == null) {
			bookService = new BookServiceImpl();
		}
		return bookService;
	}

}
