package com.jmb.services.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jmb.services.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService{

	
	private static final Log log = LogFactory.getLog(EjercicioServiceImpl.class);
	
	public String _MSM;
	
	@Override
	public void mostrarLog() {
		
		log.warn(" ******    HOLA DESDE EjercicioServiceImpl     **********");
		
	}

	@Override
	public String getMensaje() {
		
		//validaciones
		if(this._MSM.isEmpty()) {
			
			this._MSM="ERR -> MENSAJE EMPTY";
		}
		log.warn(" ****** METODO: EjercicioServiceIMP ** | DATA :  " + this._MSM);
		
		return this._MSM;
	}

	@Override
	public void setMensaje(String msm) {
		
		 this._MSM = msm;
		
	}

}
