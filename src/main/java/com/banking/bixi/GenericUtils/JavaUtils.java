package com.banking.bixi.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	/**
	 * This method is used to get the random number
	 * @author GopiNathan S
	 * 
	 * @return
	 */
	public int getRandomNo(int randomNo) {
		Random ran=new Random();
		int random = ran.nextInt(randomNo);
		return random;
	}
	/**
	 * This Method is used to get the System Date
	 * @author GopiNathan S
	 * @return
	 */
	public String systemDate() {
		Date date=new Date();
		String systemDate = date.toString();
		return systemDate;
	}
	/**
	 * This Method is used to get the Date in the given format
	 * @author GopiNathan S
	 * @return
	 */
	
	public String systemDateInFormat() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		Date date = new Date();
		String systemDateInFormate = sdf.format(date);
		return systemDateInFormate;
		
	}

}
