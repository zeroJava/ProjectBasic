package basicApplication.databaseEngine;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import basicApplication.dataClass.ActorHibernateBasic;

public class DatabaseSearchEng {
	
	public ActorHibernateBasic retrieveAllDataUsingID(Session session, int ID)
	{
		//Query query = session.createQuery("select firstName, lastName from ActorHibernateBasic ac where ac.ID = :lastID").setInteger("ID", ID);
		Query query = session.getNamedQuery("findAllByID").setInteger("ID", ID);
		return (ActorHibernateBasic) query;
	}

	public ActorHibernateBasic retrieveAllDataUsingFirstName(Session session, String firstName)
	{
		Query query = session.createQuery("select ID, lastName from ActorHibernateBasic ac where ac.firstName = :firstName").setString("firstName", firstName);
		return (ActorHibernateBasic) query;
	}
	
	public ActorHibernateBasic retrieveAllDataUsingLastName(Session session, String lastName)
	{
		//Query query = session.createSQLQuery("select ID, lastName from ActorHibernateBasic ac where ac.lastName = :lastName").addScalar("ac.ID", new IntegerType()).setString("lastName", lastName);
		Query queries = session.createQuery("select ID, firstName from ActorHibernateBasic ac where ac.lastName = :lastName").setString("lastName", lastName);
		System.out.println("Inside the loop (retrieveAllDataUsingLastName)");
		ArrayList<ActorHibernateBasic> list = (ArrayList<ActorHibernateBasic>) queries.list();
		
		if(!list.isEmpty())
		{
			System.out.println("the is not empty");
			System.out.println(list.size());
		}
		
		System.out.println("past stage 1");
		ActorHibernateBasic[] basics = list.toArray(new ActorHibernateBasic[list.size()]);
		System.out.println("past stage 2");
		return basics[0];
	}
}
