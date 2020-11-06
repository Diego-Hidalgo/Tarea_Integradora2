package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class Song{
	
	private String title; // Song title
	private String artist; // Song artist or band
	private String releaseDate; // Song release date
	private int minutes; // Song minutes duration
	private int seconds; // Song seconds duration
	private Genre genre; // Song genre
	
	/**
	* Constructor of the Song class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> Song class object created. <br>
	* @param title Song title. title != "". title != null.
	* @param artist Song artist. artist != "". artist != null.
	* @param releaseDate Song release date. releaseDate != "". releaseDate != null
	* @param minutes Song minutes duration. minutes > 0. minutes != null.
	* @param seconds Song seconds duration. seconds > 0. seconds != null.
	* @param genre Song genre. genre != "". genre != null.
	*/
	public Song(String title, String artist, String releaseDate, int minutes, int seconds, String genre){
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.minutes = minutes;
		this.seconds = seconds;
		this.genre = Genre.valueOf(genre);
	}
	
	/**
	* Changes the title of the song. <br>
	* <b>pre:</b> title is initialized. <br>
	* <b>post:</b> title has been changed. <br>
	* @param title New title of the song. title != "". title != null.
	*/
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	* Returns the title of the song. <br>
	* <b>pre:</b> title is initialized. title is not null.<br>
	* <b>post:</b> title of the song. <br>
	*/
	public String getTitle(){
		return title;
	}
	
	/**
	* Changes the artist of the song. <br>
	* <b>pre:</b> artist is initialized. <br>
	* <b>post:</b> artist has been changed. <br>
	* @param artist New artist of the song. artist != "". artist != null.
	*/
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	/**
	* Returns the artist of the song. <br>
	* <b>pre:</b>artist is initialized. artist is not null. <br>
	* <b>post:</b> artist of the song. <br>
	*/
	public String getArtist(){
		return artist;
	}
	
	/**
	* Changes the release date of the song. <br>
	* <b>pre:</b> releaseDate is initialized. <br>
	* <b>post:</b> releaseDate has been changed. <br>
	* @param releaseDate New release date of the song. releaseDate != "". releaseDate != null.
	*/
	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}
	
	/**
	* Returns the release date of the song. <br>
	* <b>pre:</b>releaseDate is not null. releaseDate is initialized<br>
	* <b>post:</b> release date of the song. <br>
	*/
	public String getReleaseDate(){
		return releaseDate;
	}
	
	/**
	* Changes the minutes of duration of the song. <br>
	* <b>pre:</b> minutes is initialized. <br>
	* <b>post:</b> minutes has been changed. <br>
	* @param minutes New minutes of the song. minutes >0. minutes != null.
	*/
	public void setMinutes(int minutes){
		this.minutes = minutes;
	}
	
	/**
	* Returns the minutes of duration of the song. <br>
	* <b>pre:</b>minutes is initialized. minutes is not null.<br>
	* <b>post:</b> minutes of the song. <br>
	*/
	public int getMinutes(){
		return minutes;
	}
	
	/**
	* Changes the seconds of duration of the song. <br>
	* <b>pre:</b> seconds is initialized. <br>
	* <b>post:</b> seconds has been changed. <br>
	* @param seconds New seconds of the song. seconds >0. seconds != null.
	*/
	public void setSeconds(int seconds){
		this.seconds = seconds;
	}
	
	/**
	* Returns the seconds of duration of the song. <br>
	* <b>pre:</b>seconds is initialized. seconds is not null. <br>
	* <b>post:</b> seconds of the song. <br>
	*/
	public int getSeconds(){
		return seconds;
	}
	
	/**
	* Changes the genre of the song. <br>
	* <b>pre:</b> genre is initialized. <br>
	* <b>post:</b> genre has been changed. <br>
	* @param genre New genre of the song. genre != "". genre != null.
	*/
	public void setGenre(String genre){
		this.genre = Genre.valueOf(genre);
	}
	
	/**
	* Returns the genre of the song. <br>
	* <b>pre:</b>genres is not null. genre is initialized<br>
	* <b>post:</b> Genre of the song. <br>
	*/
	public Genre getGenre(){
		return genre;
	}
	
	/**
	* Changes the minutes and seconds of the song. <br>
	* <b>pre:</b>minutes and seconds are initialized. <br>
	* <b>post:</b> duration has been changed. <br>
	*/
	public void setDuration(){
		int minutes = getMinutes();
		int seconds = getSeconds();
		while(seconds >= 60){
			minutes ++;
			seconds -=60;
		}
		setMinutes(minutes);
		setSeconds(seconds);
	}
	
	/**
	* Saves the the minutes and seconds on a String. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Duration of the song.<br>
	*/
	public String durationInfo(){
		String info = getMinutes() + ":" + getSeconds();
		return info;
	}
	
	/**
	* Saves the info of the song on a special format. <br>
	* <b>pre:</b>title, artist, minutes, seconds and genre are initialized.<br>
	* <b>post:</b> Info of the song.<br>
	*/
	public String showInfo(){
		String info;
		info = "\n**************  Song **************" +
		"\n**  Title: " + title +
		"\n**  Artist: " + artist +
		"\n**  Duration: " + durationInfo() +
		"\n**  Genre: " + genre +
		"\n***********************************";
		return info;
	}
}