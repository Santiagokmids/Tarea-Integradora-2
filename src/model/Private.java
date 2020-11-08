package model;

public class Private extends PLAYLIST{

	//Relationships
	private USER userPrivate;

	/** 
	*Name: Private.
	*Constructor of private Playlist <br> 
	*<b> post: </b> Start the class Private Playlist.
   */
	public Private(String name,USER userPrivate){
		super(name);
		this.userPrivate = userPrivate;
	}//End constructor

	/** 
		*Name: getUserPrivate.
		*Get the name of the user that can use the playlist <br>   
		*<b> post: </b> get the name of the user that can use the playlist.
		*@return String userPrivate. This is the name user that can use the Playlist.
	   */
	public USER getUserPrivate(){
		return userPrivate;
	}//End get
}//End class Private Playlist