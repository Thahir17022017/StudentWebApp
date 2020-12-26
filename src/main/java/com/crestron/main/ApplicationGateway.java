package com.crestron.main;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.crestron.utils.PropUtils;

@ApplicationPath("/webapi")
public class ApplicationGateway extends Application {
	
	private static final long serialVersionUID = 1L;
	static {
		PropUtils.run();	
	}
	
	

}