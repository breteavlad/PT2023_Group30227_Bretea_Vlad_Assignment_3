package model;

import java.util.ArrayList;

public class Client {
	 
	    private Integer id;
	    
	    private String name;
	    
	    private String address;
	
	
	public Client(int id,String name,String address) {
		this.address=address;
		this.id=id;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		return "The client with id: " +this.id + " has the name : " +this.name + " and the address: " + this.address;
	}
	
	
}
