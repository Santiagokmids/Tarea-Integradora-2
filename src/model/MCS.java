package model;

public class MCS{

	//Contants
	public final static int MAX_USERS = 10;
	public final static int MAX_PLAYLIST = 20;
	public final static int MAX_SONGS = 50;

	//Relationships
	private PLAYLIST[] playList;
	private Genre[] genre;
	private SONG[] songsPool;
	private USERS[] user;

	//Artibutes
	private int numUsers;
	private int numSongs;
	private int amountPlayl;

	//Methods
	public MCS(int numUsers, int numSongs, int amountPlayl){
		this.numUsers = numUsers;
		this.numSongs = numSongs;
		this.amountPlayl = amountPlayl;
		playList = new PLAYLIST[20];
		genre = new Genre[7];
		songsPool = new SONG[50];
		user = new USERS[10];
	}

	public String createUser(String name, String password, int age){
		String message = "El usuario ya esta creado";
		boolean exit = true;
		if ((findUser(name)){  
	    	for(int i = 0;i<user.length && exit;i++){
	    		if (user[i] == null){
	    			user[i] = new USERS(name,password,age);
	    			exit = false;
	    			message = "El usuario ha sido añadido correctamente";
	    		}
	     	}
	    }
	    return message;
	}

	public String addSong(String title, String artistName, String releaseDate[], int duration[],Genre genre){
		String message = "La cancion ya esta en el pool de canciones";
		boolean exit = true;
		if ((findSong(title)){  
	    	for(int i = 0;i<songsPool.length && exit;i++){
	    		if (songsPool[i] == null){
	    			songsPool[i] = new SONG(title, artistName, releaseDate, duration, genre);
	    			exit = false;
	    			message = "La cancion ha sido agregada correctamente";
	    		}
	     	}
	    }
	    return message;
	}

	public String createPlay(String name){
		String message = "La palylist ya existe";
		boolean exit = true;
		if ((findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			playList[i] = new PLAYLIST(name);
	    			exit = false;
	    			message = "La palylist ha sido creada correctamente";
	    		}
	    		else if(i == MAX_PLAYLIST){
	    			message = "No tiene espacio para crear mas playList";
	    		}
	     	}
	    }
	    return message;
	}

	public String createPlay(String name,String nameUser){

	}

	public String findUser(String userName){
		boolean find = true;
	    	for(int i=0;i<user.length && find;i++){
	    	 if(user[i] != null && user[i].getUserName().equalsIgnoreCase(userName)){
	    		find = false;
	    	    }
	        }
	        return find;
    }

	public String findSong(String title){
		boolean find = true;
	    	for(int i=0;i<songsPool.length && find;i++){
	    	 if(songsPool[i] != null && songsPool[i].getTitle().equalsIgnoreCase(title)){
	    		find = false;
	    	    }
	        }
	        return find;
	}

	public String findPlay(String name){
		boolean find = true;
	    	for(int i=0;i<playList.length && find;i++){
	    	 if(playList[i] != null && playList[i].getName().equalsIgnoreCase(name)){
	    		find = false;
	    	    }
	        }
	        return find;
	}

	public String showUsers(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<user.length || exit,i++){
			if(user[i] != null){
			    message +="  *************  User **************\n **  UserName: "+user[i].getUserName()+" \n  **  Age: "+user[i].getAge()+"\n **  Category: "+user[i].getCategory()+"\n ***********************************\n";       
			}
			else {
				message="No hay mas usuarios";
				exit = false;
			}
			return message;	       
		}
	}

	public String showSongs(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<songsPool.length || exit,i++){
			if(songsPool[i] != null){
			    message +="  **************  Song **************\n  **  Title: "+songsPool[i].getTitle()"\n**  Artist: "+songsPool[i].getArtistName()"\n  **  Duration: "songsPool[i].[0]getDuration()+songsPool[i].[1]getDuration()"\n  **  Genre: "+songsPool[i].getGenre()"\n  ***********************************\n";
				exit = false;       
			}
			return message;	       
		}
	}

	public String showPlay(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<playList.length || exit,i++){
			if(playList[i] != null && playList[i].[i]getGenre() != null){
				        message += "  **************  Playlist **************\n**  Title: "playList[i].getName()"\n**  Duration: "+playList[i].getDuration()"\n  **  Genre: "+playList[i].[i]getGenre(); 
				exit = false;       
			}
			return message;	       
		}

	}

	public getNumUsers(){
		return numUsers;
	}

	public getNumSongs(){
		return getNumSongs;
	}

    public boolean findSpaces(String userName){
	boolean stop = false;
    	for(int text = userName.length()-1;text>=0 || !stop;text--){
    		if(userName.charAt(text).equals(" ")){
    			stop = true;
    		}
        }
    }

    public String verifyDate(int dates[]){
    	String message = "";
    	if(dates[0] <= 31){
    		if(dates[1] <= 12){
    			message = "Fecha correcta!!";
    		}
    	}
    	else 
    		message = "Fecha incorrecta";

    	return message;
    }

    public Genre genreSong(int opt){
    	Genre genre;
    	if(opt == 1){
    		genre = Genre.ROCK;
    	}
    	else if(opt == 2){
    		genre = Genre.HIP_HOP;
    	}
    	else if(opt == 3){
    		genre = Genre.CLASIC;
    	}
    	else if(opt == 4){
    		genre = Genre.REGGAE;
    	}
    	else if(opt == 5){
    		genre = Genre.SALSA;
    	}
    	else if(opt == 6){
    		genre = Genre.METAL;
    	}
    	return genre;
    }


}