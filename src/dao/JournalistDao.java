package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Account;
import beans.Journalist;
import util.HibernateUtil;

public class JournalistDao {

	public static Journalist find(Account account) {
		if (account == null)
			return null;
		else {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			Journalist journalist = new Journalist();

			Query query = session.createQuery("select j.id from Journalist j where j.account.id=:aid");
			query.setParameter("aid", account.getId());

			@SuppressWarnings("unchecked")
			List<Long> list = query.list();

			if (!list.isEmpty() && list.size() == 1) {
				session.load(journalist, list.get(0));
			}

			session.getTransaction().commit();
			return journalist;
		}
	}

}
