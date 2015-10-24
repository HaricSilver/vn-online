package dao;

import java.util.List;

import org.hibernate.Session;

import beans.Category;
import util.HibernateUtil;

public class CategoryDao {

	public static Category find(String categoryId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Category category = new Category();
		session.load(category, categoryId);

		session.getTransaction().commit();
		return category;
	}

	public static boolean save(Category category) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		session.save(category);

		session.getTransaction().commit();
		return category.getId() != 0;
	}

	public static List<Category> getList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Category> list = session.createCriteria(Category.class).list();

		session.getTransaction().commit();
		return list;
	}

}
