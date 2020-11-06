package model;

public class RestriPlay extends PLAYLIST{

	//Atributes
	private String userRes[];

	public RestriPlay(String name, String userRes[]){
		super(name);
		userRes = new String [5];
		this.userRes = userRes;
	}

	public String[] getUserRes(){
		return userRes;
	}
}