package krishna.servicefactory;

import krishna.service.IStudentService;
import krishna.service.StudentServiceImpl;

public class StudentServiceFactory {

	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
