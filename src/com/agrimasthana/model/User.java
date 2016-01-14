package com.agrimasthana.model;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private Date date_joined;
	
	public int getid(){return id;}
	public String getName(){return name;}
	public Date getDateJoined(){return date_joined;}
	
	public void setid(int id){this.id=id;}
	public void setName(String name){this.name=name;}
	public void setDateJoined(Date date){this.date_joined=date;}
}
