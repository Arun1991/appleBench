package com.example.demo.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning(){
		List<Integer>numbers = Arrays.asList(1,2,3);
		
		//assertThat(numbers,hasSize(3));
		//assertThat(numbers, hasItems(1,2));
		assertThat(numbers).hasSize(3)
						   .contains(1,2)
						   .allMatch(x->x>0)
						   .allMatch(x->x<10)
						   .noneMatch(x->x<0);
		
		
		//assertThat(numbers, everyItem(greaterThan(0)));
		//assertThat(numbers, everyItem(lessThan(4)));
		
		//assertThat("", isEmptyString());
		//assertThat("ABCDE", containsString("A"));
		//assertThat("ABCDE", startsWith("AB"));
		//assertThat("ABCDE", endsWith("CDE"));
		assertThat("").isEmpty();
		assertThat("ABCDE").startsWith("AB")
						   .endsWith("DE");
	}
	

}

