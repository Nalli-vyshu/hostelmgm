package dao;

import exception.globalException;
import model.user;

public interface loginregisterDAO {
	
	public int registration(user u1) throws globalException;
	public user login(String username,String password)throws globalException;

}
