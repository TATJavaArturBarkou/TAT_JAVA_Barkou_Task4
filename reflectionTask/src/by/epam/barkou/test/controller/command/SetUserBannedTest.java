package by.epam.barkou.test.controller.command;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.test.controller.TestBase;

public class SetUserBannedTest extends TestBase {


	@DataProvider
	public Object[][] smokeDp() {
		return new Object[][] {
			

			// admin role
			new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },
			new Object[] { "set_user_banned&1&1", "User is updated successfully" },
			new Object[] { "sign_out&", "User has been signed out" },

			// user role
			new Object[] { "sign_up&barkou@mail.ru&password", "User is registred successfully" },
			new Object[] { "sign_in&barkou@mail.ru&password", "User has been signed into system" },

			new Object[] { "set_user_banned&1&1", "You have no rights to perform this operation" },
			new Object[] { "sign_out&", "User has been signed out" },

			// guest role
			new Object[] { "set_user_banned&1&1", "You have no rights to perform this operation" },
			
			//not exists user
			new Object[] { "sign_in&admin@gmail.com&admin", "User has been signed into system" },
			new Object[] { "set_user_banned&5&1", "User isn't exists" },
		};
	}



	@Test(dataProvider = "smokeDp")
	public void smokeTest(String request, String response) {

		Controller controller = new Controller();
		Assert.assertEquals(controller.executeTask(request), response);

	}
	

}
