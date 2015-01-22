package testCasesBasic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import basicApplication.dataClass.ActorHibernateBasic;
import basicApplication.databaseEngine.HibernateUtilitiess;

public class UnitTestCase {

	Transaction transaction = null;
	
	@Test
	public void getData()
	{	
		Session session = HibernateUtilitiess.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		List<Integer> list = session.createQuery("SELECT ID FROM ActorHibernateBasic").list();
		for(Integer aBasic : list)
		{
			System.out.println(aBasic.toString());
		}	
		transaction.commit();
		session.close();
		
		session = HibernateUtilitiess.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		ActorHibernateBasic lancel = new ActorHibernateBasic("JONNY", "BLAZZE");
		session.save(lancel);
		transaction.commit();
		session.close();
		
		session = HibernateUtilitiess.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Query query = session.getNamedQuery("findStockByStockCode").setString("lastName", "MAHOGANY");
		System.out.println(query.uniqueResult());
		transaction.commit();
		session.close();
	}
}
