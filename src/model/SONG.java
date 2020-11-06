package model;

public class SONG{

	//Relationships
	private Genre[] songGenre;

	//Atributes
	private String title;
	private String artistName;
	private String releaseData[3];
	private int duration[2];
	private Genre genre;

	//Methods
	public SONG(String title, String artistName,String releaseData[], int duration[], Genre genre){
		this.title = title;
		this.artistName = artistName;
		this.releaseData = releaseData;
		this.duration = duration;
		genre = new Genre[7];
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

	public String[]getReleaseData(){
		return releaseData[];
	}

	public Genre getGenre(){
		return genre;
	}

	public void setGenre(Genre genre){
		this.genre = genre;
	}







}	
