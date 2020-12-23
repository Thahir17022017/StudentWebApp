package com.crestron.constants;

import com.crestron.utils.PropUtils;

public interface Constants {
	
	String DB_PROPERTIES_FILE = "/db.properties";
	
	String DB_CONNECTION_URL = PropUtils.readProp("com.crestron.jdbc.url");
	String DB_CONNECTION_USERNAME = PropUtils.readProp("com.crestron.jdbc.username");
	String DB_CONNECTION_PASSWORD = PropUtils.readProp("com.crestron.jdbc.password");
	String DB_CONNECTION_DRIVER = PropUtils.readProp("com.crestron.jdbc.dbdriver");
	
	
}
