package by.epam.barkou.test.controller.command;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.test.controller.TestBase;

public class OrderBookTest extends TestBase {

	@DataProvider
	public Object[][] smokeDp() {
		return new Object[][] {

				// admin role
				new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },
				new Object[] { "add_book&Alice in Wonderland&1", "Book has been added successfully" },

				new Object[] { "order_book&1", "Book has been ordered" },
				new Object[] { "sign_out&", "User has been signed out" },

				// user role
				new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },

				new Object[] { "order_book&1", "Book has been ordered" },
				new Object[] { "sign_out&", "User has been signed out" },

				// guest role
				new Object[] { "order_book&1", "You have no rights to perform this operation" }, 
				
				
				//not exists book
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },
				new Object[] { "order_book&2", "Book not exists" },
			
		};
				
				
	}

	@Test(dataProvider = "smokeDp")
	public void smokeTest(String request, String response) {

		Controller controller = new Controller();
		Assert.assertEquals(controller.executeTask(request), response);

	}

}
