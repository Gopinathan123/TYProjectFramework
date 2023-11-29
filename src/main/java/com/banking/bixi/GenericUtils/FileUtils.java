package com.banking.bixi.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileUtils {
	/**
	 * This method is used for read the data from Property File
	 * @author GopiNathan S 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key)  throws Throwable {
		Properties p = new Properties();
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		p.load(fis);
		
		String value = p.getProperty(key);
		
		return value;
	}
	/**
	 * This Method is used to write the data to the property file
	 * @param key
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataToPropertyFile(String key, String value) throws Throwable {
		Properties p = new Properties();
		FileInputStream fis=new FileInputStream(IPathConstants.FilePath);
		p.load(fis);
		FileOutputStream fos=new FileOutputStream(IPathConstants.FilePath);
		p.store(fos, "");
		p.setProperty(key, value);
	
	}

}
