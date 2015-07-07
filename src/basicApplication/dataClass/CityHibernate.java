package basicApplication.dataClass;

import java.util.Date;

public class CityHibernate {
	
	private int cityID;
	private String name;
	private int countryID;
	private Date update;
	
	public CityHibernate()
	{
		//
	}
	
	public CityHibernate(String name)
	{
		setName(name);
	}
	
	public int getcityID()
	{
		return cityID;
	}
	
	public void setcityID(int iD)
	{
		this.cityID = iD;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCountryID()
	{
		return countryID;
	}
	
	public void setCountryID(int countryID)
	{
		this.countryID = countryID;
	}
	
	public Date getUpdate()
	{
		return update;
	}
	
	public void setUpdate(Date update)
	{
		this.update = update;
	}
}
