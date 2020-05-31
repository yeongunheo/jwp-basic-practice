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

@WebServlet("/users/list")
public class ListUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
        	User user = (User)value;
        	String userId = user.getUserId();
        	if (DataBase.findUserById(userId) != null) {
        		req.setAttribute("users", DataBase.findAll());
                RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
                rd.forward(req, resp);		
        	} else {
        		session.removeAttribute("user");
        		resp.sendRedirect("/users/login");
        	}
        } else {
    		session.removeAttribute("user");
    		resp.sendRedirect("/users/login");
    	}
    }
}
