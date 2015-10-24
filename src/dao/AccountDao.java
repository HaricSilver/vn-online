package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Account;
import util.HibernateUtil;

public class AccountDao {

	public static Account find(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Account account = new Account();

		Query query = session.createQuery("select a.id from Account a where a.name=:aname and a.password=:apass");
		query.setParameter("aname", username);
		query.setParameter("apass", password);

		@SuppressWarnings("unchecked")
		List<Long> list = query.list();

		if (!list.isEmpty() && list.size() == 1) {
			session.load(account, list.get(0));
		}

		session.getTransaction().commit();;
		return account;
	}

}
