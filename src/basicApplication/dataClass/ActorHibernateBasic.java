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
