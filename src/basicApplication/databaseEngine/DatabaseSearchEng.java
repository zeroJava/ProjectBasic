package basicApplication.databaseEngine;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import basicApplication.dataClass.ActorHibernateBasic;

public class DatabaseSearchEng {
	
	public ActorHibernateBasic retrieveAllDataUsingID(Session session, int ID)
	{
		//Query query = session.getNamedQuery("findAllByID").setInteger("ID", ID);
		Transaction transaction = session.beginTransaction();
		ActorHibernateBasic allUserDetails = (ActorHibernateBasic) session.get(ActorHibernateBasic.class, ID);
		transaction.commit();
		return allUserDetails;
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
}
