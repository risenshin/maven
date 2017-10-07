package com.iddel.spt.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
public final class SPTLog4jLogger implements ISPTLogger {
	
	
	private final Logger LOGGER;

	private SPTLog4jLogger(String className) {

		this.LOGGER = LogManager.getLogger(className);

	}
	
	private <T> SPTLog4jLogger(Class<T> clazz) {

		this.LOGGER = LogManager.getLogger(clazz);

	}
	
	
	public static <T> ISPTLogger getInstance(Class<T> clazz){
		
		return new SPTLog4jLogger(clazz);
	}

	public static ISPTLogger getInstance(String className) {

		return new SPTLog4jLogger(className);

	}

	@Override
	public <T> void info(T t) {

		LOGGER.info(t);

	}

	@Override
	public <T> void debug(T t) {
		LOGGER.debug(t);

	}

	@Override
	public <T> void error(T t) {
		LOGGER.error(t);

	}

	@Override
	public <T> void trace(T t) {
		LOGGER.trace(t);

	}

	@Override
	public <T> void warn(T t) {
		LOGGER.warn(t);

	}

	@Override
	public <T> void fatal(T t) {
		LOGGER.fatal(t);

	}

	@Override
	public void info(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		try {
			LOGGER.info(message, objectArray);
		} catch (LoggingException le) {

		}
	}

	@Override
	public void debug(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		LOGGER.debug(message, objectArray);
	}

	@Override
	public void error(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		LOGGER.error(message, objectArray);
	}

	@Override
	public void warn(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		LOGGER.warn(message, objectArray);
	}

	@Override
	public void trace(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		LOGGER.trace(message, objectArray);
	}

	@Override
	public void fatal(Object... t) {

		String message = null;
		Object[] objectArray = null;

		if (t != null) {
			objectArray = getObjectArray(t);
			message = t[0].toString();
		}

		LOGGER.fatal(message, objectArray);
	}

	private static Object[] getObjectArray(Object... t) {

		Object[] objectArray = null;
		if (t.length > 0) {
			objectArray = new Object[t.length - 1];
			int j = 0;
			for (int i = 1; i < t.length; i++) {
				objectArray[j] = t[i];
				j++;
			}
		}
		return objectArray;
	}

	@Override
	public void exception(Exception e) {
		LOGGER.error("Exception found: " + e);
		e.printStackTrace();
	}

	@Override
	public void exception(Exception e, String msg) {
		LOGGER.error(msg + e);
		e.printStackTrace();
	}
}
