package serviceImpl;

import org.apache.log4j.Logger;

import service.userdashboard;

public class userdashboardImpl  implements userdashboard{
    static Logger log=Logger.getLogger(userdashboardImpl.class);
	@Override
	public void userdashboard() {
		// TODO Auto-generated method stub
		log.info("\t\t\t\t*****welcome to user dashboard*****");
	}
	
}
