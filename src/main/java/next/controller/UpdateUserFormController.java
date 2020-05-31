package next.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

@WebServlet("/users/updateForm")
public class UpdateUserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = (String)req.getParameter("userId");
		
		HttpSession session = req.getSession();
		Object value = session.getAttribute("user");
		if (value != null) {
			User user = (User)value;
			User param_user = DataBase.findUserById(userId);
			if (param_user != null && user.equals(param_user)) {
				RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
		        rd.forward(req, resp);
			} else {
				throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
			}
		} else {
			throw new IllegalStateException("다른 사용자의 정보를 수정할 수 없습니다.");
		}
	}
}
