package next.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import next.model.User;

@WebServlet("/users/update")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User(
				req.getParameter("userId"),
				req.getParameter("password"),
				req.getParameter("name"),
				req.getParameter("email"));
		DataBase.updateUser(user);
		resp.sendRedirect("/users/list");
	}
}
