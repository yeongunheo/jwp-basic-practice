package next.controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
	private Map<String, Controller> mappings = new HashMap<String, Controller>();
	
	void initMapping() {
		mappings.put("/users/create", new CreateUserController());
		mappings.put("/users/form", new ForwardController("/user/form.jsp"));
		mappings.put("", new HomeController());
		mappings.put("/users", new ListUserController());
		mappings.put("/users/login", new LoginController());
		mappings.put("/users/loginForm", new ForwardController("/user/login.jsp"));
		mappings.put("/users/logout", new LogoutController());
		mappings.put("/users/profile", new ProfileController());
		mappings.put("/users/update", new UpdateUserController());
		mappings.put("/users/updateForm", new UpdateUserFormController());
	}
	
	public Controller findController(String url) {
		return mappings.get(url);
	}
	
	void put(String url, Controller controller) {
		mappings.put(url, controller);
	}
}
