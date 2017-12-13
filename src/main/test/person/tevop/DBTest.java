package person.tevop;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import person.tevop.model.Content;
import person.tevop.model.User;

public class DBTest {

	@Test
	public void testCreateDB() {
//		Configuration cfg=new Configuration().configure();  
//        
//        //工具类  
//        SchemaExport export=new SchemaExport();  
        //打到控制台，输出到数据库  
//        export.create(targetTypes, metadata);;  
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HibernateTransactionManager manager = (HibernateTransactionManager)context.getBean("txManager");
		SessionFactory factory = manager.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setName("user297");
		user.setPass("123");
		HashSet<Content> contents = new HashSet<Content>();
		user.setContents(contents);
		Content c = new Content();
		c.setCost(2);
		c.setDate(new Date());
		c.setUser(user);
		c.setComment("today's work");
		user.getContents().add(c);
		Content c2 = new Content();
		c2.setCost(3);
		c2.setDate(new Date());
		c2.setUser(user);
		c2.setComment("today's work2");
		user.getContents().add(c2);
//		user.setContents(contents);
//		session.save(c);
//		session.save(c2);
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testMD5() {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
			byte[] input = new String("www").getBytes("UTF-8");
			byte[] output = digest.digest(input);
			System.out.println(new String(output,"UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
