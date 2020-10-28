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
	startApp();
		} 

	public static void main (String[]args){
		Main objMain = new Main();
		objMain.showIcon();
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
             System.out.println(" * QUE DESEA HACER? *");	   	
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
         	     
         	    break;

            default: 
                System.out.println("Ingreso un numero NO valido");
            }
	    }
	}

    public static void createUser(){
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

    public static void createSong(){
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
	    boolean exit = true;
	    for (int i = 0;exit;i++){
	   		if(releaseData[1] < 60){
	   			exit = false;
	   		}
	   		else 
	   			System.out.println("Los Segundos son menos de 60");
		}
		System.out.println("Cual es el genero de "+title"?");
		System.out.println("[1] ROCK\n[2]HIP HOP\n[3] MUSICA CLASICA\n[4] REGGAE\n[5] SALSA\n[6] METAL");
		int opt = lector.nextInt();
		if(opt => 1 && opt <= 6){
			musicCS.addSong(title,artistName,releaseData,duration,musicCS.genreSong(opt));
		}
    }

    public static void createPlaylist(){
    	
    }






}