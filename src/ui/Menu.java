package ui;
import model.*;
import java.util.Scanner;
/**
* @author Diego Hidalgo Lopez.
*/
public class Menu{
	
	//Menu options
	private final static int ADD_USER = 1;
	private final static int ADD_SONG_TO_POOL = 2;
	private final static int ADD_PLAYLIST = 3;
	private final static int ADD_SONG_TO_PLAYLIST = 4;
	private final static int RATE_PLAYLIST = 5;
	private final static int SHOW_USERS = 6;
	private final static int SHOW_SONGS = 7;
	private final static int SHOW_PLAYLISTS = 8;
	private final static int EXIT = 9;
	
	//Playlists options
	private final static int PUBLIC = 1;
	private final static int PRIVATE = 2;
	private final static int RESTRICTED = 3;
	
	private static Scanner sc = new Scanner(System.in);
	private Mcs app;
	
	/**
	* Constructor of the Menu class. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Menu class object created. <br>
	*/
	public Menu(){
		this.app = new Mcs();
	}
	
	/**
	* Shows the app logo <br>
	* <b>pre:</b><br>
	* <b>post:</b> String withe logo. <br>
	*/
	public void showLogo(){
		String logo =   "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
					    "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((  ((((((((*  ((((((((,      (((((((     ((((\n" +
						"((((   (((((((   ((((((   /((((((((((.  ((((((((\n" +
						"((((    ((((((   (((((*  ((((((((((((  /((((((((\n" +
						"((((    /((((*   (((((*  ((((((((((((   ((((((((\n" +
						"((((  (  ((((    (((((.  ((((((((((((/  *(((((((\n" +
						"((((  (. ,((*    *((((.  (((((((((((((/  .((((((\n" +
						"((((  ((  ((  (  ,((((.  (((((((((((((((   (((((\n" +
						"((((  ((* ,, .(  (((((.  ((((((((((((((((   ((((\n" +
						"((((  (((    ((  (((((,  (((((((((((((((((   (((\n" +
						"((((  (((   ,((  (((((/  ((((((((((((((((((  /((\n" +
						"((((  /((   (((  ((((((  ,(((((((((((((((((  *((\n" +
						"((((  /((((((((  ((((((/  .(((((((((((((((   (((\n" +
						"((((  /((((((((  ((((((((       ((((* .(*   ((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"                    .#//////#.\n"+                                               
						"               .###/         /###.\n"+
						"            ##                     ##\n"+
						"          #*                         /#\n"+         
						"        .#       ///////////////       #(\n"+        
						"        #     /////////////////////     #,\n"+       
						"       /#   *///////////////////////,   ##\n"+     
						"     ,///////////////////////////////*//////\n"+     
						"     /////////////////////......////////////\n"+    
						"     //////..........................,//////\n"+   
						"     //////........((.......*(*......,//////\n"+  
						"     //////..........................,//////\n"+ 
						"      *///, .......,/......../....... ,////\n"+
						"              .......//,..*/*......\n"+
						"                  .............\n";              
		System.out.println(logo);
		sc.nextLine();
	}
	
	/**
	* Options of the menu. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Shows the options menu available. <br>
	*/
	public void showMenu(){
		System.out.print("\n");
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar un usuario");
		System.out.println("[2] Agregar una cancion al pool");
		System.out.println("[3] Crear una Playlist");
		System.out.println("[4] Agregar cancion a una playlist");
		System.out.println("[5] Calificar una playlist publica");
		System.out.println("[6] Listar usuarios");
		System.out.println("[7] Listar canciones en el pool");
		System.out.println("[8] Listar Playlists");
		System.out.println("[9] Salir");
		System.out.print("Opcion: ");
	}
	
	/**
	* Reads the option to select by the user. <br>
	* <b>pre: option is initialized.</b><br>
	* <b>post:</b> the option selected by the user. <br>
	*/
	public int readOption(){
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	* Reads the necessary data to register an user. <br>
	* <b>pre:</b><br>
	* <b>post:</b> user created or user has not been created. <br>
	*/
	public void readUserData(){
		System.out.println("\n***ACCION: Registrar usuario");
		System.out.print("Nombre/apodo: ");
		String name = sc.nextLine();
		while(app.findBlanks(name)){
			System.out.println("El nombre de usuario no puede tener espacios en blanco");
			System.out.print("Nombre/Apodo: ");
			name = sc.nextLine();
		}
		while(app.findUser(name)){
			System.out.println("Nombre de usuario no disponible, ingrese otro");
			System.out.print("Nombre/Apodo: ");
			name = sc.nextLine();
		}
		System.out.print("Contrasenia: ");
		String passWord = sc.nextLine();
		System.out.print("Edad: ");
		int age = sc.nextInt();
		sc.nextLine();
		while(age < 0){
			System.out.println("\nEdad no valida, ingrese otra");
			System.out.print("Edad: ");
			age = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("***ESTADO: " + app.addUser(name, passWord, age));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to register song. <br>
	* <b>pre:</b><br>
	* <b>post:</b> song created or song has not been created. <br>
	*/
	public void readSongData(){
		System.out.println("\n***ACCION: Agregar cancion al Pool");
		System.out.print("Nombre de usuario que agrega la cancion: ");
		String user = sc.nextLine();
		while(!app.findUser(user)){
			System.out.println("El usuario ingresado no existe, ingrese otro");
			System.out.print("Nombre de usuario que agrega la cancion: ");
			user = sc.nextLine();
		}
		System.out.print("Nombre de la cancion: ");
		String title = sc.nextLine();
		System.out.print("Artista/banda: ");
		String artist = sc.nextLine();
		System.out.print("Fecha de lanzamiento (dd/mm/aaaa): ");
		String releaseDate = sc.nextLine();
		System.out.print("Minutos de duracion de la cancion: ");
		int minutes = sc.nextInt();
		sc.nextLine();
		System.out.print("Segundos de duracion de la cancion: ");
		int seconds = sc.nextInt();
		sc.nextLine();
		System.out.print("Generos disponibles:");
		System.out.print("\n- ROCK \n- HIPHOP \n- CLASICA \n- REGGAE \n- SALSA \n- METAL \n");
		System.out.print("Genero de la cancion: ");
		String genre = sc.nextLine().toUpperCase();
		while(!app.verifyGenre(genre)){
			System.out.println("Genero invalido");
			System.out.print("Genero de la cancion: ");
			genre = sc.nextLine().toUpperCase();
		}
		System.out.println("***ESTADO: " + app.addPoolSong(user, title, artist, releaseDate, minutes, seconds, genre));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to register a playlist. <br>
	* <b>pre:</b><br>
	* <b>post:</b> playlist created or playlist has not been created. <br>
	*/
	public void readPlaylistData(){
		String[] owners = new String[5];
		System.out.println("\n***ACCION: Crear Playlist");
		System.out.print("Nombre de la playlist: ");
		String title = sc.nextLine();
		System.out.print("PLAYLISTS DISPONIBLES");
		System.out.print("\n[1] Publica \n[2] Privada \n[3] Restringida");
		System.out.print("\nOpcion: ");
		int option = sc.nextInt();
		sc.nextLine();
		switch(option){
			case PUBLIC:
				System.out.println("***ESTADO: " + app.addPlaylist(title));
				break;
			case PRIVATE:
				System.out.print("Nombre de usuario que crea la playlist: ");
				String owner = sc.nextLine();
				while(!app.findUser(owner)){
					System.out.println("El usuario ingresado no existe, ingrese otro");
					System.out.print("Nombre de usuario que crea la playlist: ");
					owner = sc.nextLine();
				}
				System.out.println("***ESTADO: " + app.addPlaylist(owner, title));
				break;
			case RESTRICTED:
				int i = 0;
				boolean stop = false;
				option = 0;
				while(!stop || i > 5){
					System.out.print("OPCIONES: ");
					System.out.print("\n[1] Agregar propietarios \n[cualquier otro numero] Dejar de agregar");
					System.out.print("\nOpcion: ");
					option = sc.nextInt();
					sc.nextLine();
					if(option == 1){
						System.out.print("Nombre del propietario #" + (i+1) +": ");
						owner = sc.nextLine();
						if(!app.findUser(owner)){
							System.out.println("El usuario ingresado no existe");
						}
						else{
							owners[i] = owner;
							i++;
						}
					}
					else if(owners[0] == null){
						System.out.println("Debe haber por lo menos un propietario");
					}
					else
						stop = true;
				}
				System.out.println("***ESTADO: " + app.addPlaylist(owners, title));
				break;
			default:
				System.out.println("Opcion invalida");
		}
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to add a song in a playlist. <br>
	* <b>pre:</b><br>
	* <b>post:</b> song added to the playlist or song not added to the playlist. <br>
	*/
	public void addSongToPlaylist(){ //por hacer
		System.out.println("\n***ACCION: Agregar cancion a una playlist");
		System.out.println("Playlists disponibles: ");
		System.out.println(app.showPlaylists());
		System.out.print("Numero de playlist a agregar cancion: ");
		int plIndex = sc.nextInt();
		sc.nextLine();
		while(plIndex <= 0 || plIndex > app.amountPlaylists()){
			System.out.println("La opcion no es valida");
			System.out.print("Numero de playlist a agregar cancion: ");
			plIndex = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("\nCanciones disponibles: ");
		System.out.println(app.showPoolSongs());
		System.out.print("Numero de cancion a agregar: ");
		int sIndex = sc.nextInt();
		sc.nextLine();
		while(sIndex < 1 || sIndex > app.amountSongs()){
			System.out.println("La opcion no es valida");
			System.out.print("Numero de cancion a agregar cancion: ");
			sIndex = sc.nextInt();
			sc.nextLine();
		}
		System.out.println("***ESTADO: " + app.addSongToPlaylist(plIndex, sIndex));
		sc.nextLine();
	}
	
	/**
	* Reads the necessary data to rate a playlist. <br>
	* <b>pre:</b> <br>
	* <b>post:</b> playlist has been rated. <br>
	*/
	public void ratePlaylist(){
		System.out.println("\n***ACCION: Calificar una playlist publica");
		System.out.println("Playlists publicas disponibles: ");
		System.out.println(app.showPublicPlaylists());
		System.out.print("Numero de playlist a calificar: ");
		int plIndex = sc.nextInt();
		sc.nextLine();
		while(plIndex <= 0 || plIndex > app.amountPublicPlaylists()){
			System.out.println("La opcion no es valida");
			System.out.print("Numero de playlist a calificar: ");
			plIndex = sc.nextInt();
			sc.nextLine();
		}
		System.out.print("Calificacion de 1 - 5: ");
		double score = sc.nextDouble();
		while(score < 1 || score >5){
			System.out.println("La calificacion no es valida");
			System.out.print("Calificacion de 1 - 5: ");
			score = sc.nextDouble();
		}
		app.ratePublicPlaylist(plIndex, score);
		sc.nextLine();
	}
	
	/**
	* Decides the option to be executed. <br>
	* <b>pre:</b> option is initialized. <br>
	* <b>post:</b> result of the option previously selected. <br>
	* @param option Option selected previously on the menu. option >0. option != null.
	*/
	public void doOperation(int option){
		switch(option){
			case ADD_USER:
				readUserData(); //hecho
				break;
			case ADD_SONG_TO_POOL:
				if(app.amountUsers() == 0){
					System.out.println("\nDebe registrar por lo menos un usuario para usar esta opcion");
				}
				else{
					readSongData();
				}
				break;
			case ADD_PLAYLIST:
				if(app.amountUsers() == 0){
					System.out.println("\nDebe registrar por lo menos un usuario para usar esta opcion");
				}
				else{
					readPlaylistData();
				}
				break;
			case ADD_SONG_TO_PLAYLIST:
				if(app.amountSongs() == 0 || app.amountPlaylists() == 0){
					System.out.println("\nDebe registrar por lo menos una cancion y playlist para usar esta opcion");
				}
				else{
					addSongToPlaylist();
				}
				break;
			case RATE_PLAYLIST: 
				if(app.amountPublicPlaylists() == 0){
					System.out.println("\nAun no hay playlists publicas para calificar");
				}
				else{
					ratePlaylist();
				}
				break;
			case SHOW_USERS:
				if(app.amountUsers() == 0){
					System.out.println("\nAun no hay usuarios registrados");
				}
				else{
					System.out.print("\n***ACCION: Listar usuarios");
					System.out.println(app.showUsers());
					System.out.println("***ESTADO: Completado");
					sc.nextLine();
				}
				break;
			case SHOW_SONGS:
				if(app.amountSongs() == 0){
					System.out.println("\nAun no hay canciones registradas");
				}
				else{
					System.out.print("\n***ACCION: Listar canciones");
					System.out.println(app.showPoolSongs());
					System.out.println("***ESTADO: Completado");
					sc.nextLine();
				}
				break;
			case SHOW_PLAYLISTS:
				if(app.amountPlaylists() == 0){
					System.out.println("\nAun no hay playlists registradas");
				}
				else{
					System.out.print("\n***ACCION: Listar playlists");
					System.out.println(app.showPlaylists());
					System.out.println("***ESTADO: Completado");
					sc.nextLine();
				}
				break;
			case EXIT:
				break;
			default:
				System.out.println("Opcion invalida");
		}
	}
	
	/**
	* Allows the user to use the class services. <br>
	* <b>pre:</b>
	* <b>post:</b> The result of the action executed. <br>
	*/
	public void startProgram(){
		int option;
		showLogo();
		do{
			showMenu();
			option = readOption();
			doOperation(option);
		}while(option != 9);
	}
}