package java8.javastreams_terminal;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import java8.model.StudentDatabase;

public class StreamsCountingExample {

	static long getCount(){
		return StudentDatabase.getAllStudents()
		.stream()
		.filter(st->st.getGpa()>=3.9)
		.collect(Collectors.counting());
	}
	public static void main(String[] args) {
		System.out.println(getCount());
	}

}
