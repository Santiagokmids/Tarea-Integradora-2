package model;

public class MCS{

	//Contants
	public final static int MAX_USERS = 10;
	public final static int MAX_PLAYLIST = 20;
	public final static int MAX_SONGS = 50;
	public final static int MAX_GENRE = 7;

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
		playList = new PLAYLIST[MAX_PLAYLIST];
		genre = new Genre[MAX_GENRE];
		songsPool = new SONG[MAX_SONGS];
		user = new USERS[MAX_USERS];
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

	public String addSongToPlay(String namePlay,String title,String artistName){
		boolean find = true;
		String message = "No se pudo agregar la cancion al Playlist"
	    for(int i=0;i<playList.length && find;i++){
	    	if(playList[i] != null && playList[i].getName().equalsIgnoreCase(namePlay)){
	    	 	for(int k=0;k<songsPool.length && find;k++){
					if(songsPool[k] != null && songsPool[k].getTitle().equalsIgnoreCase(title)){
	    				for(int l = 0;l<MAX_SONGS;l++){
	    					if(playList[i].getSongs()[l] == null){
	    						playList[i].setSongs()[l] = songsPool[k];
	    						message = "Se agrego la cancion correctamente"; 
	    						find = false;
	    					}
	    				}
	    	    	}
	        	}
	   	    }
	    }
	    return message;
	}

	//Public Playlist
	public String createPlay(String name){
		String message = "La palylist ya existe";
		boolean exit = true;
		if ((findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			playList[i] = new PublicPlay(name);
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

	//Create Playlist Private
	public String createPlay(String name,String nameUser){
		String message = "La palylist ya existe";
		boolean exit = true;
		if ((findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			playList[i] = new Private(name,nameUser);
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

	//Create restricted playlist
	public String createPlay(String name,String userRes[]){
		String message = "La palylist ya existe";
		boolean exit = true;
		if ((findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			playList[i] = new RestriPlay(name,userRes);
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
	
	public boolean findUser(String userName){
		boolean find = true;
	    	for(int i=0;i<user.length && find;i++){
	    	 if(user[i] != null && user[i].getUserName().equalsIgnoreCase(userName)){
	    		find = false;
	    	    }
	        }
	        return find;
    }

	public boolean findSong(String title){
		boolean find = true;
	    for(int i=0;i<songsPool.length && find;i++){
			if(songsPool[i] != null && songsPool[i].getTitle().equalsIgnoreCase(title)){
	    		find = false;
	    	    }
	        }
	        return find;
	}

	public boolean findArt(String nameArtist){
		boolean find = true;
	    for(int i=0;i<songsPool.length && find;i++){
			if(songsPool[i] != null && songsPool[i].getArtistName().equalsIgnoreCase(title)){
	    		find = false;
	  		}
	    }
	    return find;
	}

	public boolean findPlay(String name){
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
			    message +="  *************  User **************"+
			    "\n  **  UserName: "+user[i].getUserName()+
			    "\n  **  Age: "+user[i].getAge()+
			    "\n  **  Category: "+user[i].getCategory()+
			    "\n ***********************************\n";       
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
			    message +="  **************  Song **************"+  
			    "\n  **  Title: "+songsPool[i].getTitle()+
			    "\n  **  Artist: "+songsPool[i].getArtistName()+
			    "\n  **  Duration: "+songsPool[i].[0]getDuration()+":"+songsPool[i].[1]getDuration()+
			    "\n  **  Genre: "+songsPool[i].getGenre()+
			    "\n  ***********************************\n";
				exit = false;       
			}
			return message;	       
		}
	}

	public String showPlay(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<playList.length || exit,i++){
			if(playList[i] != null && playlist[i] instanceof PublicPlay){
				for(int k = 0;k<MAX_GENRE;k++){
					message += "**************  Playlist **************"+
					"\n  **  Title: "+playList[i].getName()+
					"\n  **  Duration: "+durationPlay()+
					"\n  **  Genre: "+playList[i].getGenre()[k]+"\n";       
				}
				exit = false; 
			}

			else if(playList[i] != null && playlist[i] instanceof RestriPlay){
				RestriPlay objRest = (RestriPlay)playList[i];
				for(int o = 0;o<MAX_GENRE;o++){
					for(int l = 0; l<5 ;l++){
						message += "**************  Playlist **************"+
						"\n  **  Title: "+playList[i].getName()+
						"\n  **  Duration: "+durationPlay()+
						"\n  **  Genre: "+playList[i].getGenre()[o]+
						"\n  **  Allowed users: "+objRest.getUserRes()[l]"\n";
					}
				}
			}

			else if(playList[i] != null && playlist[i] instanceof Private){
				Private objPri = (Private)playList[i];
				for(int p = 0;p<MAX_GENRE;p++){
						message += "**************  Playlist **************"+
						"\n  **  Title: "+playList[i].getName()+
						"\n  **  Duration: "+durationPlay()+
						"\n  **  Genre: "+playList[i].getGenre()[p]+
						"\n  **  Allowed user: "+objPri.getUserPrivate()"\n";
				}
			}      
		}
	   return message;	
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
    	else {
    		message = "Fecha incorrecta";
    	}

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

    public int[] contSongs(String nameUser){
    	boolean find = true;
    	count = new int[MAX_USERS]
	   	for(int i=0;i<user.length && find;i++){
	    	if(user[i] != null && user[i].getUserName().equalsIgnoreCase(userName)){
	    		count[i]++
	    		find = false;
	    	}
	    }
	    return count;
    }

    public Category addCategory(int count[]){
    	for(int i = 0;i<MAX_USERS;i++){
    		if(user[i] != null){
    			if(count[i] > 3 && count[i] <= 10){
    				user[i].setCategory(Category.LITTLE_CONTRIBUITOR);
    			}
    			else if(count[i] > 10 && count[i] <= 30){
    				user[i].setCategory(Category.MILD_CONTRIBUITOR);
    			}
    			else if(count[i] > 30){
    				user[i].setCategory(Category.STAR_CONTRIBUITOR);
    			}
    		}
    	}
    }

    public String choosePlay(String namePlay){
    	String message = "";
    	boolean exit = true;
    	for(int i = 0;i<MAX_PLAYLIST && exit;i++){
    		if(playList[i].getName().equalsIgnoreCase(namePlay) && playList[i] instanceof Private){
    			message = "Privada";
    			exit = false;
    		}
    		else if(playList[i].getName().equalsIgnoreCase(namePlay) && playList[i] instanceof RestriPlay){
    			message = "Restri";
    			exit = false;
    		}
    		else if(playList[i].getName().equalsIgnoreCase(namePlay) && playList[i] instanceof PublicPlay){
    			message = "Public";
    			exit = false;
    		}
    	}
    	return message;
    }

    public boolean usersReser(String namePlay,String nameUser){
    	boolean stop = true, exit = true,find = true;
		for(int i = 0;i<5 && stop;i++){
			if(playList[i].getName(namePlay).equalsIgnoreCase(namePlay)){
				if(playList[i] instanceof RestriPlay){
					RestriPlay objRest = (RestriPlay)playList[i];
					for(int k = 0;k<5 && exit;k++){ 
						if(objRest.getUserRes()[k].equalsIgnoreCase(nameUsers)){
							stop = false;
							exit = false;
							find = false;
						}
					}
				}
			}  
 		}
 		return find;
    }
    
    public boolean findPrivate(String namePlay,String nameUser){
    	boolean stop = true,exit = true;
    	for(int i = 0;i<MAX_USERS && stop;i++){
			if(playList[i].getName(namePlay).equalsIgnoreCase(namePlay)){
				if(playList[i] instanceof Private){
					Private objPri = (Private)playList[i]; 
					if(objPri.getUserRes().equalsIgnoreCase(nameUsers)){
						stop = false;
					}
				}
			}		
		}
		return stop;			
    }

    public String durationPlay(){
    	duration = SONG [50];
    	min = int [50];
    	seg = int [50];
    	boolean exit = true;
    	for(int i = 0;i<MAX_PLAYLIST;i++){
    	 	duration[i] = playList[i].getSongs()[i];
    	 	for(int k = 0;k<MAX_SONGS;k++){
    	 		if(duration[k] != null){
    	 			min[k] = duration[k].getDuration()[0];
    	 			seg[k] = duration[k].getDuration()[1];
    	 		}
    	 	}
    	}
    	for(int o = 0;o<MAX_SONGS;o++){
    		if(min[o] != null && seg[o] != null){
    			int minuts += min[o]; 
    			int segunds += seg[o];
    		}
    	}
    	minuts += segunds/60;
    	int hours += minuts/60;
    	minuts = minuts%60;
    	segunds = segunds%60;
    	String message = hours+":"+minuts+":"+segunds;
    	return message;
    }
}