package testCasesBasic;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import basicApplication.databaseEngine.HibernateUtilitiess;

public class UnitTestCase {

	Transaction transaction = null;
	
	@Test
	public void getData()
	{	
		Session session = HibernateUtilitiess.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		System.out.println(session.createQuery("SELECT ID FROM ActorHibernateBasic WHERE ID=1"));
		transaction.commit();
		session.close();
	}
}
