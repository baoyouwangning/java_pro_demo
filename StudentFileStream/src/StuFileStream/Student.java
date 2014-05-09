package StuFileStream;

import java.io.Serializable;

public class Student implements Serializable{
	

	private int id;
	private String name;
	private int score;
	
	public Student() {
		this(0,null,0);
	}
	
	public Student(int aId,String aName,int aScore) {
		this.setId(aId);
		this.name = aName;
		this.score = aScore;
	}

	public int getId() {
		return id;
	}

	public void setId(int aId) {
		this.id = aId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String aName) {
		this.name = aName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int aScore) {
		this.score = aScore;
	}
	
	public String toString() {
		return "ID:" + id + " NAME:" + name + " SCORE" + score;
	}
}
