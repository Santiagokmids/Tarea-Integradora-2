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
	private int duration[3];

	//Methods
	public PLAYLIST(String name){
		this.name = name;
		this.genre = Genre.DESCONOCIDO;
		this.duration = [0,0,0];
		this.songs = new SONG[50];
		genre = new Genre[7];
	}

	public Strin getName(){
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




}