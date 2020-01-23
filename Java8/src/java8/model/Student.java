package java8.model;

import java.util.List;
import java.util.Optional;

public class Student {

	String name;
	double gpa;
	String gender;
	int gradeLevel;
	List<String> activities;
	private int noteBooks;
	
	private Optional<Bike>bike = Optional.empty(); 	

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		this.name =name;
	}
	public Student(String name, double gpa, String gender, int gradeLevel, List<String> activities) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.gender = gender;
		this.gradeLevel = gradeLevel;
		this.activities = activities;
	}
	public Student(String name, double gpa, String gender, int gradeLevel, List<String> activities, int noteBooks) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.gender = gender;
		this.gradeLevel = gradeLevel;
		this.activities = activities;
		this.noteBooks = noteBooks;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}
	public int getNoteBooks() {
		return noteBooks;
	}
	public void setNoteBooks(int noteBooks) {
		this.noteBooks = noteBooks;
	}
	public Optional<Bike> getBike() {
		return bike;
	}
	public void setBike(Optional<Bike> bike) {
		this.bike = bike;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + ", gender=" + gender + ", gradeLevel=" + gradeLevel
				+ ", activities=" + activities + ", noteBooks=" + noteBooks + ", bike=" + bike + "]";
	}
	
	public  void printActivities(){
		System.out.println(this.activities);
	} 
	
	

}