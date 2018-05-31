package login;

public class RegisterService {
	public String register(String username, String password, String email) {
		String result = "error";
		int checkStatus = new CheckUserExistence().checkUser(username);
		if (checkStatus == 401) {
			System.out.println("User exists");
			return "User Already Exists";
		} else if (checkStatus == 200) {
			int status = new RegisterUserDataAdd().addUserData(username, password, email);
			if (status == 1)
				return "Register Successful";
			else if (status == 0) {
				return "Database error";
			}
		} else {
			return "error";
		}
		return result;
	}
}
