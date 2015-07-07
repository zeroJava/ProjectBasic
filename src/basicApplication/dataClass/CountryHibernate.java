package basicApplication.dataClass;

import java.util.HashSet;
import java.util.Set;

public class CountryHibernate {
	
	private int countryID;
	private String countryName;
	private int update;
	
	private Set<String> cities = new HashSet<String>();
	
	public CountryHibernate()
	{
		//
	}
	
	public CountryHibernate(String name)
	{
		this.setCountryName(name);
	}
	
	public int getcountryID()
	{
		return countryID;
	}
	
	public void setcountryID(int iD)
	{
		countryID = iD;
	}

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	public int getUpdate()
	{
		return update;
	}

	public void setUpdate(int update)
	{
		this.update = update;
	}

	public Set<String> getCities()
	{
		return cities;
	}

	public void setCities(Set<String> cities)
	{
		this.cities = cities;
	}
}
