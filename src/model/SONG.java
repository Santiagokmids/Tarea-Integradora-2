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
	public SONG(String title, String artistName,int releaseData[], int duration[], Genre genre){
		this.title = title;
		this.artistName = artistName;
		releaseData = new int[3];
		this.releaseData = releaseData;
		duration = new int [2];
		this.duration = duration;
		this.genre = genre;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getArtistName(){
		return artistName;
	}

	public void setArtistName(String artistName){
		this.artistName = artistName;
	}

	public int[]getDuration(){
		return duration;
	}

	public void setDuration(int duration[]){
		this.duration = duration;
	}

	public int[]getReleaseData(){
		return releaseData;
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre genre){
		this.genre = genre;
	}







}	
