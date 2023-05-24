package dao;


import org.hibernate.Session;

import config.hibernateUtil;
import exception.globalException;
import model.user;

public interface userdashboardDAO {
	public String viewRoom(int Uid);
	
	public int viewDueAmount(int Uid);
	
	public int changePhoneNum(int Uid,String phone);
	
	public int changePassword(int Uid,String oldPwd,String newPwd)throws globalException;
	
	public user viewProfile(int Uid);

}
@Override
  public user viewUserProfile(int userId){
	  
	  try(Session ses=hibernateUtil.getSession())
	  {
		  user u1=null;
	  }
	  
  }