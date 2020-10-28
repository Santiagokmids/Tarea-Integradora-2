package model;

public class Private extends PLAYLIST{

	//Relationships
	private USER userPrivate;

	public Private(USER userPrivate, String name){
		super(name);
		this.userPrivate = userPrivate;
	}
}