package model;

public class RestriPlay extends PLAYLIST{

	//Atributes
	private USER userRes[];

	public RestriPlay(String name, USER userRes[]){
		super(name);
		userRes = new USER [5];
		this.userRes = userRes;
	}

	public USER[] getUserRes(){
		return userRes;
	}
}