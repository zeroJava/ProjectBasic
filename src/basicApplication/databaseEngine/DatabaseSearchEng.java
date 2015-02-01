package basicApplication.databaseEngine;

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
		Query query = session.createQuery("select ID, firstName from ActorHibernateBasic ac where ac.lastName = :lastName").setString("lastName", lastName);
		return (ActorHibernateBasic) query;
	}
}
