package java8.functionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import java8.model.Student;
import java8.model.StudentDatabase;

public class FunctionStudentExample {

	static Function<List<Student>,Map<String,Double>>myfunction = (students->{
		Map<String,Double>studentMap =new HashMap();
		students.forEach(st->{studentMap.put(st.getName(), st.getGpa());});
		return studentMap;
	});

	public static void main(String[] args) {
		System.out.println(myfunction.apply(StudentDatabase.getAllStudents()));
	}

}
