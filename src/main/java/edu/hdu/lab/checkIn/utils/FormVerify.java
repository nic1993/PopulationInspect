package edu.hdu.lab.checkIn.utils;

public class FormVerify{
	
	public static String TextFilter(String strInput)
	{
		String strTemp = strInput.trim();
		
		/**
		 * TODO Special Character Filter < > % ...
		 */
		return strTemp;
	}
}
