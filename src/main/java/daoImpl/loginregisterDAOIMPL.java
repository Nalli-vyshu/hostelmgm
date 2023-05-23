package daoImpl;

import org.hibernate.Session;

import config.hibernateUtil;
import dao.loginregisterDAO;
import exception.globalException;
import model.user;

public class loginregisterDAOIMPL implements  loginregisterDAO {

	@Override
	public int registration(user u1) throws globalException {
		
		try(Session ses=hibernateUtil.getSession()) {
			
			String username=(u1).getUserName();
			user u2=null;
			u2=(user)ses.createQuery("from user where userName=:uname").setParameter("uname",username).uniqueResult();
			 if(u2==null) {
			 ses.beginTransaction();
			 ses.save(u1);
			 ses.getTransaction().commit();
			 return 1;
		 }
			 else { 
				 throw new globalException("user already existed");
			 }
		}
	}
@Override
	public user login(String username,String password) throws globalException {
		
		
		try(Session ses=hibernateUtil.getSession()) {
			user u2=null;
		
			u2=(user)ses.createQuery("from user where userName=:uname").setParameter("uname", username).uniqueResult();
			
			
			if(u2!=null) {
				
				if(password.equals(u2.getUserPassword())) {
					return u2;
					
				}
				else {
					return null;
				}
			}
			else {
					  throw new globalException("user not found");
				}
			}
		
		
		
	
		

	}
}
