package testCasesBasic.databasesEngineTest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import basicApplication.databaseEngine.HibernateUtilitiess;

public class DatabaseSearchEngineTest {

	//private SessionFactory factory;
	private Session session;

	//@Before
	/*public void setup()
	{
		try
		{
			factory = HibernateUtilitiess.getSessionFactory();
		} 
		catch (HibernateException ex)
		{
			System.out.println("factory wasnt made wasnt made");
			System.exit(0);
		}
	}*/
	
	@Test
	public void testUtilities()
	{
		try
		{
			SessionFactory factory = HibernateUtilitiess.getSessionFactory();
		} 
		catch (HibernateException ex)
		{
			System.out.println("factory wasnt made wasnt made");
			System.exit(0);
		}
	}
	
	//@Test
	public void test()
	{
		session = HibernateUtilitiess.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("findIDByLastName").setString("lastName", "MAHOGANY");
		System.out.println(query.uniqueResult());
		transaction.commit();
		session.close();
	}
}
