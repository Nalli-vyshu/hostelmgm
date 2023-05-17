package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import model.room;
import model.user;

import java.util.Properties;

public class hibernateUtil {
	
	  public static SessionFactory sesFactory;
	  public static SessionFactory getSessionFactory() {
		  
		  if(sesFactory==null) {
			  try
			  {

			  Configuration con=new Configuration();
			  
			  
			  Properties pro=new Properties();
			  //adding all properites to congigure
			  pro.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				pro.put(Environment.URL, "jdbc:mysql://localhost:3306/hostel");
				pro.put(Environment.USER,"root");
				pro.put(Environment.PASS, "vyshu2525");
				pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				pro.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				pro.put(Environment.HBM2DDL_AUTO, "update");
				
				con.setProperties(pro);
				//adding entity classes for configuration
				con.addAnnotatedClass(room.class);
				con.addAnnotatedClass(user.class);
				
				sesFactory=con.buildSessionFactory();
		  
		  }
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		  
		 }  
		  
		  return sesFactory;
	  }
      
	  public static Session getSession() {
		  return getSessionFactory().openSession();
	  }
}
