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
	
	def "3.A.1"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get '/'"
			result = this.mockMvc.perform(get('/'));
		then: "I should see the view 'index'"
			result
			.andExpect(status().isOk())
			.andExpect(view().name('index'));
	}
	
	def "3.A.2"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a get /product/"
			result = this.mockMvc.perform(get('/product/'));
		then: "I should see the view 'form/productMaster'"
			result
				.andExpect(status().isOk())
				.andExpect(view().name('form/productMaster'));
	}

	def "3.A.3"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		when: "I do a post '/product/add' with id '0', name 'Banana', description 'yellow' and price '0.16'"
			result = this.mockMvc.perform(post('/product/add')
					.param("id", '0')
					.param("name", 'Banana')
					.param("description", 'yellow')
					.param("price", '0.16'));
		then: "I should see the view 'form/productMaster'"
			result.andExpect(status().is(200))
				.andExpect(view().name('form/productMaster'))
	}
	
	def "3.A.4"() {
		given: "the context of the controller is set up"
			mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
			this.mockMvc.perform(post('/product/add')
				.param("id", '0')
				.param("name", 'Banana')
				.param("description", 'yellow')
				.param("price", '0.16'));
		when: "I do a post '/product/add' with id '0', name 'Banana', description 'Canary Islands' and price '0.16'"
			result = this.mockMvc.perform(post('/product/add')
				.param("id", '0')
				.param("name", 'Banana')
				.param("description", 'yellow')
				.param("price", '-1'));
		then: "I should see the view 'form/productDetail'"
			result.andExpect(status().is(200))
			.andExpect(view().name('form/productDetail'))
	}

			
}

