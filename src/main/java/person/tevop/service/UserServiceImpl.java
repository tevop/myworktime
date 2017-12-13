package person.tevop.service;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import person.tevop.dao.UserDao;
import person.tevop.model.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean save(Object obj) throws Exception{
		return userDao.save(obj);
	}

	@Override
	public boolean exists(User user) {
		return userDao.exists(user);
	}

	@Override
	public User getUser(String name) {
		return userDao.getUser(name);
	}

	@Override
	public HibernateTemplate getHibernateTemplate() {
		return userDao.getHibernateTemplate();
	}

}
