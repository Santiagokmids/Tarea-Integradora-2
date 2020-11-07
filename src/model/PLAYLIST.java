package model;

public class PLAYLIST{

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
	public PLAYLIST(String name){
		this.name = name;
		genre = new Genre[7];
		genre[0] = Genre.DESCONOCIDO;
		duration = new int [3];
		duration[0] = 0; duration[1] = 0; duration[2] = 0;
		songs = new SONG[50];
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public SONG []getSongs(){
		return songs;
	}

	public void setSongs(SONG songs[]){
		this.songs = songs;
	}

	public int[] getDuration(){
		return duration;
	}

	public Genre []getGenre(){
		return genre;
	}

	public void setGenre(Genre genre[]){
		this.genre = genre;
	}




}