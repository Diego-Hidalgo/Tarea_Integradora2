package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class PrivatePlaylist extends Playlist{
	
	private String owner; // Private playlist owner
	
	/**
	* Constructor of the PrivatePlaylist class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> PrivatePlaylist class object created. <br>
	* @param owner Playlist owner. owner != "". owner != null.
	* @param title Playlist title. title != "". title != null.
	*/
	public PrivatePlaylist(String owner, String title){
		super(title);
		this.owner = owner;
	}
	
	/**
	* Changes the owner of the playlist. <br>
	* <b>pre:</b> owner is initialized. <br>
	* <b>post:</b> owner has been changed. <br>
	* @param owner New owner of the playlist. owner != "". owner != null.
	*/
	public void setOwner(String owner){
		this.owner = owner;
	}
	
	/**
	* Returns the owner of the playlist. <br>
	* <b>pre:</b> owner is initialized. owner is not null<br>
	* <b>post:</b> owner of the playlist. <br>
	*/
	public String getOwner(){
		return owner;
	}
	
	/**
	* Saves the info of the playlist. <br>
	* <b>pre:</b><br>
	* <b>post:</b> info of the private playlist.<br>
	*/
	@Override
	public String showInfo(){
		String info; 
		info = super.showInfo() +
		"\n** Owner: " + owner +
		"\n***********************************";
		return info;
	}
}