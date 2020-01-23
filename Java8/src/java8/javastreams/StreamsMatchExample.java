package java8.javastreams;

import java8.model.StudentDatabase;

public class StreamsMatchExample {

	static boolean allMatch(){
		return StudentDatabase.getAllStudents().stream()
						.allMatch(st->st.getGpa()>=3.5);
	} 

	static boolean anyMatch(){
		return StudentDatabase.getAllStudents().stream()
						.anyMatch(st->st.getGpa()>=4);
	} 

	static boolean noneMatch(){
		return StudentDatabase.getAllStudents().stream()
						.noneMatch(st->st.getGpa()>=5.5);
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allMatch());
		System.out.println(anyMatch());
		System.out.println(noneMatch());
	}

}
