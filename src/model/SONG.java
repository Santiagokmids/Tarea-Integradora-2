package model;

public class SONG{

	//Relationships
	private Genre[] songGenre;

	//Atributes
	private String title;
	private String artistName;
	private int releaseData[];
	private int duration[];
	private Genre genre;

	//Methods
	/** 
	*Name: SONG.
	*Constructor of SONG <br> 
	*<b> post: </b> Start the class SONG.
   */
	public SONG(String title, String artistName,int releaseData[], int duration[], Genre genre){
		this.title = title;
		this.artistName = artistName;
		this.releaseData = releaseData;
		this.duration = duration;
		this.genre = genre;
	}//end Constructor

	/** 
		*Name: getTitle.
		*Get the title of the song <br>   
		*<b> post: </b> get the title of the song.
		*@return String title. This is the title of the song.
	   */
	public String getTitle(){
		return title;
	}//end get

	/** 
		*Name: setTitle.
		*Change the title of the song <br>   
		*<b> post: </b> the new title of the song.
	   */
	public void setTitle(String title){
		this.title = title;
	}

	/** 
		*Name: getArtistName.
		*Get the name of the artist of the song <br>   
		*<b> post: </b> get the name of the artist of the song.
		*@return String artistName. This is the name of the artist of the song.
	   */
	public String getArtistName(){
		return artistName;
	}//End get

	/** 
		*Name: setArtistName.
		*Change the name of the artist <br>   
		*<b> post: </b> the new name of the artist.
	   */
	public void setArtistName(String artistName){
		this.artistName = artistName;
	}

	/** 
		*Name: getDuration.
		*Get the duration of the song <br>   
		*<b> post: </b> get the duration of the song.
		*@return int duration[]. This is the duration of the song.
	   */
	public int[]getDuration(){
		return duration;
	}//end get

	/** 
		*Name: setDuration.
		*Change the duration of the song <br>   
		*<b> post: </b> the new duration of the song.
	   */
	public void setDuration(int duration[]){
		this.duration = duration;
	}

	/** 
		*Name: getReleaseDate.
		*Get the release date  of the song <br>   
		*<b> post: </b> get the release date of the song.
		*@return int releaseDate[]. This is the release date of the song.
	   */
	public int[]getReleaseData(){
		return releaseData;
	}//end get

	/** 
		*Name: getGenre.
		*Get the genre of the song <br>   
		*<b> post: </b> get the genre of the song.
		*@return Genre genre. This is the genre of the song.
	   */
	public Genre getGenre(){
		return genre;
	}//end get

	/** 
		*Name: setGenre.
		*Change the genre of the song <br>   
		*<b> post: </b> the new genre of the song.
	   */
	public void setGenre(Genre genre){
		this.genre = genre;
	}//end set


}//end class Song	
