package com.jmb.services;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmb.component.JsonWrapper;



// TODO: Auto-generated Javadoc
/**
 * The Class JsonUtil.
 */
@Service
public class JsonUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(JsonUtil.class);
	
	
	/**
	 * Object to JSON.
	 *
	 * @param obj the obj
	 * @param pretty the pretty
	 * @return the string
	 */
	/* ****************************************
	 * @PARAMS IN OBJ
	 * @OUT JSON
	 * */
	public String objectToJSON(Object obj, String pretty){
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		
		try {
			
			if(pretty.equalsIgnoreCase("S")) {
				
				jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
				
			} else {

				jsonInString = mapper.writeValueAsString(obj);
				
			}
			
		} catch (JsonProcessingException ex) {
			
			LOG.error("METHOD: objectToJSON");
			LOG.error("ERROR AL DEVOLVER JSON --> : " + ex);
		}
		
		return jsonInString;
	}
	
	
	/**
	 * **********************************.
	 *
	 * @param jsonIn the json in
	 * @return the object
	 */
	public Object jsonToObject (String jsonIn) {
		
		ObjectMapper mapper = new ObjectMapper();
		Object obj = null;
		
		try {
			
			obj = mapper.readValue(jsonIn, Object.class);
			
			
		} catch (IOException ioex){
			LOG.error("METHOD: jsonToObject");
			LOG.error("ERROR al devolver objeto generado de JSON---> : " + ioex.getMessage());
			
		}
		
		
		
		return null;
	}
	
	
	
	/**
	 * *****************.
	 *
	 * @param url the url
	 * @param outView the out view
	 * @param msm the msm
	 * @return the json wrapper
	 */
	//guarda el resultado en JSONWRAPPER cuando OK
	public JsonWrapper keepResult(String url, Object outView, String msm) {
			
			JsonWrapper JSONWrapper = new JsonWrapper();
			JSONWrapper.setResultadoOK(true);
			JSONWrapper.setUrl(url);
			JSONWrapper.setMessage(msm);
			JSONWrapper.setErrorMessage(null);
			JSONWrapper.setErrortrace(null);
			JSONWrapper.setJsonOutView(outView);
			
			return JSONWrapper;
			
		}
		
		
			/**
			 * Keep result.
			 *
			 * @param url the url
			 * @param outView the out view
			 * @param ex the ex
			 * @param msm the msm
			 * @return the json wrapper
			 */
			//guarda el resultado en JSONWRAPPER cuando KO
		public JsonWrapper keepResult(String url, Object outView, Exception ex,String msm) {
			
			JsonWrapper JSONWrapper = new JsonWrapper();
			JSONWrapper.setResultadoOK(false);
			JSONWrapper.setUrl(url);
			JSONWrapper.setMessage(msm);
			JSONWrapper.setErrorMessage(ex.getMessage());
			JSONWrapper.setErrortrace(ex.getStackTrace());
			JSONWrapper.setJsonOutView(outView);
			
			return JSONWrapper;
			
		}
	
	
}
