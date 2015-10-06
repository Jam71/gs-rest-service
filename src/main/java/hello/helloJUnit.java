package hello;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



public class helloJUnit {
	
	private  MockMvc mockMvc;
	
   	@Before
   	public void setUp() throws Exception
   	{
   		mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController())
   				.alwaysDo(print())
   				.alwaysExpect(status().isOk())
  				.alwaysExpect(content().contentType("application/json;charset=UTF-8"))
   				.build();	
   	}
   	
	@Test
	public void testGreeting() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}

	
	@Test
	public void testCreateContact() throws Exception{
		//MockMultipartFile firstFile = new MockMultipartFile("json", "", "application/json", "{\"json\":\"obj.json\"}".getBytes());
		this.mockMvc.perform(post(".").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}
	
	@Test
	public void testUpdateContact() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}
	
	@Test
	public void testGetContactID() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}
	
	@Test
	public void testGetContact() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}
	

	@Test
	public void testDeleteContact() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	}
	

	
}
