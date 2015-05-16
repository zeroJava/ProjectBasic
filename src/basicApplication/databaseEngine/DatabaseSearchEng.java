package basicApplication.databaseEngine;

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

	public ActorHibernateBasic retrieveAllDataUsingFirstName(Session session, String firstName)
	{
		Query query = session.createQuery("select ID, lastName from ActorHibernateBasic ac where ac.firstName = :firstName").setString("firstName", firstName);
		return (ActorHibernateBasic) query;
	}
	
	public ActorHibernateBasic retrieveAllDataUsingLastName(Session session, String lastName)
	{
		return null;
	}
}
