package krishna.service;


import krishna.dao.IRegLibrarianDao;

import krishna.daofactory.BookDaoFactory;
import krishna.daofactory.regLibrarianDaoFactory;
import krishna.dto.RegisterLibrarian;

//service layer logic
public class RegLibrarianServiceImpl implements IRegLibrarianService {

	private IRegLibrarianDao regLibrarianDao;

	@Override
	public String registerLibrarian(RegisterLibrarian registerLibrarian) {

		regLibrarianDao=regLibrarianDaoFactory.getRegLibrarianDao();
		return regLibrarianDao.registerLibrarian(registerLibrarian);
	}
	


}
