package com.iddel.spt.logger;

public interface ISPTLogger{
	
	public static ISPTLogger getInstance(String className){
		return null;
	}
	
	 public  <T> void info(T t);
	 
	 public  void info(Object... t);
	 
	 public  <T> void debug(T t);
	 
	 public  void debug(Object... t);
	 
	 public <T> void error(T t);
	 
	 public  void error(Object... t);
	 
	 public <T> void trace(T t);
	 
	 public  void trace(Object... t);
	 
	 public <T> void warn(T t);
	 
	 public void warn(Object... t);
	 
	 public <T> void fatal(T t);
	 
	 public void fatal(Object... t);

	public void exception(Exception e);
	public void exception(Exception e, String msg);

}
