package basicApplication.databaseEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoggingEngine {
	
	public final String location = "C:/Users/Abu/Documents/Programming/Java/ProjectBasic/src/basicApplication/databaseEngine/logs/BasicApplicationLog.txt";
	private File locationOfFile;
	//private BufferedWriter writer;
	
	public LoggingEngine()
	{
		try
		{
			createPathWithFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void createPathWithFile() throws IOException
	{
		locationOfFile = new File(location);
	}
		
	public void writeToFile(String text)
	{
		BufferedWriter writer = null;
		try
		{
			writer = new BufferedWriter(new FileWriter(locationOfFile, true));
			writer.write(text);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(writer != null)
			{
				try
				{
					writer.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}	
		}
	}
}
