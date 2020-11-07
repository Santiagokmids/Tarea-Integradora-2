package model;

public class PublicPlay extends PLAYLIST{

	//Atributes
	private int calification;
	private int averageCount;

	public PublicPlay(String name){
		super(name);
		calification = 0;
		averageCount = 0;
	}

	public int getCalification(){
		return calification;
	}

	public void setCalification(int calification){
		this.calification = calification;
	}

	public int getAverage(){
		return averageCount;
	}

	public void setAverage(int averageCount){
		this.averageCount = averageCount;
	}
}