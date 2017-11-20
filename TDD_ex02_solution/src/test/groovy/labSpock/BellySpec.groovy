package labSpock

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import spock.lang.Specification
import spock.lang.Unroll

class BellySpec extends Specification {
	def Belly myBelly = new Belly();
	
//	public "42 cukes and 1 hour"() {
//		given: "I have 42 cukes in my belly"
//			myBelly.eat(42);
//		when: "I wait 1 hour"
//			myBelly.wait(1);
//		then: "My belly should growl"
//			assertThat("My belly should have growled", myBelly.growl(), is(true));
//	}
//
//	public "42 cukes and 30 minutes"() {
//		given: "I have 42 cukes in my belly"
//			myBelly.eat(42);
//		when: "I wait 0 hours"
//			myBelly.wait(0);
//		then: "My belly should not growl yet"
//			assertThat("My belly should not have growled yet", myBelly.growl(), is(false));
//	}

// IS EQUIVALENT TO	
		
	@Unroll
	public "#cookies cukes and #time hours"() {
		given: "I have #cookies cukes in my belly"
			myBelly.eat(cookies);
		when: "I wait #time hours"
			myBelly.wait(time);
		then: "My belly should not growl yet"
			assertThat("My belly should not have growled yet", myBelly.growl(), is(result));
		where:
			cookies | time | result 
			42 | 1 | true
			42 | 0 | false
			1 | 0 | false
	}

// BUT THE FOLLOWING IS NOT: the test cases are grouped	
	
//	public "#cookies cukes and #time hours - with table"() {
//		given: "I have #cookies cukes in my belly"
//			myBelly.eat(cookies);
//		when: "I wait #time hours"
//			myBelly.wait(time);
//		then: "My belly should not growl yet"
//			assertThat("My belly should not have growled yet", myBelly.growl(), is(result));
//		where:
//			cookies | time | result 
//			42 | 1 | true
//			42 | 0 | false
//	}

}
