package testCasesBasic.loggingEngine;

import org.junit.Before;
import org.junit.Test;

import basicApplication.databaseEngine.LoggingEngine;

public class LogginEngineTest {
	
	private LoggingEngine logging;
	
	@Before
	public void startup()
	{
		logging = new LoggingEngine();
	}

	//@Test
	public void test()
	{
		logging = new LoggingEngine();
	}
	
	@Test
	public void writingToLogFile()
	{
		logging.writeToFile("hello");
	}
	
	@Test
	public void writingToLogFile2()
	{
		logging.writeToFile("second type running");
	}
}
