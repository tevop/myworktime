package person.tevop.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import person.tevop.model.User;

public class UserDaoForSql implements UserDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean save(Object obj) throws Exception{
//		if (exists(user)) {
//			return false;
//		}
		System.out.println("saving user...");
		hibernateTemplate.saveOrUpdate(obj);
		return true;
	}

	@Override
	public boolean exists(User user) {
		List list = hibernateTemplate.find("from User u where u.name=?", new String[] {user.getName()});
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String name) {
		List<User> list = (List<User>)hibernateTemplate.find("from User u where u.name=?", new String[] {name});
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		System.out.println("end");
		return null;
	}
	
	
	
	
}
