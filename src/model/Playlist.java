package model;
/**
* @author Diego Hidalgo Lopez.
*/
public abstract class Playlist{
	
	private String title; // Playlist title
	private Song[] songs; // Playlist songs
	private Genre[] genres; // Playlist genres
	private int minutes; // Playlist minutes duration
	private int seconds; // Playlist seconds duration
	
	
	/**
	* Constructor of the Playlist class. <br>
	* <b>pre:</b> title is initialized. <br>
	* <b>post:</b> Playlist class object created. <br>
	* param title Playlist title. title != "". title != null.
	*/
	public Playlist(String title){
		this.title = title;
		songs = new Song[30];
		genres = new Genre[6];
		minutes = 0;
		seconds = 0;
	}
	
	/**
	* Changes the title of the playlist.<br>
	* <b>pre:</b> title is initialized. <br>
	* <b>post:</b> title has been changed. <br>
	* @param title New title of the playlist. title != "". title != null.
	*/
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	* Returns the title of the playlist. <br>
	* <b>pre:</b>title is initialized . title is not null.<br>
	* <b>post:</b> title of the playlist. <br>
	*/
	public String getTitle(){
		return title;
	}
	
	/**
	* Changes the minutes of duration of the playlist. <br>
	* <b>pre:</b> minutes is initialized. <br>
	* <b>post:</b> minutes has been changed. <br>
	* @param minutes New minutes of the playlist. minutes >0. minutes != null.
	*/
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	/**
	* Returns the minutes of duration of the playlist. <br>
	* <b>pre:</b>minutes is initialized. minutes is not null. <br>
	* <b>post:</b> minutes of the playlist. <br>
	*/
	public int getMinutes(){
		return minutes;
	}
	
	/**
	* Changes the seconds of duration of the playlist. <br>
	* <b>pre:</b> seconds is initialized. <br>
	* <b>post:</b> seconds has been changed. <br>
	* @param seconds New seconds of the playlist. seconds >0. seconds != null.
	*/
	public void setSeconds(int seconds){
		this.seconds = seconds;
	}
	
	/**
	* Returns the seconds of duration of the playlist. <br>
	* <b>pre:</b>seconds is initialized. seconds is not null.<br>
	* <b>post:</b> seconds of the playlist. <br>
	*/
	public int getSeconds(){
		return seconds;
	}
	
	/**
	* Adds a genre to the playlist. <br>
	* <b>pre:</b> genre is initialized. <br>
	* <b>post:</b> genre has been changed. <br>
	* @param genre New genre of the playlist. genre != "". genres != null.
	*/
	public void setGenre(String genre){
		boolean set = false;
		for(int i = 0; i<genres.length && !set; i++){
			if(genres[i] == null){
				genres[i] = Genre.valueOf(genre);
				set = true;
			}
		}
	}
	
	/**
	* Returns the genres of the playlist.<br>
	* <b>pre:</b>genres is initialized. genres is not null. <br>
	* <b>post:</b> genres of the playlist. <br>
	*/
	public Genre[] getGenres(){
		return genres;
	}
	
	/**
	* Adds a song to the playlist.<br>
	* <b>pre:</b> song is initialized. <br>
	* <b>post:</b> song has been changed. <br>
	* @param song Song to add to the playlist. song != null.
	*/
	public boolean addSong(Song song){
		boolean add = false;
		for(int i = 0; i<songs.length && !add; i++){
			if(songs[i] == null){
				songs[i] = song;
				add = true;
			}
		}
		return add;
	}
	
	/**
	* Updates the minutes and seconds of duration of the playlist. <br>
	* <b>pre:</b>minutes and seconds are initialized. <br>
	* <b>post:</b> minutes and seconds updated. <br>
	*/
	public void updateDuration(){
		int minutes = 0;
		int seconds = 0;
		for(int i = 0; i<songs.length; i++){
			if(songs[i] != null){
				minutes += songs[i].getMinutes();
				seconds += songs[i].getSeconds();
			}
		}
		while(seconds>=60){
			minutes ++;
			seconds -= 60;
		}
		setMinutes(minutes);
		setSeconds(seconds);
	}
	
	/**
	* Updates the genres of the playlist. <br>
	* <b>pre:</b><br>
	* <b>post:</b> genres updated. <br>
	*/
	public void updateGenres(Genre genre){
		boolean update = false;
		boolean exists = false;
		for(int i = 0; i<genres.length && !update; i++){
			if(genres[i] != null){
				if(genres[i] == genre){
					exists = true;
				}
			}
			else if(!exists){
				genres[i] = genre;
				update = true;
			}
		}
	}
	
	
	/**
	* Saves the duration of the playlist in format minutes:seconds on a String. <br>
	* <b>pre:</b><br>
	* <b>post:</b> duration of the playlist. <br>
	*/
	public String durationInfo(){
		String info;
		info = minutes + ":" + seconds;
		return info;
	}
	
	/**
	* Saves the genres of the playlist on a String. <br>
	* <b>pre:</b><br>
	* <b>post:</b> genres of the playlist. <br>
	*/
	public String genresInfo(){ //por hacer
		String info = "";
		for(int i = 0; i<genres.length; i++){
			if(genres[i] != null){
				info += genres[i] + " ";
			}
		}
		return info;
	}
	
	/**
	* Saves the info of the playlist. <br>
	* <b>pre:</b>title, minutes, seconds and genres are initialized.<br>
	* <b>post:</b> info of the playlist.<br>
	*/
	public String showInfo(){
		String info;
		info = "\n*************  Playlist **************" +
		"\n**  Title: " + title +
		"\n** Duration: " + durationInfo() +
		"\n** Genres: " + genresInfo();
		return info;
	}
}