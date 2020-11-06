package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class RestrictedPlaylist extends Playlist{
	
	private String[] owners; // Restricted playlist owners
	
	/**
	* Constructor of the RestrictedPlaylist class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> RestrictedPlaylist class object created. <br>
	* @param title Playlist title. title != "". title != null
	* @param owners Playlist owners. owners != "". owners != null
	*/
	public RestrictedPlaylist(String[] owners, String title){
		super(title);
		this.owners = owners;
	}
	
	/**
	* Changes the owners of the playlist.<br>
	* <b>pre:</b> owners is initialized. <br>
	* <b>post:</b> owners have been changed. <br>
	* @param owners New owners of the playlist. owners != "". owners != null.
	*/
	public void setOwners(String[] owners){
		this.owners = owners;
	}
	
	/**
	* Returns the owners of the playlist. <br>
	* <b>pre:</b>owners is initialized. owners is not null<br>
	* <b>post:</b> owners of the playlist. <br>
	*/
	public String[] getOwners(){
		return owners;
	}
	
	/**
	* Saves the owners of the playlist on a String. <br>
	* <b>pre:</b>owners is initialized.<br>
	* <b>post:</b> owners of the playlist. <br>
	*/
	public String ownersInfo(){
		String info = "";
		for(int i = 0; i<owners.length; i++){
			if(owners[i] != null){
				info += owners[i] + " ";
			}
		}
		return info;
	}
	
	/**
	* Saves the info of the playlist. <br>
	* <b>pre:</b><br>
	* <b>post:</b> info of the  restricted playlist.<br>
	*/
	@Override
	public String showInfo(){
		String info;
		info = super.showInfo() +
		"\n** Propietarios: " + ownersInfo() +
		"\n***********************************";
		return info;
	}
}