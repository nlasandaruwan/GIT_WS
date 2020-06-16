package spring4.core.autowire.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring4.core.autowire.dao.BaseDao;

@Component
public class Manager {

	@Autowired
	private BaseDao loginDao;
	
	public void saveLogin(){
		loginDao.save();
	}
	

}
