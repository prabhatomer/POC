package hibernate.test;

import login.CheckUserExistence;

public class CheckUserExistenceTest {
	public static void main(String args[]) {
		CheckUserExistence CUE = new CheckUserExistence();
		int result = CUE.checkUser("pro");
		if (result == 401) {
			System.out.println("User exists");
		} else
			System.out.println("User does not exists");
	}

}
