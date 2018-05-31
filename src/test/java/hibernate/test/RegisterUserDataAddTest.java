package hibernate.test;

import login.RegisterUserDataAdd;

public class RegisterUserDataAddTest {
	public static void main(String ags[]) {
		RegisterUserDataAdd RUDA = new RegisterUserDataAdd();
		int i = RUDA.addUserData("1111", "1111", "1111");
		System.out.println("Result "+i);
	}
}
