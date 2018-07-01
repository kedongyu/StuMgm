package edu.jyu.stumgm.entity;

public class Course {
	private int id;
	private String name;
	private short credit;
	
	public Course() {
		
	}
	public Course(int id, String name, short credit) {
		super();
		this.id = id;
		this.name = name;
		this.credit = credit;
	}
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
	public short getCredit() {
		return credit;
	}
	public void setCredit(short credit) {
		this.credit = credit;
	}
	
}
