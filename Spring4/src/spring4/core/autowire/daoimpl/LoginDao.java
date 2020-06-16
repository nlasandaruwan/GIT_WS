package spring4.core.autowire.daoimpl;

import org.springframework.stereotype.Component;

import spring4.core.autowire.dao.BaseDao;

@Component
public class LoginDao implements BaseDao{

	@Override
	public void save() {
		System.out.println("From Login DAO");
		
	}

}
