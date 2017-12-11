package person.tevop.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private String pass;
	private Set<Content> contents = new HashSet<Content>(); 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Set<Content> getContents() {
		return contents;
	}
	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}
	
	
	
}
