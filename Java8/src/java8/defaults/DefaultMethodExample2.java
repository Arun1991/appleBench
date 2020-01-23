package java8.defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import java8.model.Student;
import java8.model.StudentDatabase;

public class DefaultMethodExample2 {

	static Consumer<Student> consumer = (student) -> System.out.println(student);
	static Comparator<Student> nameComparator = Comparator.comparing(Student::getGpa);
	static Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

	public static void sortByName(List<Student> students) {
		Comparator<Student> compararor = Comparator.comparing(Student::getName);
		students.sort(compararor);
		students.forEach(consumer);
	}

	public static void sortByGpa(List<Student> students) {
		Comparator<Student> compararor = Comparator.comparing(Student::getGpa);
		students.sort(compararor);
		students.forEach(consumer);
	}

	public static void comparatorChaining(List<Student> students) {
		System.out.println("comparator chaining");
		students.sort(gradeComparator.thenComparing(nameComparator));
		students.forEach(consumer);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = StudentDatabase.getAllStudents();
		sortByName(students);
		comparatorChaining(students);
	}

}
