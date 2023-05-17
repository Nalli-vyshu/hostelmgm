package serviceImpl;

import org.apache.log4j.Logger;
import service.loginregister;

public class loginregisterImpl implements loginregister {
	
	static Logger log=Logger.getLogger(loginregisterImpl.class);
	@Override
	public void registartion() {
		 log.info("Welcome to registration");
		 
	}
 @Override
  public void login() {
	  log.info("Welcome to login");
 }
}
