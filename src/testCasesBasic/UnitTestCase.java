package testCasesBasic;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
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
		System.out.println(session.createQuery("SELECT ID FROM ActorHibernateBasic WHERE ID=1"));
		transaction.commit();
		session.close();
	}
}
