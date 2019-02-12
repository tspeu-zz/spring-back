package com.jmb.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jmb.repository.LogRepository;

								/*sirve para que cada peticion que se haga primero entre por esta clase */
@Component("reqTimeInterceptor")
public class ReqTimeInterceptor extends HandlerInterceptorAdapter{

	private static final Log LOOGER = LogFactory.getLog(ReqTimeInterceptor.class);
	
	
	@Autowired
	@Qualifier("logRepository")
 	private LogRepository logRepository;
	
	
	
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
		
		String url =  request.getRequestURL().toString();
		String username = "";
		
		Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
		
		
		if(auth != null && auth.isAuthenticated()) {
			username = auth.getName();
		}
		
		
		com.jmb.entity.Log logEntity = new com.jmb.entity.Log(new Date(), auth.getDetails().toString() , username, url);
		
		logRepository.save(logEntity);
		
		
		LOOGER.info("TIEMPO QUE EMPEZO: " + startTime + " ms"  );
		LOOGER.info("REQUEST URL:  -- " + url + " -- TOTAL TIME : " + (System.currentTimeMillis() - startTime) + " ms"  );
	}
	 
	

}
