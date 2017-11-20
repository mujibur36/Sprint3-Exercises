package code;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.Before;
import org.junit.Test;

import code.Todo;

public class TodoTest {

	Todo todo;
	
	@Before
	public void setup() {
		todo = new Todo(1, "Learn Hamcrest", "Important");
	}
	
	// exercise 4.1
	@Test
	public void objectHasTaskProperty () {
	    assertThat(todo, hasProperty("task"));
	}

	// exercise 4.2
	@Test
	public void objectHasCorrectTaskValue () {
	    assertThat("", todo, hasProperty("task", equalTo("Learn Hamcrest")));
	}
	
	// exercise 4.3
	@Test
	public void objectHasSameProperties () {
	    Todo todo2 = new Todo(1, "Learn Hamcrest", "Important");

	    assertThat(todo, samePropertyValuesAs(todo2));
	}
	
	// exercise 5
	@Test(expected = Exception.class)
	public void objectYearHasPassed () throws Exception {
		todo.setYear(2006);
	}
	
}


