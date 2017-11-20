package code;

import static code.JUnitExercise.ints;
import static code.JUnitExercise.list;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

import org.junit.Test;
import spock.lang.Specification
import spock.lang.Unroll

public class JUnitExerciseSpec extends Specification {

	// exercise 1.1
    def "hasSizeOf3"() {
    		expect:
			assertThat(list, hasSize(3))
    }
    
    // exercise 1.2
    def "containsNumbersInAnyOrder"() {
        expect:
			assertThat(list, containsInAnyOrder(2, 4, 5));
    }
    
    // exercise 1.3
    def "everyItemGreaterThan1"() {
        expect:
			assertThat(list, everyItem(greaterThan(1)));
    }
   
    // exercise 2.1
    def "arrayHasSizeOf4"() {
        expect:
			assertThat(ints, arrayWithSize(4));
    }

    // exercise 2.1
    def "arrayContainsNumbersInGivenOrder"() {
        expect:
			assertThat(ints, arrayContaining(7, 5, 12, 16));
    }
	
	// exercise 3.1
    def "isStringEmpty"() {
        given:
			String stringToTest = "";
        expect:
			assertThat(stringToTest, isEmptyString());
    }

	// exercise 3.2
    def "isStringEmptyOfNull"() {
        given:
			String stringToTest = "";
        expect:
			assertThat(stringToTest, isEmptyOrNullString());
    }  
	
	// almost equivalent to solutions 3.1 and 3.2
	@Unroll 
	def "test string #description"() {
		expect:
			stringToTest == expectation
		where:
			description | stringToTest | expectation
			"isEmpty" | "" | ""
			"isNull" | null | null
	}
}
