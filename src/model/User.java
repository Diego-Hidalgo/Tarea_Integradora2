package model;
/**
* @author Diego Hidalgo Lopez.
*/
public class User{
	
	private String name; // User name
	private String passWord; // User password
	private int age; // User age
	private int sharedSongs; // Amount of songs that the user has added to the pool
	private Category category; // User category
	
	/**
	* Constructor of the User class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> User class object created. <br>
	* @param name User name. name != "". name != null.
	* @param passWord User password. passWord != "". passWord != null.
	* @param age User age. age >0. age != null.
	*/
	public User(String name, String passWord, int age){
		this.name = name;
		this.passWord = passWord;
		this.age = age;
		sharedSongs = 0;
		category = Category.NEWBIE;
	}
	
	/**
	* Changes the name of the user. <br>
	* <b>pre:</b> name is initialized. <br>
	* <b>post:</b> name has been changed. <br>
	* @param name New name of the user. name != "". name != null.
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* Returns the name of the user. <br>
	* <b>pre:</b>The name is not null. name is initialized<br>
	* <b>post:</b> name of the user. <br>
	*/
	public String getName(){
		return name;
	}
	
	/**
	* Changes the passWord of the user. <br>
	* <b>pre:</b> passWord is initialized. <br>
	* <b>post:</b> passWord has been changed. <br>
	* @param passWord New passWord of the user. passWord != "". passWord != null.
	*/
	public void setPassWord(String passWord){
		this.passWord = passWord;
	}
	
	/**
	* Returns the passWord of the user. <br>
	* <b>pre:</b>The passWord is not null. passWord is initialized<br>
	* <b>post:</b> passWord of the user. <br>
	*/
	public String getPassWord(){
		return passWord;
	}
	
	/**
	* Changes the age of the user. <br>
	* <b>pre:</b> age is initialized. <br>
	* <b>post:</b> age has been changed. <br>
	* @param age New age of the user. age > 0 age != null.
	*/
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	* Returns the age of the user. <br>
	* <b>pre:</b>The age is not null. age is initialized.<br>
	* <b>post:</b> age of the user. <br>
	*/
	public int getAge(){
		return age;
	}
	
	/**
	* Changes the amount of shared songs of the user. <br>
	* <b>pre:</b> sharedSongs is initialized. <br>
	* <b>post:</b> sharedSongs has been changed. <br>
	* @param sharedSongs New amount of shared songs of the user. sharedSongs > 0 sharedSongs != null.
	*/
	public void setSharedSongs(int sharedSongs){
		this.sharedSongs = sharedSongs;
	}
	
	/**
	* Increases the amount of shared songs of the user in one. <br>
	* <b>pre:</b><br>
	* <b>post:</b> sharedSongs has been changed. <br>
	*/
	public void setSharedSongs(){
		sharedSongs++;
	}
	
	/**
	* Returns the amount of shared songs of the user. <br>
	* <b>pre:</b>sharedSongs is not null. sharedSongs is initialized.<br>
	* <b>post:</b> sharedSongs of the user. <br>
	*/
	public int getSharedSongs(){
		return sharedSongs;
	}
	
	/**
	* Changes the category of the user. <br>
	* <b>pre:</b> category is initialized. <br>
	* <b>post:</b> category has been changed. <br>
	* @param category New category of the user. category != "". category != null.
	*/
	public void setCategory(String category){
		this.category = Category.valueOf(category);
	}
	
	/**
	* Returns the category of the user. <br>
	* <b>pre:</b>category is not null. category is initialized.<br>
	* <b>post:</b> category of the user. <br>
	*/
	public Category getCategory(){
		return category;
	}
	
	/**
	* Updates the category of the user. <br>
	* <b>pre:</b>sharedSongs is not null. shared is initialized.<br>
	* <b>post:</b> category has been updated. <br>
	*/
	public void updateCategory(){
		if(sharedSongs == 3){
			setCategory("LITTLECONTRIBUTOR");
		}
		else if(sharedSongs == 10){
			setCategory("MILDCONTRIBUTOR");
		}
		else if(sharedSongs == 30){
			setCategory("STARCONTRIBUTOR");
		}
	}
	
	/**
	* Saves the info of the user on a special format.<br>
	* <b>pre:</b>name, age and category are initialized.<br>
	* <b>post:</b> info of the user.<br>
	*/
	public String showInfo(){
		String info;
		info = "\n*************  User **************" +
		"\n**  UserName: " + name +
		"\n**  Age: " + age +
		"\n**  Category: " + category +
		"\n***********************************";
		return info;
	}
}