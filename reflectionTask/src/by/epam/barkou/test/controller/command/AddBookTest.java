package by.epam.barkou.test.controller.command;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.test.controller.TestBase;

public class AddBookTest extends TestBase {



	@DataProvider
	public Object[][] smokeDp() {
		return new Object[][] {
			
				// users role
				new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },	
				
				new Object[] { "add_book&Alice in Wonderland&1", "You have no rights to perform this operation" },
				new Object[] { "sign_out&", "User has been signed out" },
				
				// successful update			
				new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },					
				new Object[] { "add_book&Alice in Wonderland&1", "Book has been added successfully" },
			
				// get added book
				new Object[] { "get_all_available_books&", "Alice in Wonderland&" },
				
				// empty params					
				new Object[] { "add_book&", "Not able to perform operation, you haven't specified necessary parameters" },
				new Object[] { "sign_out&", "User has been signed out" },
				
				// without signIn
				new Object[] { "add_book&Alice in Wonderland&1", "You have no rights to perform this operation" },
				
				// same book name
				new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },		
				new Object[] { "add_book&Alice in Wonderland&1", "Unable to add book" },
		};
	}



	@Test(dataProvider = "smokeDp")
	public void smokeTest(String request, String response) {

		Controller controller = new Controller();
		Assert.assertEquals(controller.executeTask(request), response);

	}
	

}
