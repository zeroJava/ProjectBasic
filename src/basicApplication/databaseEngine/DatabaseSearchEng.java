package basicApplication.databaseEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import basicApplication.dataClass.ActorHibernateBasic;

public class DatabaseSearchEng {
	
	public static List<?> retrieveAllActors(Session session)
	{
		Query query = session.getNamedQuery("findAllActors");
		return query.list();
	}
	
	public ActorHibernateBasic retrieveAllActorsWithID(Session session, int ID, String empty)
	{
		//Query query = session.getNamedQuery("findAllByID").setInteger("ID", ID);
		Transaction transaction = session.beginTransaction();
		ActorHibernateBasic allUserDetails = (ActorHibernateBasic) session.get(ActorHibernateBasic.class, ID);
		transaction.commit();
		return allUserDetails;
	}
	
	public static List<?> retrieveAllActorsWithID(Session session, int ID)
	{
		Query query = session.getNamedQuery("findAllByID").setInteger("ID", ID);
		return query.list();
	}

	public static List<?> retrieveAllActorWithFirstName(Session session, String firstName)
	{
		Query query = session.getNamedQuery("getAllUsingFirstName").setString("firstName", firstName);
		return query.list();
	}
	
	public static List<?> retrieveAllActorsWithLastName(Session session, String lastName)
	{
		Query query = session.getNamedQuery("getAllUsingLastName").setString("lastName", lastName);
		return query.list();
	}
	
	/* ------------------------------------- |returns object multi array of each representing a variable| ----------------------------------------------------- */
	
	public static List<?> retrieveAllActorsObjetArray(Session session)
	{
		Query query = session.createQuery("select ID, firstName, lastName from ActorHibernateBasic");
		return query.list();
	}
		
	public static List<?> retrieveAllActorsWithIDObjectArray(Session session, int ID)
	{
		Query query = session.createQuery("select ID, firstName, lastName from ActorHibernateBasic ac where ac.ID = :ID").setInteger("ID", ID);
		return query.list();
	}

	public static List<?> retrieveAllActorWithFirstNameObjectArray(Session session, String firstName)
	{
		Query query = session.createQuery("select ID, firstName, lastName from ActorHibernateBasic ac where ac.firstName = :firstName").setString("firstName", firstName);
		return query.list();
	}
	
	public static List<?> retrieveAllActorsWithLastNameObjectArray(Session session, String lastName)
	{
		Query query = session.createQuery("select ID, firstName, lastName from ActorHibernateBasic ac where ac.lastName = :lastName").setString("lastName", lastName);
		return query.list();
	}
}
