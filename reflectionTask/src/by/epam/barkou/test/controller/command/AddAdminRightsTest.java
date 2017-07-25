package by.epam.barkou.test.controller.command;

import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.test.controller.TestBase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class AddAdminRightsTest extends TestBase {



	@DataProvider
	public Object[][] smokeDp() {
		return new Object[][] {
			
				// user role
				new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },	
				new Object[] { "add_admin_rights&2", "You have no rights to perform this operation" },
				new Object[] { "sign_out&", "User has been signed out" },
				
				// successful update
				new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },	
				new Object[] { "add_admin_rights&2", "User rights are updated successfully" },
				
				// empty params
				new Object[] { "add_admin_rights&", "Not able to add admin rights, you haven't specified user" },
				new Object[] { "sign_out&", "User has been signed out" },
				
				// without signIn
				new Object[] { "add_admin_rights&1", "You have no rights to perform this operation" },	
				
				// use new rights
				new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },	
				new Object[] { "add_admin_rights&1", "User rights are updated successfully" },
		};
	}



	@Test(dataProvider = "smokeDp")
	public void smokeTest(String request, String response) {

		Controller controller = new Controller();
		Assert.assertEquals(controller.executeTask(request), response);

	}
	

}
