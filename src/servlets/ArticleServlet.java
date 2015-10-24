package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Account;
import beans.Article;
import beans.Category;
import beans.Journalist;
import dao.ArticleDao;
import dao.CategoryDao;
import dao.JournalistDao;

@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticleServlet() {
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

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "create":
				String title = request.getParameter("title");
				String alias = request.getParameter("alias");
				String shortContent = request.getParameter("shortContent");
				String content = request.getParameter("content");
				String categoryId = request.getParameter("categoryId");

				Category category = CategoryDao.find(categoryId);
				Journalist journalist = (Journalist) request.getSession().getAttribute("journalist");

				Article article = new Article(journalist, category, title, alias, shortContent, content);
				boolean result = ArticleDao.save(article);
				
				break;
			default:
				break;
			}
		}
	}

}
