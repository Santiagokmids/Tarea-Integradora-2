package model;

public class Private extends PLAYLIST{

	//Relationships
	private USER userPrivate;

	public Private(String name,USER userPrivate){
		super(name);
		this.userPrivate = userPrivate;
	}

	public USER getUserPrivate(){
		return userPrivate;
	}
}