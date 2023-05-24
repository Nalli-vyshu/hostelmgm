package dao;
import model.room;
import model.user;

import java.util.*;

import exception.globalException;

public interface admindashboardDAO {
	public int createRoom(room r1) throws globalException;
	
	public List<room> viewRoom();
	
	public List<user> viewUser();
	
	public int allotRoom(int userId,int roomId);
	
	public int deleteUser(int userId);
	
	public int deleteRoom(int roomId);
	
	public int addDueAmount(int userId,int amount);
	
	public int paidDueAmount(int userId,int amount); 
	
	public user viewuserProfile(int userId);
	

}
