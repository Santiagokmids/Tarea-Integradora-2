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
	private USER[] user;

	//Artibutes
	private int numUsers;
	private int numSongs;
	private int amountPlayl;

	//Methods
	 /** 
		*Name: MCS.
		*Constructor of class MCS <br> 
		*<b> post: </b> The class was initializaded..
	   */
	public MCS(int numUsers, int numSongs, int amountPlayl){
		this.numUsers = numUsers;
		this.numSongs = numSongs;
		this.amountPlayl = amountPlayl;
		playList = new PLAYLIST[MAX_PLAYLIST];
		genre = new Genre[MAX_GENRE];
		songsPool = new SONG[MAX_SONGS];
		user = new USER[MAX_USERS];
	}//End constructor

	 /** 
		*Name: createUser.
		*Create to a user <br> 
		*<b> post: </b> The user has been created.
		*@return String message. This is the message if the user was created.
	   */
	public String createUser(String name, String password, int age){
		String message = "El usuario ya esta creado";
		boolean exit = true;
		if (findUser(name)){  
	    	for(int i = 0;i<user.length && exit;i++){
	    		if (user[i] == null){
	    			user[i] = new USER(name,password,age);
	    			exit = false;
	    			message = "El usuario ha sido añadido correctamente";
	    		}
	     	}
	    }
	    return message;
	}//End create user

	 /** 
		*Name: AddSong.
		*Add a song in the songs pool <br> 
		*<b> post: </b> The song was add to the pool of songs.
		*@return String message. This is the message if the song was added.
	   */
	public String addSong(String title, String artistName, int releaseDate[], int duration[],Genre genre){
		String message = "La cancion ya esta en el pool de canciones";
		boolean exit = true;
		if (findSong(title)){  
	    	for(int i = 0;i<songsPool.length && exit;i++){
	    		if (songsPool[i] == null){
	    			songsPool[i] = new SONG(title, artistName, releaseDate, duration, genre);
	    			exit = false;
	    			message = "La cancion ha sido agregada correctamente";
	    		}
	     	}
	    }
	    return message;
	}//End add song

	 /** 
		*Name: addSongToPlay.
		*Add a song of the songs pool to one Playlist <br>
		*<b> pre: </b> should is created a Playlist.<br> 
		*<b> post: </b> The song was added to the playlist.
		*@return String message. This is the message if the song was add to playlist
	   */
	public String addSongToPlay(String namePlay,String title,String artistName){
		boolean find = true,wait = true,stop = true;
		String message = "No se pudo agregar la cancion al Playlist";
	    for(int i=0;i<playList.length && find;i++){
	    	if(playList[i] != null && playList[i].getName().equalsIgnoreCase(namePlay)){
	    	 	for(int k=0;k<songsPool.length && find;k++){
					if(songsPool[k] != null && songsPool[k].getTitle().equalsIgnoreCase(title)){
	    				for (int o = 0;o<MAX_GENRE && wait;o++) {
	    					for(int l = 0;l<MAX_SONGS && stop;l++){
	    						if(playList[i].getSongs()[l] == null){
	    							playList[i].getSongs()[l] = songsPool[k];
		    						if(playList[i].getGenre()[o] == Genre.DESCONOCIDO || playList[i].getGenre()[o] == null){
		    							playList[i].getGenre()[o] = songsPool[k].getGenre();
		    							message = "Se agrego la cancion correctamente"; 
		    							find = false;
		    							stop = false;
		    							wait = false;
		    						}
		    						else{
		    							o++;
		    						}
		    					}
	    					}		
	    				}
	    	    	}
	        	}
	   	    }
	    }
	    return message;
	}//End add Song to Playlist

	 /** 
		*Name: createPlay.
		*Create to playlist public <br> 
		*<b> post: </b> The playlist has been created.
		*@return String message. This is the message if the public playlist was created.
	   */
	public String createPlay(String name){
		String message = "La playlist ya existe";
		boolean exit = true;
		if (findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			playList[i] = new PublicPlay(name);
	    			exit = false;
	    			message = "La playlist publica ha sido creada correctamente";
	    		}
	    		else if(i == MAX_PLAYLIST){
	    			message = "No tiene espacio para crear mas playList";
	    		}
	     	}
	    }
	    return message;
	}//End createPlay

	 /** 
		*Name: createPlay.
		*Create to playlist private <br> 
		*<b> post: </b> The playlist has been created.
		*@return String message. This is the message if the private playlist was created.
	   */
	public String createPlay(String name,String nameUser){
		String message = "";
		boolean exit = true;
		if (findPlay(name)){  
	    	for(int i = 0;i<playList.length && exit;i++){
	    		if (playList[i] == null){
	    			for(int k = 0;k<MAX_USERS;k++){
	    				if(user[k] != null && user[k].getUserName().equalsIgnoreCase(nameUser)){
	    					playList[i] = new Private(name,user[k]);
	    					exit = false;
	    					message = "La playlist privada ha sido creada correctamente";
	    				}
	    				else if(i == MAX_PLAYLIST){
	    					message = "No tiene espacio para crear mas playList";
	    				}
	    			}
	    		}
	     	}
	    }
	    return message;
	}//End create playlist

	 /** 
		*Name: createPlay.
		*Create to restricted playlist <br> 
		*<b> post: </b> The playlist has been created.
		*@return String message. This is the message if the restricted playlist was created.
	   */
	public String createPlay(String name,String userRes[]){
		String message = "La playlist ya existe";
		boolean exit = true, stop = true;
		if (findPlay(name)){  
	    	for(int i = 0;i<user.length && exit;i++){
	    		if(user[i] != null && user[i].getUserName().equalsIgnoreCase(userRes[i])){
		    		for(int k = 0;k<playList.length && stop;k++){
		    			for(int o = 0;o<userRes.length;o++){
		    				if(playList[k] == null){
		    					stop = false;
		    					USER[] countUser = new USER[userRes.length];
		    					countUser[o] = user[i]; 
		    					playList[k] = new RestriPlay(name,countUser);
		    					exit = false;
		    					message = "La playlist restringida ha sido creada correctamente";
		    				}
		    				else if(i == MAX_PLAYLIST){
		    					message = "No tiene espacio para crear mas playList";
		   					}
	    				}
	   				}
	  			}	
			}
	    }	 	
	    return message;
  	}//End create playlist	

  	 /** 
		*Name: findUser.
		*Find if one user was created <br> 
		*<b> pre: </b> the user should is created.<br> 
		*<b> post: </b> The user dont exist.
		*@return boolean find. This is the value if the user was found.
	   */
	public boolean findUser(String userName){
		boolean find = true;
	    	for(int i=0;i<user.length && find;i++){
	    	 	if(user[i] != null && user[i].getUserName().equalsIgnoreCase(userName)){
	    			find = false;
	    	    }
	        }
	        return find;
    }//END FIND USER

    	 /** 
		*Name: findSong.
		*Find if one song was created <br> 
		*<b> pre: </b> the song should is created.<br> 
		*<b> post: </b> The song dont exist.
		*@return boolean find. This is the value if the song was found.
	   */
	public boolean findSong(String title){
		boolean find = true;
	    for(int i=0;i<songsPool.length && find;i++){
			if(songsPool[i] != null && songsPool[i].getTitle().equalsIgnoreCase(title)){
	    		find = false;
	    	    }
	        }
	        return find;
	}//End find song

		 /** 
		*Name: findArt.
		*Find if the artist of one song is correct <br> 
		*<b> pre: </b> the song of the artist should be created.<br> 
		*<b> post: </b> The artist of the song is correct.
		*@return boolean find. This is the value if the artist was found.
	   */
	public boolean findArt(String nameArtist){
		boolean find = true;
	    for(int i=0;i<songsPool.length && find;i++){
			if(songsPool[i] != null && songsPool[i].getArtistName().equalsIgnoreCase(nameArtist)){
	    		find = false;
	  		}
	    }
	    return find;
	}//End find Art

	 /** 
		*Name: findPlay.
		*Find the playlist created <br> 
		*<b> pre: </b> the playlist should be created.<br> 
		*<b> post: </b> The playlist exist.
		*@return boolean find. This is the value if the playlist was found.
	   */
	public boolean findPlay(String name){
		boolean find = true;
	    for(int i=0;i<playList.length && find;i++){
	    	if(playList[i] != null && playList[i].getName().equalsIgnoreCase(name)){
	    		find = false;
	   	    }
	    }
	  return find;
	}//end find Playlist

	 /** 
		*Name: showUsers.
		*Show all users created <br>  
		*<b> post: </b> Show all users.
		*@return String message. This is the message about the information of each user.
	   */
	public String showUsers(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<user.length && exit;i++){
			if(user[i] != null){
			    message +="  *************  User **************"+
			    "\n  **  UserName: "+user[i].getUserName()+
			    "\n  **  Age: "+user[i].getAge()+
			    "\n  **  Category: "+user[i].getCategory()+
			    "\n ***********************************\n\n";       
			}
			else if(user[0] == null){
				message = "No hay usuarios agregados";
			}
			else {
				message += "No hay mas usuarios";
				exit = false;
			}	       
		}
		return message;
	}//end show user

	 /** 
		*Name: showSongs.
		*Show all songs created <br>  
		*<b> post: </b> Show all songs.
		*@return String message. This is the message about the information of each song.
	   */
	public String showSongs(){
		String message = "";
		boolean exit = true;
		for(int i = 0; i<songsPool.length && exit;i++){
			if(songsPool[i] != null){
			    message +="  **************  Song **************"+  
			    "\n  **  Title: "+songsPool[i].getTitle()+
			    "\n  **  Artist: "+songsPool[i].getArtistName()+
			    "\n  **  Duration: "+songsPool[i].getDuration()[0]+":"+songsPool[i].getDuration()[1]+
			    "\n  **  Genre: "+songsPool[i].getGenre()+
			    "\n  ***********************************\n\n";      
			}
			else if(songsPool[0] == null){
				message = "No hay canciones en el pool";
				exit = false;
			}

			else{
				message += "No hay mas canciones en el Pool";
				exit = false;
			}       
		}
		return message;	
	}//End show songs

	 /** 
		*Name: showPlay.
		*Show all palylist created <br>  
		*<b> post: </b> Show all playlist.
		*@return String message. This is the message about the information of each playlist.
	   */
	public String showPlay(){
		String message = "",count = "",count1 = "", count2 = "",name = "";
		boolean exit = true;
		for(int i = 0; i<playList.length && exit;i++){
			if(playList[i] != null && playList[i] instanceof PublicPlay){
				for(int k = 0;k<MAX_GENRE;k++){
					if(playList[i].getGenre()[k] != null){
						count += playList[i].getGenre()[k]+"-";
					}
				}
					PublicPlay objPublic = (PublicPlay)playList[i];
					message += "**************  Playlist **************"+
					"\n  **  Title: "+playList[i].getName()+
					"\n  **  Duration: "+durationPlay()+
					"\n  **  Genre: "+count+
					"\n  **  Calification: "+objPublic.getCalification()+"\n";        
			}

			else if(playList[i] != null && playList[i] instanceof RestriPlay){
				RestriPlay objRest = (RestriPlay)playList[i];
				boolean stop = true;
				for(int o = 0;o<MAX_GENRE;o++){
					if(playList[i].getGenre()[o] != null){
						count1 += playList[i].getGenre()[o]+"-";
					}
				}
				String countName = getUsersRes();
				message += "**************  Playlist **************"+
				"\n  **  Title: "+playList[i].getName()+
				"\n  **  Duration: "+durationPlay()+
				"\n  **  Genre: "+count1+
				"\n  **  Allowed users: "+countName+"\n";
			}

			else if(playList[i] != null && playList[i] instanceof Private){
				Private objPri = (Private)playList[i];
				for(int p = 0;p<MAX_GENRE;p++){
					if(playList[i].getGenre()[p] != null){
						count2 += playList[i].getGenre()[p]+"-";
					}
				}
				for(int m = 0;m<MAX_USERS;m++){
					if(user[m] != null){
						if(objPri.getUserPrivate() == user[m]){
							name = user[m].getUserName();
						}
					}
				}
				
				message += "**************  Playlist **************"+
				"\n  **  Title: "+playList[i].getName()+
				"\n  **  Duration: "+durationPlay()+
				"\n  **  Genre: "+count2+
				"\n  **  Allowed user: "+name+"\n";
			}

			else if(MAX_PLAYLIST == MAX_PLAYLIST-1){
				message += "No hay mas playList";
				exit = false;
			}
			else if(playList[0] == null){
				message = "No hay Playlist";     
			}
		}
	   return message;	
	}//End show Playlist

	 /** 
		*Name: getUsersRes.
		*Get the users of the restricted playlist <br>  
		*<b> pre: </b> the restricted playlist should be created.<br> 
		*<b> post: </b> get the users of the restricted playlist.
		*@return String name. This is the user names obtained of the restricted playlist.
	   */
	public String getUsersRes(){
		String name = "";
		boolean exit = true;
		for(int i = 0; i<MAX_PLAYLIST && exit;i++){
			if(playList[i] != null && playList[i] instanceof RestriPlay){
				RestriPlay objRest = (RestriPlay)playList[i];
				for(int k = 0;k<5 && exit;k++){
					for(int o = 0;o<MAX_USERS;o++){
						if(user[o] != null && objRest.getUserRes()[k] == user[o]){
							name += user[o].getUserName()+"-"; 
							exit = false;
						}
					}
				}
			}
			else if(playList[0] == null){
				name = "No hay playList restringidas";
			}
		}
		return name;
	}//end getUseRes

	 /** 
		*Name: getNumUsers.
		*Get the number of users <br>   
		*<b> post: </b> get the amount of users.
		*@return int numUsers. This is the number of users.
	   */
	public int getNumUsers(){
		return numUsers;
	}//end num users

	/** 
		*Name: getNumSongs.
		*Get the number of songs <br>   
		*<b> post: </b> get the amount of songs.
		*@return int numSongs. This is the number of songs.
	   */
	public int getNumSongs(){
		return numSongs;
	}

	/** 
		*Name: FindSpaces.
		*Find if someone user name have a space <br>   
		*<b> post: </b> The user name have spaces.
		*@return String boolean. This is the value about the spaces found in the user names.
	   */
    public boolean findSpaces(String userName){
	boolean stop = false;
	String message = " ";
    	for(int text = userName.length()-1;text>=0 && !stop;text--){
    		if(userName.charAt(text) == message.charAt(0)){
    			stop = true;
    		}
        }
        return stop;
    }//End findSpaces

    /** 
		*Name: verifyDate.
		*Verify if the date of the song is correct <br>   
		*<b> post: </b> Verication about date of the song.
		*@return String message. This is a message about if the date is correct .
	   */
    public String verifyDate(int dates[]){
    	String message = "";
    	if(dates[0] <= 31){
    		if(dates[1] <= 12){
    			message = "Fecha correcta!!";
    		}
    		else {
    			message = "Fecha incorrecta";
    		}
    	}
    	else {
    		message = "Fecha incorrecta";
    	}

    	return message;
    }//End veriryDate

    /** 
		*Name: genreSong.
		*Add to the genre of one song a genre <br>   
		*<b> post: </b> the genre of the song is changed.
		*@return Genre genre. This is the value of genre for one song.
	   */
    public Genre genreSong(int opt){
    	Genre genre = Genre.DESCONOCIDO;
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
    }//End genreSong

    /** 
		*Name: ContSongs.
		*Count the songs that exist <br>   
		*<b> post: </b> amount of songs created.
	   */
    public void contSongs(String nameUser){
    	boolean find = true;
	   	for(int i=0;i<user.length && find;i++){
	    	if(user[i] != null && user[i].getUserName().equalsIgnoreCase(nameUser)){
	    		int count = user[i].getCount() + 1;
	    		user[i].setCount(count);
	    		find = false;
	    	}
	    }
    }//End contSongs

	   /** 
		*Name: addCategory.
		*Add category to user <br>   
		*<b> post: </b> category add to user.
	   */
    public void addCategory(){
    	for(int i = 0;i<MAX_USERS;i++){
    		if(user[i] != null){
    			if(user[i].getCount() > 3 && user[i].getCount() <= 10){
    				user[i].setCategory(Category.LITTLE_CONTRIBUITOR);
    			}
    			else if(user[i].getCount() > 10 && user[i].getCount() <= 30){
    				user[i].setCategory(Category.MILD_CONTRIBUITOR);
    			}
    			else if(user[i].getCount() > 30){
    				user[i].setCategory(Category.STAR_CONTRIBUITOR);
    			}
    		}
    	}
    }//End addCategory

     /** 
		*Name: ChoosePlay
		*Choose what playlist<br>
		*<b> pre: </b> should be created one playlist.<br>   
		*<b> post: </b> playlist with their kind.
		*@return String message. This is the category of a playlist .
	   */
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
    }//End Choose play

     /** 
		*Name: UsersReser
		*Find a user in the restricted playlist<br>
		*<b> pre: </b> should be created one restricted playlist.<br>   
		*<b> post: </b> users of the restricted playlist.
		*@return boolean find. This is the value for the find users of the restricted playlist.
	   */
    public boolean usersReser(String namePlay,String nameUser){
    	boolean stop = true, exit = true,find = true;
		for(int i = 0;i<5 && stop;i++){
			if(playList[i].getName().equalsIgnoreCase(namePlay)){
				if(playList[i] instanceof RestriPlay){
					RestriPlay objRest = (RestriPlay)playList[i];
					for(int k = 0;k<5 && exit;k++){ 
						if(user[k] != null && user[k].getUserName().equalsIgnoreCase(nameUser)){
							for (int o = 0;o<MAX_USERS;o++ ) {
								if(objRest.getUserRes()[k] == user[o]){
									stop = false;
									exit = false;
									find = false;
								}	
							}
						}
					}
				}
			}  
 		}
 		return find;
    }//End userReser
    
     /** 
		*Name: findPrivate
		*Find to private playlist<br>
		*<b> pre: </b> should be created one playlist.<br>   
		*<b> post: </b> user of the private playlist.
		*@return boolean stop. This is the value if find to user of private playlist.
	   */
    public boolean findPrivate(String namePlay,String nameUser){
    	boolean stop = true,exit = true;
    	for(int i = 0;i<MAX_USERS && stop;i++){
			if(playList[i].getName().equalsIgnoreCase(namePlay)){
				if(playList[i] instanceof Private){
					Private objPri = (Private)playList[i];
					for (int k = 0;k<MAX_USERS;k++) {
					 	if(user[k] != null && user[k].getUserName().equalsIgnoreCase(nameUser)){
					 		if(objPri.getUserPrivate() == user[k]){
								stop = false;
								exit = false;
							}
					 	}
					} 
				}
			}		
		}
		return stop;			
    }//End findPrivate

     /** 
		*Name: DurationPlay
		*Calculate the time of each playlist<br>
		*<b> pre: </b> should be created one playlist.<br>   
		*<b> post: </b> duration of each playlist.
		*@return String message. This is the duration of each playlist .
	   */
    public String durationPlay(){
    	String message = "";
    	SONG[] duration = new SONG [50];
    	int[] min = new int [50];
    	int[] seg = new int [50];
    	boolean exit = true;
    	for(int i = 0;i<MAX_PLAYLIST;i++){
    		if(playList[i] != null){
    			for(int o= 0;o<MAX_SONGS;o++){
    				duration[i] = playList[i].getSongs()[o];
		    	 	for(int k = 0;k<MAX_SONGS;k++){
		    	 		if(duration[k] != null){
		    	 			min[k] = duration[k].getDuration()[0];
		    	 			seg[k] = duration[k].getDuration()[1];
		    	 		}
		    	 	}
    			}
    		} else{
    			message = "No existe la playList";
    		}
    	}
    	int minuts = 0, segunds = 0, hours = 0;
    	for(int o = 0;o<MAX_SONGS;o++){
    		if(min[o] != 0 && seg[o] != 0){
    			minuts += min[o]; 
    			segunds += seg[o];
    		}
    	}
    	minuts += segunds/60;
    	hours += minuts/60;
    	minuts = minuts%60;
    	segunds = segunds%60;
    	message = hours+":"+minuts+":"+segunds;
    	return message;
    }//End durationPlay

     /** 
		*Name: putCalification
		*Put a calification to public playlist<br>
		*<b> pre: </b> should be created one playlist.<br>   
		*<b> post: </b> playlist with their calification.
		*@return String message. This is the calification of the playlist .
	   */
    public String putCalification(String namePlay,String nameUser,int calification){
    	int count = 0,counter = 0;
    	String message = "";
    	boolean exit = true;
    	if(!findUser(nameUser)){
    		for(int i = 0;i<MAX_PLAYLIST && exit;i++){
    			if(!findPlay(namePlay) && playList[i] instanceof PublicPlay){
    				PublicPlay objPublic = (PublicPlay)playList[i];
    				count = 1;
    				count = objPublic.getAverage()+count;
    				objPublic.setAverage(count);	
    			    counter = calification/objPublic.getAverage();
    			    objPublic.setCalification(counter);
    				message = "Calificacion agregada";
    				exit = false;
    			}
    			else{
    				message = "La Playlist NO ha sido creada";    			
    			}
    		}
    	}
    	else {
    		message = "El usuario NO ha sido agregado a MCS";
    	}
    	return message;
    }//End put calification

    //Sorry for the mistakes with the showPlay and with private playlist. I tried did the best

}//End MCS