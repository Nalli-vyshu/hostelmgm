package serviceImpl;


import org.apache.log4j.Logger;

import exception.globalException;
import service.admindashboard;
import java.util.*;
import model.*;
import daoImpl.admindashboardDAOIMPL;

 
public class admindashboardImpl implements admindashboard  {
	static Logger log=Logger.getLogger(admindashboardImpl.class);
	static Scanner sc=new Scanner(System.in);
	static admindashboardImpl impl=new admindashboardImpl();
	static admindashboardDAOIMPL dao=new admindashboardDAOIMPL();
    @Override
	public void dashboard()throws globalException {
		log.info("\t\t\t\t*****welcome to user dashboard*****");
		int ch=5;
		while(ch!=0) {
			
		
		log.info("Press 1 for create Room\nPress 2 for view user\nPress 3 for view Romms");
		log.info("Enter your choice of operation");
	    ch=sc.nextInt();
		
		switch(ch) {
		case 1->impl.createRoom();
		case 2->impl.viewUsers();
		case 3->impl.viewRooms();	
		}
		}
	}


	@Override
	public void createRoom() throws globalException {
		 log.info("Entr room Id");
		 int rId=sc.nextInt();
		 log.info("Enter room Name");
		 String rname=sc.next();
		 log.info("Enter room typr");
		 String rtype=sc.next();
		 
		 room r1=new room();
		 r1.setRoomId(rId);
		 r1.setRoomName(rname);
		 r1.setRoomType(rtype);
		 
		int res= dao.createRoom(r1);
		   if(res==1) {
			   log.info("room added sucessfully");
		   }
	}

    @Override
	public void viewUsers() {
		List<user> userList=dao.viewUser();
		for(user u:userList)
			log.info(u.getUserName());
		
    }


	@Override
	public void viewRooms() {
		List<room> roomList=dao.viewRoom();
		for(room r:roomList)
			log.info(r.toString());
	}
}
