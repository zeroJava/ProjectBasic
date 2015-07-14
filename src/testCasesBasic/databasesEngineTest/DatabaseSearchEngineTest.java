package testCasesBasic.databasesEngineTest;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import basicApplication.dataClass.ActorHibernateBasic;
import basicApplication.databaseEngine.DatabaseSearchEng;
import basicApplication.utilitiesEngine.HibernateUtilitiess;

public class DatabaseSearchEngineTest {

	private SessionFactory factory;
	private Session session;

	@Before
	public void setup()
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
	}
		
	@Test
	public void test()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.getNamedQuery("findIDByLastName").setString("lastName", "MAHOGANY");
		System.out.println(query.uniqueResult());
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testGetAllDataUsingLastame()
	{
		session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<ActorHibernateBasic> list = DatabaseSearchEng.retrieveAllDataUsingLastName(session, "GUINESS");
		int index = 0;
		while(!list.isEmpty())
		{
			ActorHibernateBasic actor = list.get(index);
			System.out.println(actor);
			index++;
		}
		transaction.commit();
		session.close();
	}
}
