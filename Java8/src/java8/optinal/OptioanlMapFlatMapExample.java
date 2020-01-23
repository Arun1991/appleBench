package java8.optinal;

import java.util.Optional;

import java8.model.Bike;
import java8.model.Student;
import java8.model.StudentDatabase;

public class OptioanlMapFlatMapExample {

	static void optionalFilter(){
		Optional<Student>studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		studentOptional.filter(s->s.getGpa()>=3.2).ifPresent(st->System.out.println(st));
	}
	
	static void optionalMap(){
		Optional<Student>studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		if(studentOptional.isPresent()){
			Optional<String>res = studentOptional.filter(st->st.getGpa()>=3.0)
			.map(Student::getName);
			System.out.println(res.get());
		}
	}
	
	static void optionalFilterMap(){
		Optional<Student>studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
		if(studentOptional.isPresent()){
			Optional<String>res = studentOptional.filter(st->st.getGpa()>=3.0)
			.flatMap(Student::getBike)
			.map(Bike::getName);
			System.out.println(res.get());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			optionalFilter();
			optionalMap();
			optionalFilterMap();
	}

}
