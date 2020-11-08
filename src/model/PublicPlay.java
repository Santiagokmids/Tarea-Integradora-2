package model;

public class PublicPlay extends PLAYLIST{

	//Atributes
	private int calification;
	private int averageCount;

	/** 
	*Name: PublicPlay.
	*Constructor of public Playlist <br> 
	*<b> post: </b> Start the class Public Playlist.
   */
	public PublicPlay(String name){
		super(name);
		calification = 0;
		averageCount = 0;
	}//End constructor

	/** 
		*Name: getCalification.
		*Get the calification of the playlist <br>   
		*<b> post: </b> get the calification of the playlist.
		*@return int calification. This is the calification of the public playlist.
	   */
	public int getCalification(){
		return calification;
	}//End get

	/** 
		*Name: setCalification.
		*Change the calification of the playlist <br>   
		*<b> post: </b> the new calification of the playlist.
	   */
	public void setCalification(int calification){
		this.calification = calification;
	}//end set

	/**Name: getAverage.
		*Get the average of calification of the playlist <br>   
		*<b> post: </b> get the average of calification of the playlist.
		*@return int calification. This is the average of calification of the public playlist.
	   */
	public int getAverage(){
		return averageCount;
	}//end get

	/** 
		*Name: setAverage.
		*Change the average of calification of the playlist <br>   
		*<b> post: </b> the new average of calification of the playlist.
	   */
	public void setAverage(int averageCount){
		this.averageCount = averageCount;
	}//end set
}//end class Public Playlist