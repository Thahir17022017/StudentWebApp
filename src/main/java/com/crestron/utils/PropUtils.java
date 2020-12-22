package com.crestron.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import com.crestron.constants.Constants;



public class PropUtils {
		
		private static Properties readProps = new Properties();;

		private static final Logger logger = Logger.getLogger(PropUtils.class.getName());
				
		static {		
		    InputStream fis = PropUtils.class.getResourceAsStream(Constants.DB_PROPERTIES_FILE);
			try {
				readProps.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		public static String readProp(String name)
		{
			return readProps.getProperty(name);
		}
		
}
