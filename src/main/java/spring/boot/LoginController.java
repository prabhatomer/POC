package spring.boot;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import login.LoginService;
import login.RegisterService;

@RestController

public class LoginController {
	@POST
	@Produces("text/html")
	@RequestMapping("/login")
	public String login(@FormParam("username") String username, @FormParam("password") String password) {
		Integer result = new LoginService().login(username, password);
		if (result.equals(1)) {
			return "true";
		}
		return "false";

	}

	@POST
	@Produces("text/html")
	@RequestMapping("/register")
	public String register(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("email") String email) {
		String result = new RegisterService().register(username, password, email);
		return result;
	}

}
