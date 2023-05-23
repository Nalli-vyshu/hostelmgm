package serviceImpl;

import org.apache.log4j.Logger;
import model.user;
import daoImpl.loginregisterDAOIMPL;
import exception.globalException;
import service.loginregister;
import java.util.*;

public class loginregisterImpl implements loginregister {
	
	static Logger log=Logger.getLogger(loginregisterImpl.class);
	static Scanner sc=new Scanner(System.in);
	static loginregisterDAOIMPL dao=new loginregisterDAOIMPL();
	static userdashboardImpl userda=new userdashboardImpl();
	static admindashboardImpl adminda=new admindashboardImpl();
	
	@Override
	public void registartion()throws globalException {
		 log.info("Welcome to registration");
		 log.info("Enter UserName");
		 String uname=sc.next();
	     log.info("Enter Paasword");
		 String upass=sc.next();
		 log.info("Enter Phone number");
		 String uphone=sc.next();
		 log.info("Enter Address");
		 String uadr=sc.next();
		 user u1=new user();
		 
		 u1.setUserName(uname);
		 u1.setUserPassword(upass);
		
		 u1.setUserAddress(uadr);
		 u1.setUserRole("student");
		 u1.setUserRoom(null);
         u1.setUserFee(0);
         
		 int res=dao.registration(u1);
		 if(res==1) {
			 log.info("Registration sucess");
		 }
		 else {
			 log.info("someting went wrong");
		 }
		 
	}
 @Override
  
  public void login() throws globalException{
	  log.info("Welcome to login");
	  log.info("Enter Username");
	  String uname=sc.nextLine();
	  log.info("Enter Pasword");
	  String pass=sc.next();
	  
	  user u2=dao.login(uname, pass);
	    if(u2!=null) {
	    	log.info("login sucess");
	    	if(u2.getUserRole().equals("admin")) {
	    		adminda.dashboard();
	    		
	    	}
	    	else {
	    		userda.userdashboard();
	    	}
	    } 
	      
	    else {
	    	log.info("login failed");
	    }
 }
}
 

