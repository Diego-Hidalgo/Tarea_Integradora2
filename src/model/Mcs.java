package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class Mcs{

	private User[] users;
	private Song[] pool;
	private Playlist[] playlists;

	/**
	* Constructor of the Mcs class. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Mcs class object created. <br>
	*/
	public Mcs(){
		users = new User[10];
		pool = new Song[30];
		playlists = new Playlist[20];
	}
	
	/**
	* Searches for an empty space on a given String. <br>
	* <b>pre:</b> name is initialized. <br>
	* <b>post:</b> True if there's an empty space, false if not. <br>
	* @param name String to use. name != null.
	*/
	public boolean findBlanks(String name){
		boolean find = false;
		for(int i = 0; i<name.length() && !find; i++){
			if(name.charAt(i) == ' '){
				find = true;
			}
		}
		return find;
	}
	
	/**
	* Searches for an user. <br>
	* <b>pre:</b> User list is initialized. Name is initialized <br>
	* <b>post:</b> True if the user exists, false if not. <br>
	* @param user Name of the user to search. user != null.
	*/
	public boolean findUser(String name){
		boolean find = false;
		for(int i = 0; i<users.length && !find; i++){
			if(users[i] != null){
				if(name.equals(users[i].getName())){
					find = true;
				}
			}
		}
		return find;
	}
	
	/**
	* Searches for an genre on a list. <br>
	* <b>pre:</b> genre is initialized. <br>
	* <b>post:</b> True if the genre exists, false if not. <br>
	* @param genre Genre to search. genre != null.
	*/
	public boolean verifyGenre(String genre){
		boolean verify = false;
		Genre[] list = Genre.values();
		for(int i = 0; i<list.length && !verify; i++){
			if(list[i].toString().equals(genre)){
				verify = true;
			}
		}
		return verify;
	}
	
	/**
	* Adds a new user.<br>
	* <b>pre:</b> parameters are initialized. User list is initialized. <br>
	* <b>post:</b> User added sucesfully or User could not be added. <br>
	* @param name User name. name != "". name != null.
	* @param passWord User passWord. passWord != "". passWord != null.
	* @param age User age. age > 0. age != null.
	*/
	public String addUser(String name, String passWord, int age){
		String msg = "No se pudo agregar al usuario. Se ha alcanzado el maximo permitido.";
		boolean add = false;
		for(int i = 0; i<users.length && !add; i++){
			if(users[i] == null){
				users[i] = new User(name, passWord, age);
				msg = "Usuario agregado correctamente.";
				add = true;
			}
		}
		return msg;
	}
	
	/**
	* Adds a new song.<br>
	* <b>pre:</b> parameters are initialized. Song list is initialized. <br>
	* <b>post:</b> Song was sucesfully added or Song could not be added. <br>
	* @param name Name of the user who adds the song. name != "". name != null.
	* @param title Song title. title != "". title != null.
	* @param artist Song artist. artist != "". artist != null.
	* @param releaseDate Song release date. releaseDate != "". releaseDate != null.
	* @param minutes Song minutes duration. minutes > 0. minutes != null.
	* @param seconds Song seconds duration. seconds > 0. seconds != null.
	* @param genre Song genre. genre != "". genre != null.
	*/
	public String addPoolSong(String name, String title, String artist, String releaseDate, int minutes, int seconds, String genre){
		String msg = "No se pudo agregar la cancion al pool. Se ha alcanzado el maximo permitido.";
		boolean add = false;
		for(int i = 0; i<users.length && !add; i++){
			if(users[i] != null){
				if(name.equals(users[i].getName())){
					for(int j = 0; j<pool.length && !add; j++){
						if(pool[j] == null){
							pool[j] = new Song(title, artist, releaseDate, minutes, seconds, genre);
							pool[j].setDuration();
							users[i].setSharedSongs();
							users[i].updateCategory();
							msg = "Cancion agregada al pool correctamente.";
							add = true;
						}
					}
				}
			}
		}
		return msg;
	}
	
	/**
	* Adds a new private playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist list is initialized.<br>
	* <b>post:</b> Playlist sucesfully added or Playlist could not be added.<br>
	* @param owner Playlist owner. owner != "". owner != null.
	* @param title Playlist title. title != "". title != null.
	*/
	public String addPlaylist(String owner ,String title){
		String msg = "No se pudo agregar la playlist. Se ha alcanzado el maximo permitido.";
		boolean add = false;
		for(int i = 0; i<playlists.length && !add; i++){
			if(playlists[i] == null){
				playlists[i] = new PrivatePlaylist(owner, title);
				msg = "Playlist privada agregada correctamente.";
				add = true;
			}
		}
		return msg;
	}
	
	/**
	* Adds a new public playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist list is initialized.<br>
	* <b>post:</b> Playlist added sucesfully or playlist could not be added.<br>
	* @param title Playlist title. title != "". title != null.
	*/
	public String addPlaylist(String title){
		String msg = "No se pudo agregar la playlist. Se ha alcanzado el maximo permitido.";
		boolean add = false;
		for(int i = 0; i<playlists.length && !add; i++){
			if(playlists[i] == null){
				playlists[i] = new PublicPlaylist(title);
				msg = "Playlist publica agregada correctamente.";
				add = true;
			}
		}
		return msg;
	}
	
	/**
	* Adds a new restricted playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist list is initialized.<br>
	* <b>post:</b> Playlist sucesfully added or Playlist could not be added.<br>
	* @param owners Playlist owners. owners != "". owners != null.
	* @param title Playlist title. title != "". title != null.
	*/
	public String addPlaylist(String[] owners, String title){
		String msg = "No se pudo agregar la playlist. Se ha alcanzado el maximo permitido.";
		boolean add = false;
		for(int i = 0; i<playlists.length && !add; i++){
			if(playlists[i] == null){
				playlists[i] = new RestrictedPlaylist(owners, title);
				msg = "Playlist restringida agregada correctamente.";
				add = true;
			}
		}
		return msg;
	}
	
	/**
	* Adds a song to a playlist.<br>
	* <b>pre:</b> parameters are initialized. Song list is initialized. Playlist list is initialized.<br>
	* <b>post:</b> Song sucesfully added to playlist or Song could not be added. <br>
	* @param owners Playlist owners. owners != "". owners != null.
	* @param title Playlist title. title != "". title != null.
	*/
	public String addSongToPlaylist(int plIndex, int sIndex){
		String msg = "No se pudo agregar la cancion a la playlist. Se ha alcanzado el maximo permitido.";
		boolean add = playlists[plIndex-1].addSong(pool[sIndex-1]);
		if(add){
			playlists[plIndex-1].updateGenres(pool[sIndex-1].getGenre());
			playlists[plIndex-1].updateDuration();
			msg = "Cancion agregada correctamente a la playlist";
		}
		return msg;
	}
	
	/**
	* Rates a public playlist.<br>
	* <b>pre:</b> parameters are initialized. Song list is initialized. Playlist list is initialized.<br>
	* <b>post:</b> The public playlist was rated. <br>
	*/
	public void ratePublicPlaylist(int plIndex, double score){
		int count = 0;
		boolean stop = false;
		for(int i = 0; i<playlists.length && !stop; i++){
			if(playlists[i] != null){
				if(playlists[i] instanceof PublicPlaylist){
					count ++;
					if(count == plIndex){
						PublicPlaylist playlist = (PublicPlaylist) playlists[i];
						playlist.updateAvScore(score);
						stop = true;
					}
				}
			}
		}
	}
	
	/**
	* Saves the info of the users on a String.<br>
	* <b>pre:</b> Users list is initialized.<br>
	* <b>post:</b> info of the users.<br>
	*/
	public String showUsers(){
		String info = "";
		for(int i = 0; i<users.length; i++){
			if(users[i] != null){
				info += users[i].showInfo();
			}
		}
		return info;
	}
	
	/**
	* Saves the info of the songs on a String.<br>
	* <b>pre:</b> Pool of songs is initialized.<br>
	* <b>post:</b> info of the songs.<br>
	*/
	public String showPoolSongs(){
		String info = "";
		for(int i = 0; i<pool.length; i++){
			if(pool[i] != null){
				info += "\n[" + (i+1) + "]" + pool[i].showInfo();
			}
		}
		return info;
	}
	
	/**
	* Saves the info of the playlists on a String.<br>
	* <b>pre:</b> Playlist list is initialized.<br>
	* <b>post:</b> info of the playlists.<br>
	*/
	public String showPlaylists(){
		String info = "";
		for(int i = 0; i<playlists.length; i++){
			if(playlists[i] != null){
				info += "\n[" + (i+1) + "]" + playlists[i].showInfo();
			}
		}
		return info;
	}
	
	/**
	* Saves the info of the public playlists on a String.<br>
	* <b>pre:</b> Playlist list is initialized.<br>
	* <b>post:</b> info of the public playlists.<br>
	*/
	public String showPublicPlaylists(){
		String info = "";
		for(int i = 0; i<playlists.length; i++){
			if(playlists[i] != null){
				if(playlists[i] instanceof PublicPlaylist){
					info += "\n[" + (i+1) + "]" + playlists[i].showInfo();
				}
			}
		}
		return info;
	}
	
	/**
	* Counts the amount of users.<br>
	* <b>pre:</b> User list is initialized.<br>
	* <b>post:</b> amount of users.<br>
	*/
	public int amountUsers(){
		int count = 0;
		for(int i = 0; i<users.length; i++){
			if(users[i] != null){
				count++;
			}
		}
		return count;
	}
	
	/**
	* Counts the amount of songs.<br>
	* <b>pre:</b> Pool of songs is initialized.<br>
	* <b>post:</b> amount of songs.<br>
	*/
	public int amountSongs(){
		int count = 0;
		for(int i = 0; i<pool.length; i++){
			if(pool[i] != null){
				count++;
			}
		}
		return count;
	}
	
	/**
	* Counts the amount of playlists. <br>
	* <b>pre:</b> Playlist list is initialized. <br>
	* <b>post:</b> amount of playlists. <br>
	*/
	public int amountPlaylists(){
		int count = 0;
		for(int i = 0; i<playlists.length; i++){
			if(playlists[i] != null){
				count++;
			}
		}
		return count;
	}
	
	/**
	* Counts the amount of public playlists.<br>
	* <b>pre:</b>Playlist list is initialized.<br>
	* <b>post:</b> amount of public playlists.<br>
	*/
	public int amountPublicPlaylists(){
		int count = 0;
		for(int i = 0; i<playlists.length; i++){
			if(playlists[i] != null){
				if(playlists[i] instanceof PublicPlaylist){
					count ++;
				}
			}
		}
		return count;
	}
}