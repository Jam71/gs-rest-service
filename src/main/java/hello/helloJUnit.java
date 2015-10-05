package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



public class helloJUnit {
	
	private  MockMvc mockMvc;
	
   	@Before
   	public void setUp() throws Exception
   	{
   		mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();	
   	}
   	
	@Test
	public void test() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andExpect(content().json(("$.name").value("Jamie")))
//		
		.andDo(print())
		.andExpect(status().isOk())
		;
		
	}

}
