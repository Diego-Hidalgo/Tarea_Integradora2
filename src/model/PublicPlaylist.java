package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class PublicPlaylist extends Playlist{
	
	private double avScore; // Public playlist average score
	
	/**
	* Constructor of the PublicPlaylist class. <br>
	* <b>pre:</b> title is initialized. <br>
	* <b>post:</b> PublicPlaylist class object create. <br>
	* @param title Playlist title. title != "". title != null.
	*/
	public PublicPlaylist(String title){
		super(title);
		avScore = 0;
	}
	
	/**
	* Changes the average score of the playlist. <br>
	* <b>pre:</b> average score is initialized. <br>
	* <b>post:</b> average score has been changed. <br>
	* @param avScore New avScore of the playlist. avScore > 0. avScore != null.
	*/
	public void setAvScore(double avScore){
		this.avScore = avScore;
	}
	
	/**
	* Returns the average score of the playlist. <br>
	* <b>pre:</b>avScore is initialized. avScore is not null<br>
	* <b>post:</b> avScore of the playlist. <br>
	*/
	public double getAvScore(){
		return avScore;
	}
	
	/**
	* Updates the average score of the playlist. <br>
	* <b>pre:</b> average score is initialized. <br>
	* <b>post:</b> average score has been changed. <br>
	* @param score Score given by an user to the playlist. score > 0. score != null.
	*/
	public void updateAvScore(double score){
		double avScore = 0;
		if(getAvScore() > 0){
			avScore = (score + getAvScore())/2;
		}
		else{
			avScore = score;
		}
		setAvScore(avScore);
	}
	
	/**
	* Saves the info of the playlist. <br>
	* <b>pre:</b>avScore is initialized.<br>
	* <b>post:</b> info of the public playlist.<br>
	*/
	@Override
	public String showInfo(){
		String info;
		info = super.showInfo() +
		"\n** Average score: " + avScore +
		"\n***********************************";
		return info;
	}
}