package com.jmb.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

								/*sirve para que cada peticion que se haga primero entre por esta clase */
@Component("reqTimeInterceptor")
public class ReqTimeInterceptor extends HandlerInterceptorAdapter{

	private static final Log LOOGER = LogFactory.getLog(ReqTimeInterceptor.class);
	
	
	/*TODO Se ejecuta antes que en tr el comntrollador*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		request.setAttribute("EMPIEZA_TIEMPO", System.currentTimeMillis());
		return true;
	}

	
	//TODO antes de soltar la vista en el navegador
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		long startTime = (long) request.getAttribute("EMPIEZA_TIEMPO");
		LOOGER.info("TIEMPO QUE EMPEZO: " + startTime + " ms"  );
		LOOGER.info("REQUEST URL:  -- " + request.getRequestURL().toString() + " -- TOTAL TIME : " + (System.currentTimeMillis() - startTime) + " ms"  );
	}
	 
	

}
