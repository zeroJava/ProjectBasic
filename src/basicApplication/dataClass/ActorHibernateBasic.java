package basicApplication.dataClass;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActorHibernateBasic {
	
	@Id
	private int ID;
	private String lastName;
	private String firstName;
	private Date date;
	
	// this is a persistence class, which means that this class a class representation of table in the 
	// database.
	// So when we make data, we could create an instance of this class, and will automatically be stored to 
	// the table (database).
	// This why this called a persistence class, because data will still exist, even after that object is
	// executing.
	
	public ActorHibernateBasic()
	{
		
	}
	
	public ActorHibernateBasic(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ActorHibernateBasic(int ID, String firstName, String lastName)
	{
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public ActorHibernateBasic(int ID, String firstName, String lastName, Date date)
	{
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
	}
	
	public int getID() 
	{
		return ID;
	}
	
	public void setID(int iD) 
	{
		ID = iD;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
