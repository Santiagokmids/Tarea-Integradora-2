package ui;

import java.util.Scanner;

import model.MCS;

public class Main {

	//Atributes
	private MCS musicCS;

	//Globals variable
    public Scanner lector;

	public Main(){
	lector = new Scanner(System.in);
	showIcon();
		} 

	public static void main (String[]args){
		Main objMain = new Main();
		objMain.Menu();
	}

		//Methods
	public void showIcon(){

		System.out.println("                    BIENVENIDO...                  ");
		System.out.println("");
		System.out.println("  (((((((((((((((((((((((((((((((((((((((((((((((((");
		System.out.println("  ((((((((((((((((/((((((((((((((((((((((((((((((((");
		System.out.println("  (((/  .(((((((*  .((((((*        (((((/      /(((");
		System.out.println("  (((/   .((((((.  .(((((   ,((((((((((*  .((((((((");
		System.out.println("  (((/    /((((/   .((((/  ,(((((((((((.  /((((((((");
		System.out.println("  (((/     ((((*   .((((*  ,(((((((((((/   ((((((((");
		System.out.println("  (((/  *  *(((     ((((*  ,((((((((((((,  .(((((((");
		System.out.println("  (((/  /.  ((*     ((((*  *(((((((((((((,   ((((((");
		System.out.println("  (((/  //  ,(  .   ((((*  *((((((((((((((/   /((((");
		System.out.println("  (((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((");
		System.out.println("  (((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((");
		System.out.println("  (((/  .((    ((   /((((  .(((((((((((((((((.  /((");
		System.out.println("  (((/  .((.  .((.  *((((,  *((((((((((((((((   /((");
		System.out.println("  (((/  .((((((((.  *(((((   *((((/,/(((((((/   (((");
		System.out.println("  (((/  .((((((((.  *((((((.        *((   .   .((((");
		System.out.println("  (((((((((((((((/*/((((((((((///(((((((////(((((((");
		System.out.println("  (((((((((((((((((((((((((((((((((((((((((((((((((");
		System.out.println("                 ./(###((///((###(*                ");
		System.out.println("             *#(,                   *((,           ");
		System.out.println("          ,#/                           ((         ");
		System.out.println("        .#*          .**/////*,.          ((       ");
		System.out.println("       *(.      .//////////////////*       *#      ");
		System.out.println("      .#,     *///////////////////////,     /(     ");
		System.out.println("      /(    *///////////////////////////    .#.    ");
		System.out.println("    ,/////,*/////////////////////////////,*////*.  ");
		System.out.println("    /////////////////////////*,...,/////////////,  ");
		System.out.println("    //////*,,,********,,.............,,,,,//////,  ");
		System.out.println("    //////*.........//*........//*.......,//////,  ");
		System.out.println("    //////*.........,,.........,,........,//////,  ");
		System.out.println("    //////*..............................,//////,  ");
		System.out.println("     *///*  ........,/.........**.......  .*///,   ");
		System.out.println("              .......,/*.....,/*.......            ");
		System.out.println("                 ........,,,,.......               ");
		System.out.println("                      .........                    ");
        System.out.println("                                                   ");
		System.out.println("  *************************************************");
	}

	public void startApp(){
		musicCS = new MCS(MCS.MAX_USERS, MCS.MAX_PLAYLIST, MCS.MAX_SONGS);
	}

	public void Menu(){
	   	 boolean stop = false;
	   	 for(int l = 0;!stop;l++){
	   	 	 System.out.println("");
	   	     System.out.println("------------------------------------------------------");
             System.out.println("      * QUE DESEA HACER? *");	   	
             System.out.println("------------------------------------------------------");
	         System.out.println("");
	         System.out.println("************************************************************************");
	         System.out.println(" (1.) Introducir Usuarios                                               |");
	         System.out.println(" (2.) Mostrar los usuarios agregados                                    |");
	         System.out.println(" (3.) Agregar una cancion al pool de canciones                          |");
	         System.out.println(" (4.) Mostrar canciones que hay en el pool de canciones                 |");
	         System.out.println(" (5.) Crear PlayList                                                    |");
	         System.out.println(" (6.) Agregar cancion del pool al PlayList                              |");
	         System.out.println(" (7.) Mostrar PlayList existentes                                       |");
	         System.out.println(" (8.) Salir de la aplicacion                                            |");
	         System.out.println("************************************************************************");
	         int option = lector.nextInt();
	         System.out.println("");
	         lector.nextLine();
         
         switch(option){
         	case 1: 
         	   System.out.println("** Introducir Usuarios **");
         	   createUser();
         	   break;

         	case 2:
         		System.out.println("** Mostrar los usuarios agregados **");
         	    	String show = musicCS.showUsers();
         	    	System.out.println(show);
         	    break;

         	case 3:
         	     System.out.println("** Agregar una cancion al pool de canciones **");
         	     createSong();
         	    break;

         	case 4:
         	     System.out.println("** Mostrar canciones que hay en el pool de canciones **");
         	     String show2 = musicCS.showSongs();
         	     System.out.println(show2);
         	    break;

         	case 5:
         	     System.out.println("** Crear PlayList **");
         	     int opt = menuPlaylist();
         	     createPlaylist(opt);
         	    break;

         	case 6:
         	     System.out.println("** Agregar cancion del pool a la PlayList **");
         	     addSongPlay();
         	    break;

			case 7:
         		 System.out.println("** Mostrar Playlist existentes **");
         		 String show3 = musicCS.showPlay();
         	     System.out.println(show3);
         	    break;

         	case 8:
         		 stop = true;
         	     System.out.println("GRACIAS POR SU UTILIZAR MCS :D");
         	    break;
    
            default: 
                System.out.println("Ingreso un numero NO valido");
            }
	    }
	}

    public void createUser(){
    	System.out.println("");
    	boolean stop = true;
    	for (int i = 0;stop;i++){
	    	System.out.println("Introduzca NickName del usuario (Sin espacios)");
	    	userName = lector.nextLine();
	    	if(!musicCS.findSpaces(userName)){
	    		System.out.println("Introduzca la contraseña de "+userName);
	    	    password = lector.nextLine();
	    	    System.out.println("Introduzca la edad del usuario "+userName);
	    	    age = lector.nextInt();
	    	    musicCS.createUser(userName, password, age);
	    	    stop = false;
	    	}
	    	else 
	    		System.out.println("Ingreso un nombre NO valido, tiene espacios");
	    }	
    }

    public void createSong(){
    	System.out.println("");
    	System.out.println("Introduzca el titulo de la cancion");
    	String title = lector.nextLine();
    	releaseData = new int[3], duration = new int[2];
    	boolean stop = true;
    	System.out.println("Introduzca el artista o banda que interpreta "+title);
    	artistName = lector.nextLine();
    	for (int i = 0;stop;i++){
	    	System.out.println("Introduzca solo el dia de lanzamiento de "+title);
	    	releaseData[0] = lector.nextInt();
	    	System.out.println("Introduzca solo el mes de lanzamiento de "+title);
	    	releaseData[1] = lector.nextInt();
	    	System.out.println("Introduzca solo el anio de lanzamiento de "+title);
	    	releaseData[2] = lector.nextInt();
	    	lector.nextLine();
	    	String message = musicCS.verifyDate(releaseData[]);
	    	System.out.println(message);
	    	if(message.equals("Fecha correcta!!")){
	    		stop = false;
	    	}
    	}
    	System.out.println("Introduzca solo los minutos de duracion de "+title);
	    duration[0] = lector.nextInt();
	    System.out.println("Introduzca solo los segundos de duracion de "+title);
	    duration[1] = lector.nextInt();
	    boolean exit = true,wait = true;
	    for (int i = 0;exit;i++){
	   		if(releaseData[1] < 60){
	   			exit = false;
	   		}
	   		else 
	   			System.out.println("Los Segundos son menos de 60");
		}
		for(int k = 0;wait;k++){
			System.out.println("Cual es el genero de "+title"?");
			System.out.println("[1] ROCK\n[2]HIP HOP\n[3] MUSICA CLASICA\n[4] REGGAE\n[5] SALSA\n[6] METAL");
			int opt = lector.nextInt();
			lector.nextLine();
			if(opt => 1 && opt <= 6){
				musicCS.addSong(title,artistName,releaseData,duration,musicCS.genreSong(opt));
				wait = false;
			}
		}
    }

    public int menuPlaylist(){
    	System.out.println("Que tipo de PlayList quiere crear?");
    	boolean exit = true;
	    for (int i = 0;exit;i++){
	    	System.out.println("------------------------------------");
	    	System.out.println("[1] PlayList Publica");
	    	System.out.println("[2] PlayList Restringida");
	    	System.out.println("[3] PlayList Privada");
	    	System.out.println("------------------------------------");
	    	int opt = lector.nextInt();
	    	lector.nextLine();
	    	if(opt > 3){
	    		System.out.println("Ingreso un numero INVALIDO");
	    	}
	    	else
	    		exit = false;
	    }
    	return opt;
    }

    public void createPlaylist(int option){
    	String namePlay ="",nameUser = "";
    	namesUser = new String [5];
    	if(option == 1){
    		System.out.println("Introduzca el nombre de la PlayList");
    		namePlay = lector.nextLine();
    			musicCS.createPlay(namePlay);
	    	}
    	else if(option == 2){
    		System.out.println("Introduzca el nombre de la PlayList");
    		namePlay = lector.nextLine();
    		System.out.println("Introduzca el nombre de los usuarios que pueden acceder a "+namePlay);
    		for(int i = 0;i<5;i++){
    			nameUser = lector.nextLine();
    			if(!musicCS.findSpaces(nameUser)){
    				if(!musicCS.findUser(namesUser)){
    					namesUser[i] = nameUser;
    				}
    				else{
    					System.out.println("El usuario no ha sido creado, no se puede agregar");
    					i--;
    				}
    		    }
    		    else {
	    			System.out.println("Ingreso un nombre NO valido, tiene espacios");
	    			i--;
    		    }
    		}
    		musicCS.createPlay(namePlay,namesUser);
    	}
    	else if(option == 3){
    		System.out.println("Introduzca el nombre de la PlayList");
    		namePlay = lector.nextLine();
    		System.out.println("Introduzca el nombre del usuario al cual pertenece el PlayList");
    		nameUser = lector.nextLine();
    		boolean wait = true;
    		for(int k = 0;wait;k++){
    			nameUser = lector.nextLine();
    			if(!musicCS.findSpaces(nameUser)){
    				if(!musicCS.findUser(namesUser)){
    					musicCS.createPlay(namePlay,nameUser);
    					wait = false;
    				}
    				else
    					System.out.println("El usuario no ha sido creado");
    		    }
    		    else 
	    			System.out.println("Ingreso un nombre NO valido, tiene espacios");
    		}
    	}
    }

    public String addSongPlay(){
    	boolean exit = true;
    	count = new int[10];
    	for(int i = 0;i<MCS.MAX_SONGS && exit;i++){
    		System.out.println("Ingrese el nombre de la PlayList donde va a agregar la cancion");
    		String namePlay = lector.nextLine();
    		if(musicCS.findPlay(namePlay)){
    			System.out.println("La Playlist NO existe");
    		}
    		else{
    			String mess = musicCS.choosePlay(namePlay);
    			if(mess.equals("Public")){
	    			System.out.println("Ingrese el del usuario que ingresara la cancion");
		    		String nameUser = lector.nextLine();
		    		if(musicCS.findUser(nameUser)){
		    			System.out.println("El usuario NO existe");
		    		}
		    		else{
		    			count = musicCS.contSongs(nameUser);
			   			musicCS.addCategory(count);
		    			System.out.println("Ingrese el nombre de la cancion");
		    			String title = lector.nextLine();
		    			if(musicCS.findSong(title)){
		    				System.out.println("La cancion NO se encuentra en el pool de canciones");
		    			}
			    		else {
			    			System.out.println("Ingrese el nombre del artista que interpreta la cancion");
			   				String nameArtist = lector.nextLine();
			   				if(musicCS.findArt(nameArtist)){
			   					System.out.println("El artista NO interpreta "+title);
			   				}
		    				else{
		    					String message = musicCS.addSongToPlay(namePlay,title,nameArtist);
			   					System.out.println(message);
			   					exit = false;
			   				}
			   			}
		   			} 
	    		}

	    		else if(mess.equals("Restri")){
	    			System.out.println("Ingrese el del usuario que ingresara la cancion");
		    		String nameUsers = lector.nextLine();
		    		boolean find = musicCS.usersReser(namePlay,nameUsers);
		    		if(find){
		    			System.out.println("El usuario NO tiene permiso para agregar canciones a la Playlist");
		    		}
		    		else {
		    			count = musicCS.contSongs(nameUser);
			   			musicCS.addCategory(count);
		    			System.out.println("Ingrese el nombre de la cancion");
		    			String title = lector.nextLine();
		    			if(musicCS.findSong(title)){
		    				System.out.println("La cancion NO se encuentra en el pool de canciones");
		    			}
			    		else {
			    			System.out.println("Ingrese el nombre del artista que interpreta la cancion");
			   				String nameArtist = lector.nextLine();
			   				if(musicCS.findArt(nameArtist)){
			   					System.out.println("El artista NO interpreta "+title);
			   				}
		    				else{
		    					String message = musicCS.addSongToPlay(namePlay,title,nameArtist);
			   					System.out.println(message);
			   					exit = false;
			   				}
			   			}
		    		}
	    		}

	    		else if(mess.equals("Privada")){
	    			System.out.println("Ingrese el del usuario que ingresara la cancion");
		    		String nameUsers = lector.nextLine();
		    		boolean wait = musicCS.findPrivate(namePlay,nameUsers);
		    		if(find){
		    			System.out.println("El usuario NO tiene permiso para agregar canciones a la Playlist");
		    		}
		    		else {
		    			count = musicCS.contSongs(nameUser);
			   			musicCS.addCategory(count);
		    			System.out.println("Ingrese el nombre de la cancion");
		    			String title = lector.nextLine();
		    			if(musicCS.findSong(title)){
		    				System.out.println("La cancion NO se encuentra en el pool de canciones");
		    			}
			    		else {
			    			System.out.println("Ingrese el nombre del artista que interpreta la cancion");
			   				String nameArtist = lector.nextLine();
			   				if(musicCS.findArt(nameArtist)){
			   					System.out.println("El artista NO interpreta "+title);
			   				}
		    				else{
		    					String message = musicCS.addSongToPlay(namePlay,title,nameArtist);
			   					System.out.println(message);
			   					exit = false;
			   				}
			   			}
		    		}
	    		}
	    	}
   		}
   	}
}