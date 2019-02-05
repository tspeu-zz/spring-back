package com.jmb.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("ejemploComponent")
public class EjemploComponent {
	
	private static final Log LOG = LogFactory.getLog(EjemploComponent.class);
	
	public void saluda() {
		LOG.info("## ||       #|            ##HH||       \r\n" + 
				"##  ||  #H|  #|  ##|        #|   ## H| \r\n" + 
				"##HH|| ## H| #|    H|       #|   ## H| \r\n" + 
				"##  || ## H| #|  ##H|       #|   ## H| \r\n" + 
				"##  ||  #H|  #H| ##HH|      #|    #HH| ");
		
	}

}
