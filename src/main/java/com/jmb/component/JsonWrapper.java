package com.jmb.component;

import org.springframework.stereotype.Component;

@Component
public class JsonWrapper {

	private boolean resultadoOK = true;
	private String url;
	private String message;
	private String errorMessage;
	private StackTraceElement[] errortrace;
	private Object jsonOutView;

	public boolean isResultadoOK() {
		return resultadoOK;
	}

	public void setResultadoOK(boolean resultadoOK) {
		this.resultadoOK = resultadoOK;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public StackTraceElement[] getErrortrace() {
		return errortrace;
	}

	public void setErrortrace(StackTraceElement[] errortrace) {
		this.errortrace = errortrace;
	}

	public Object getJsonOutView() {
		return jsonOutView;
	}

	public void setJsonOutView(Object jsonOutView) {
		this.jsonOutView = jsonOutView;
	}

}
