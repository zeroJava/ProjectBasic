package testCasesBasic.databasesEngineTest;

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

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction transaction = null;

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
	public void testRertiveAllHibernateItems()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ActorHibernateBasic> list = (List<ActorHibernateBasic>) DatabaseSearchEng.retrieveAllActors(session);
			for (ActorHibernateBasic object : list)
			{
				System.out.println(object);
			}
			transaction.commit();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testRertiveHibernateItemsUsingID()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ActorHibernateBasic> list = (List<ActorHibernateBasic>) DatabaseSearchEng.retrieveAllActorsWithID(session, 150);
			for (ActorHibernateBasic object : list)
			{
				System.out.println(object);
			}
			transaction.commit();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testRertiveHibernateItemsUsingFirstname()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ActorHibernateBasic> list = (List<ActorHibernateBasic>) DatabaseSearchEng.retrieveAllActorWithFirstName(session, "ED");
			for (ActorHibernateBasic object : list)
			{
				System.out.println(object);
			}
			transaction.commit();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testRertiveHibernateItemsUsingLastname()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<ActorHibernateBasic> list = (List<ActorHibernateBasic>) DatabaseSearchEng.retrieveAllActorsWithLastName(session, "CHASE");
			for (ActorHibernateBasic object : list)
			{
				System.out.println(object);
			}
			transaction.commit();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testGettingEveythingInObjectArray()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorsWithIDObjectArray(session, 150);
			for (Object[] object : list)
			{
				System.out.println(object[0] + " " + object[1] + " "+ object[2]);
			}
			transaction.commit();
		}
		catch(HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}

	@Test
	public void test()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("findIDByLastName").setString("lastName", "MAHOGANY");
			System.out.println(query.uniqueResult());
			transaction.commit();
		}
		catch (HibernateException he)
		{
			he.getMessage();
		}
		finally
		{
			session.close();
		}
	}

	@Test
	public void testGetAllDataUsingLastameInObjectArray()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorsWithLastNameObjectArray(session, "GUINESS");
			for (Object[] object : list)
			{
				System.out.println(object[0] + " " + object[1] + " "+ object[2]);
			}
			transaction.commit();
		}
		catch (HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	@Test
	public void testGetAllDataUsingFirstNameObjectArray()
	{
		try
		{
			session = factory.openSession();
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) DatabaseSearchEng.retrieveAllActorWithFirstNameObjectArray(session, "ED");
			for (Object[] object : list)
			{
				System.out.println(object[0] + " " + object[1] + " "+ object[2]);
			}
			transaction.commit();
		}
		catch (HibernateException he)
		{
			System.out.println(he.getMessage());
		}
		finally
		{
			session.close();
		}
	}
}
