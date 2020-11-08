package model;

public abstract class PLAYLIST{

	//Constant
	public final static int SIZE_MAX = 50;

	//Relationships
	private SONG []songs;
	private Genre[] genrePlay;

	//Atributes
	private String name;
	private Genre[]genre;
	private int[] duration;

	//Methods
	/** 
	*Name: Playlist.
	*Constructor of playlist <br> 
	*<b> post: </b> Start the class abstract Playlist.
   */
	public PLAYLIST(String name){
		this.name = name;
		genre = new Genre[7];
		genre[0] = Genre.DESCONOCIDO;
		duration = new int [3];
		duration[0] = 0; duration[1] = 0; duration[2] = 0;
		songs = new SONG[50];
	}//End constructor

	 /** 
		*Name: getName.
		*Get the name of the playlist <br>   
		*<b> post: </b> get the name of the playlist.
		*@return String name. This is the name of the Playlist.
	   */
	public String getName(){
		return name;
	}//End getName

	 /** 
		*Name: setName.
		*Change the name of the playlist <br>   
		*<b> post: </b> the new name of the playlist.
	   */
	public void setName(String name){
		this.name = name;
	}//End set

	/** 
		*Name: getSongs.
		*Get the array of songs that are in playlist <br>   
		*<b> post: </b> get the sogns of the playlist.
		*@return Song songs[]. This are the songs in one playlist.
	   */
	public SONG []getSongs(){
		return songs;
	}//End get

	/** 
		*Name: setSongs.
		*Change the songs of the playlist <br>   
		*<b> post: </b> the new songs of the playlist.
	   */
	public void setSongs(SONG songs[]){
		this.songs = songs;
	}//End set

	/** 
		*Name: getDuration.
		*Get the array of duration that are in playlist <br>   
		*<b> post: </b> get the duration of the playlist.
		*@return int duration[]. This is the duration of the playlist.
	   */
	public int[] getDuration(){
		return duration;
	}//End gey

	/** 
		*Name: getGenre.
		*Get the array of genres that are in playlist <br>   
		*<b> post: </b> get the genres of the playlist.
		*@return Genre genre[]. This are the genres in one playlist.
	   */
	public Genre []getGenre(){
		return genre;
	}//End get

	/** 
		*Name: setGenre.
		*Change the genres of the playlist <br>   
		*<b> post: </b> the new genres of the playlist.
	   */
	public void setGenre(Genre genre[]){
		this.genre = genre;
	}//End set




}//End the class playlist