package model;

public class USER{

	//Relationships
	private CATEGORY category;

	//Constant
	public final static int USERS = 10;

	//Atributes
	private String userName;
	private String password;
	private int age;
	private CATEGORY category;

	//Methods
	public USER(String userName, String password, int age){
		this.userName = userName;
		this.password = password;
		this.age = age;
		category = CATEGORY.NEWBIE;
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

	public CATEGORY getCategory(){
		return category;
	}

	public void setCategory(CATEGORY category){
		this.category = category;
	}



}