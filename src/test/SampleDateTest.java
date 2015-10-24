package test;

import org.hibernate.Session;

import beans.Account;
import beans.Journalist;
import util.HibernateUtil;

public class SampleDateTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("dd/MM/yyyy");
		// Date d;
		// Calendar calendar = null;
		// try {
		// d = simpleDateFormat.parse("25/5/2014");
		// calendar = Calendar.getInstance();
		// calendar.setTime(d);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }

		Account account1 = new Account();
		account1.setName("admin");
		account1.setPassword("12345678");
		account1.setType(0);
		session.save(account1);

		Journalist journalist1 = new Journalist();
		journalist1.setAccount(account1);
		journalist1.setAddress("Tokyo, New York, Wasington, US");
		journalist1.setEmail("admin@vnonline.com");
		journalist1.setFirstName("Admin");
		journalist1.setLastName("");
		journalist1.setPhone("0123456789");
		session.save(journalist1);

		Account account2 = new Account();
		account2.setName("haricsilver");
		account2.setPassword("12345678");
		account2.setType(1);
		session.save(account2);

		Journalist journalist2 = new Journalist();
		journalist2.setAccount(account2);
		journalist2.setAddress("Tokyo, New York, Wasington, US");
		journalist2.setEmail("anonymous@vnonline.com");
		journalist2.setFirstName("Silver");
		journalist2.setLastName("Haric");
		journalist2.setPhone("0123456789");
		session.save(journalist2);

		session.getTransaction().commit();
	}

}
