package by.epam.barkou.main;

import by.epam.barkou.controller.Controller;

public class Main {

	public static void main(String[] args) {

/*		String request = "sign_up&barkou@mail.ru2&password2";
		Controller controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));*/
		
		String request = "sign_in&admin@gmail.com&admin";
		Controller controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));
		
	
		 request = "get_user&1";
		 controller = new Controller();
		System.out.println("Response is: " + controller.executeTask(request));

	}
	
}
