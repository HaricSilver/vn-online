package dao;

import org.hibernate.Session;

import beans.Article;
import util.HibernateUtil;

public class ArticleDao {

	public static boolean save(Article article) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(article);

		session.getTransaction().commit();
		return article.getId() != 0;
	}

}
