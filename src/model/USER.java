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
	public USER(String userName, String password, int age){
		this.userName = userName;
		this.password = password;
		this.age = age;
		category = Category.NEWBIE;
		countSong = 0;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public Category getCategory(){
		return category;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public int getCount(){
		return countSong;
	}

	public void setCount(int countSong){
		this.countSong = countSong;
	}



}