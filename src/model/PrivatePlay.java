package model;

public class PrivatePlay extends PLAYLIST{

	//Relationships
	private USER userPrivate;

	public PrivatePlay(USER userPrivate, String name){
		super(name);
		this.userPrivate = userPrivate;
	}
}