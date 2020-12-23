package com.crestron.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.crestron.constants.Constants;



public class PropUtils {
		
		private static Properties readProps = new Properties();;

		private static final Logger logger = Logger.getLogger(PropUtils.class.getName());
		private static final long serialVersionUID = 1L;
				
		static {		
		    InputStream fis = PropUtils.class.getResourceAsStream(Constants.DB_PROPERTIES_FILE);
			try {
				readProps.load(fis);
				logger.info("db properties are loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					fis.close();
					logger.info("db properties file connection is closed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//Used as a placeholder for loading static block
		public static void run()
		{
			
		}
		
		public static String readProp(String name)
		{
			return readProps.getProperty(name).trim();
		}
		
}
