package person.tevop.service;

import org.springframework.orm.hibernate5.HibernateTemplate;

import person.tevop.model.User;

public interface UserService {
	public boolean save(User user) throws Exception;
	public boolean exists(User user);
	public User getUser(String name);
	public HibernateTemplate getHibernateTemplate();
}
