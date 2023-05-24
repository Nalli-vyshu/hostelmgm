package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import config.hibernateUtil;
import dao.admindashboardDAO;
import exception.globalException;
import model.room;
import model.user;

public class admindashboardDAOIMPL implements admindashboardDAO {

	@Override
	public int createRoom(room r1) throws globalException {
		
		try(Session ses=hibernateUtil.getSession()) {
			
			ses.beginTransaction();
			String roomName=r1.getRoomName();
			room r2=null;
			
			r2=(room)ses.createQuery("from room where roomName=:room").setParameter("room",roomName).uniqueResult();
			
			if(r2==null) {
				ses.save(r1);
				ses.getTransaction().commit();
				return 1;
				
			}
			else {
				throw new globalException("room is already existed");
			}
		}
		
	}

	@Override
	public List<room> viewRoom() {
		
		try(Session ses=hibernateUtil.getSession()) {
			Query qu=ses.createQuery("from room");
			
			List<room> roomList=qu.getResultList();
			return roomList;
			
	     }
				
	}

	@Override
	public List<user> viewUser() {
		try(Session ses=hibernateUtil.getSession()) {
			Query qu=ses.createQuery("from user");
			
			List<user> userList=qu.getResultList();
			return userList;
			
		
		}
	}

	@Override
	public int allotRoom(int userId, int roomId) {
		// TODO Auto-generated method stub
		return 0;
	} 

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoom(int roomId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addDueAmount(int userId, int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int paidDueAmount(int userId, int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public user viewuserProfile(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
