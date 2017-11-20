package code;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.Before;
import org.junit.Test;
import spock.lang.Specification
import code.Todo;

public class TodoSpec extends Specification {

	def todo
	
	def setup() {
		todo = new Todo(1, "Learn Hamcrest", "Important")
	}
	
	// exercise 4.1
	def "objectHasTaskProperty"() {
	    expect: 
			assertThat(todo, hasProperty("task"))
	}

	// exercise 4.2
	def "objectHasCorrectTaskValue"() {
	    expect: 
			assertThat("", todo, hasProperty("task", equalTo("Learn Hamcrest")));
	}
	
	// exercise 4.3
	def "objectHasSameProperties" () {
	    given:
			Todo todo2 = new Todo(1, "Learn Hamcrest", "Important");

	    expect: 
			assertThat(todo, samePropertyValuesAs(todo2));
	}
	
	// exercise 5
	def "objectYearHasPassed" () {
		when:
			todo.setYear(2006);
		then:
			thrown(Exception)
			// we can also check that an exception is not thrown using notThrown()
	}
	
}


