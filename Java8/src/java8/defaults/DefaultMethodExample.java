package java8.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("zeniffer","ram","sham","lucky");
		//prior java 7
		//Collections.sort(list);
		//System.out.println("sorted using Collections.sort()"+list);
		
		//java 8 approach 
		//default order
		list.sort(Comparator.naturalOrder());
		System.out.println("sorted using List.sort()"+list);
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
	}

}
