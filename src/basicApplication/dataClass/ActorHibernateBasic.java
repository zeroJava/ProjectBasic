package basicApplication.dataClass;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActorHibernateBasic {
	
	@Id
	private int ID; // this private, but hibernate can still access the this variable directly.
	private String lastName;
	private String firstName;
	private Date date;
	
	/* this is a persistence class, which means that this class a class representation of table in the 
	   database. */
	/* So when we make data, we could create an instance of this class, and will automatically be stored to 
	   the table (database).*/
	/* This why this called a persistence class, because data will still exist, even after that object is
	   executing. */
	
	public ActorHibernateBasic()// constructor require to public for visibility for hibernate proxies
	{
		/* we need an empty constructor to make hibernate happy, and style the class is written is in java-bean 
		   style with constructors, setters and getter, which is the recommended style */
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

	@Override
	public String toString() 
	{
		return (ID + " " + firstName + " " + lastName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	public boolean equals(ActorHibernateBasic basic) 
	{
		return ((this.ID == basic.ID) && (this.firstName.equals(basic.firstName)) && 
				(this.lastName.equals(basic.lastName)) && (this.date.equals(basic.date)) );
	}
	
	
}
