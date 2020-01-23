package java8.javastreams;

import java8.model.StudentDatabase;

public class StreamMapReduceExample {

	static int numberOfNoteBooks(){
		int noOfBooks = StudentDatabase.getAllStudents().stream()
			.map(stu->stu.getNoteBooks())
			.reduce(0,(a,b)->a+b);
		return noOfBooks;
	}
	
	static int numberOfNoteBooksgradeLevel(){
		int noOfBooks = StudentDatabase.getAllStudents().stream()
			.filter(stu->stu.getGradeLevel()>=3)
			.map(stu->stu.getNoteBooks())
			.reduce(0,(a,b)->a+b);
		return noOfBooks;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("no of books "+numberOfNoteBooks());
		System.out.println("no of books whose grade grt than 3 ::"+numberOfNoteBooksgradeLevel());
		
	}

}
