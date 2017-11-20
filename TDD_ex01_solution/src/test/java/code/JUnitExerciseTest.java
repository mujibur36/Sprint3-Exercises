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

public class JUnitExerciseTest {

	// exercise 1.1
    @Test
    public void hasSizeOf3() {
    		assertThat(list, hasSize(3));
    }
    
    // exercise 1.2
    @Test
    public void containsNumbersInAnyOrder() {
        assertThat(list, containsInAnyOrder(2, 4, 5));
    }
    
    // exercise 1.3
    @Test
    public void everyItemGreaterThan1() {
        assertThat(list, everyItem(greaterThan(1)));
    }
   
    // exercise 2.1
    @Test
    public void arrayHasSizeOf4() {
        assertThat(ints, arrayWithSize(4));
    }

    // exercise 2.1
    @Test
    public void arrayContainsNumbersInGivenOrder() {
        assertThat(ints, arrayContaining(7, 5, 12, 16));
    }
	
	// exercise 3.1
    @Test
    public void isStringEmpty() {
        String stringToTest = "";
        assertThat(stringToTest, isEmptyString());
    }

	// exercise 3.2
    @Test
    public void isStringEmptyOfNull() {
        String stringToTest = "";
        assertThat(stringToTest, isEmptyOrNullString());
    }    
}
