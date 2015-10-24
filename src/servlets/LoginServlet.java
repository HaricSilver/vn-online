package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Account;
import dao.AccountDao;
import dao.JournalistDao;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		ArrayList<String> error = new ArrayList<>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// if user name and password is null
		if (username.equals("") || password.equals("")) {
			error.add("Username is required");
			error.add("Password is required");

			request.setAttribute("error", error);
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("login").forward(request, response);
		} else {
			// verify account
			Account account = AccountDao.find(username, password);

			if (account.getId() != 0) {
				HttpSession session = request.getSession();
				session.setAttribute("account", account);
				session.setAttribute("journalist", JournalistDao.find(account));

				response.sendRedirect("journalist/dashboard");
			} else {
				error.add("Username or password is invalid");

				request.setAttribute("error", error);
				request.setAttribute("username", username);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login").forward(request, response);
			}
		}
	}

}
