package serviceImpl;

import org.apache.log4j.Logger;
import exception.globalException;
import service.userdashboard;
import daoImpl.userdashboardDAOIMPL;
import java.util.*;




public class userdashboardImpl  implements userdashboard{
    static Logger log=Logger.getLogger(userdashboardImpl.class);
    
    static userdashboardDAOIMPL  dao=new userdashboardDAOIMPL ();
	static Scanner sc=new Scanner(System.in);
	static userdashboardImpl impl=new userdashboardImpl();
	static int userId;
	@Override
	    public void userdashboard() {
		public void userdashboard(int userId) throws globalException {
			
		
		log.info("\t\t\t\t*****welcome to user dashboard*****");
		this.userId=userId;

		int ch=1;

		while(ch!=0) {
			log.info("Press 1 for view room\nPress 2 for view due amount\nPress 3 for update phone\nPress 4 for change password\nPress 5 for view profile\nPress 0 to exit");
			ch=sc.nextInt();

			switch(ch) {

			case 1->impl.viewRoom();

			case 2->impl.viewDueAmount();

			case 3->impl.changePhoneNum();

			case 4->impl.changePassword();

			case 5->impl.viewProfile();

			default->log.info("wrong option");

			}	
		}
	}
	@Override
	public void viewRoom() {

		String room=((userdashboardDAOIMPL) dao).viewRoom(userId);
		log.info(room);

	}
	@Override
	public void viewDueAmount() {

		int amount=dao.viewDueAmount(userId);
		log.info("total due amount is : "+amount );
	}
	@Override
	public void changePhoneNum() {

		log.info("enter new phone number");
		String newphone=sc.next();
		int res=((userdashboardDAOIMPL) dao).changePhoneNum(userId, newphone);
		if(res==1) {
			log.info("phone number updaed");
		}
		else {
			log.info("something went wrong");
		}
	}
	@Override
	public void changePassword() throws globalException {

		log.info("Enter current password");
		String oldpwd=sc.next();
		log.info("Enter new password");
		String newpwd=sc.next();

		int st=dao.changePassword(userId, oldpwd, newpwd);
		if(st==1) {
			log.info("password update");
		}
	}
	@Override
	public void viewProfile() {

		log.info(dao.viewProfile(userId));

	
	
	
	}
	}
