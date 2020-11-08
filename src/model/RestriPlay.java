package model;

public class RestriPlay extends PLAYLIST{

	//Atributes
	private USER userRes[];

	/** 
	*Name: RestriPlay.
	*Constructor of restricted Playlist <br> 
	*<b> post: </b> Start the class restricted Playlist.
   */
	public RestriPlay(String name, USER userRes[]){
		super(name);
		userRes = new USER [5];
		this.userRes = userRes;
	}//End constructor

	/** 
		*Name: getUserRes.
		*Get the users with access to the playlist <br>   
		*<b> post: </b> get the users with access to the playlist.
		*@return USER userRes[]. This are the are the users with access to the restricted playlist.
	   */
	public USER[] getUserRes(){
		return userRes;
	}//end get
}//end class Restricted playlist