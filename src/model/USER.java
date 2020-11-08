package model;

public class USER{

	//Relationships
	private Category categories;

	//Constant
	public final static int USERS = 10;

	//Atributes
	private String userName;
	private String password;
	private int age;
	private Category category;
	private int countSong;

	//Methods
	/** 
	*Name: USER.
	*Constructor of USER <br> 
	*<b> post: </b> Start the class USER.
   */
	public USER(String userName, String password, int age){
		this.userName = userName;
		this.password = password;
		this.age = age;
		category = Category.NEWBIE;
		countSong = 0;
	}//end constructor

	/** 
		*Name: getUserName.
		*Get the name of the user <br>   
		*<b> post: </b> get the name of the user.
		*@return String userName. This is the name of the user.
	   */
	public String getUserName(){
		return userName;
	}//end Get

	/** 
		*Name: setUserName.
		*Change the name of the user <br>   
		*<b> post: </b> the new name of the user.
	   */
	public void setUserName(String userName){
		this.userName = userName;
	}//end set

	/**Name: getPassword.
		*Get the password of the user <br>   
		*<b> post: </b> get the password of the user.
		*@return String password. This is the password of the user.
	   */
	public String getPassword(){
		return password;
	}//end get

	/** 
		*Name: setPassword.
		*Change the password of the user <br>   
		*<b> post: </b> the new password of the user.
	   */
	public void setPassword(String password){
		this.password = password;
	}//end set

	/**Name: getAge.
		*Get the age of the user <br>   
		*<b> post: </b> get the age of the user.
		*@return int age. This is the age of the user.
	   */
	public int getAge(){
		return age;
	}//end get

	/** 
		*Name: setAge.
		*Change the age of the user <br>   
		*<b> post: </b> the new age of the user.
	   */
	public void setAge(int age){
		this.age = age;
	}//end set

	/**Name: getCategory.
		*Get the category of the user <br>   
		*<b> post: </b> get the category of the user.
		*@return Category category. This is the category of the user.
	   */
	public Category getCategory(){
		return category;
	}//End get

	/** 
		*Name: setCategory.
		*Change the category of the user <br>   
		*<b> post: </b> the new category of the user.
	   */
	public void setCategory(Category category){
		this.category = category;
	}//end set

	/**Name: getCount.
		*Get the count of the user <br>   
		*<b> post: </b> get the count of song for user.
		*@return int countSong. This is the count of song for user.
	   */
	public int getCount(){
		return countSong;
	}//end get

	/** 
		*Name: setCount.
		*Change the count of the song for user <br>   
		*<b> post: </b> the new count of the user.
	   */
	public void setCount(int countSong){
		this.countSong = countSong;
	}//end set

}//end class user