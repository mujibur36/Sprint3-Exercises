package eMarket

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext

import spock.lang.Specification
import spock.lang.Unroll

import eMarket.controller.IndexController
import eMarket.controller.ProductController

@ContextConfiguration
@WebMvcTest(controllers=[IndexController.class,ProductController.class])
class ProductManagementSpec extends Specification {
	
	@Autowired
	def WebApplicationContext wac
	
	def MockMvc mockMvc 
	def ResultActions result
	
	
	// EXERCISE 3.A
	
	// EXERCISE 3.B
	
	// EXERCISE 3.C
	
		
}

