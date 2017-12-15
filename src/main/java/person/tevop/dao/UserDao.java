package person.tevop.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import person.tevop.model.User;

public interface UserDao {
	public boolean save(Object obj) throws Exception;

	public boolean exists(String userName);
	
	public User getUser(String name);
	public HibernateTemplate getHibernateTemplate();
}
