package ejagruti.finsys.config;

import ejagruti.finsys.config.TestBase;

public class ConfigFileReader extends TestBase {

	public String getReportConfigPath()
	{
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException("Config Path not specified in configeration.propertirs file for the key: reportConfigPath");
	}
	
}