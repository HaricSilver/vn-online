package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Category;
import dao.CategoryDao;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> list = CategoryDao.getList();
		System.out.println(new Gson().toJson(list));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// check author before
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "create":
				String name = request.getParameter("name");
				
				Category category = new Category();
				category.setName(name);
				
				boolean result = CategoryDao.save(category);
				
				break;
			case "list":
				List<Category> list = CategoryDao.getList();
				System.out.println(new Gson().toJson(list));
				
				break;
			default:
				break;
			}
		}
	}

}