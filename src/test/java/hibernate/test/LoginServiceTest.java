package hibernate.test;

import login.*;

public class LoginServiceTest {
	public static void main(String args[]) {
		LoginService LS=new LoginService();
		int result=LS.login("pro", "prabhat");
		System.out.println("working "+result);
	}
}
