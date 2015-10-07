package hello;

//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
//import com.github.springtestdbunit.annotation.ExpectedDatabase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//        DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        DbUnitTestExecutionListener.class })
//@DatabaseSetup("tododata.xml")
public class helloJUnit {
	
	private  MockMvc mockMvc;
	
   	@Before
   	public void setUp() throws Exception
   	{
   		mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController())
   				.alwaysDo(print())
   				.alwaysExpect(status().isOk())
//  				.alwaysExpect(content().contentType("application/json;charset=UTF-8"))
//   				
   				.build();	
   		
   	}
   	
	@Test
	public void testGreeting() throws Exception{
		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1))
		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
		
	} 

	
	@Test
//	@ExpectedDatabase("tododata.xml")
	public void testCreateContact() throws Exception{
		//Contact c1 = new Contact(1,"John", "Smith", 123, "xxx@gmail.com" );
		MockHttpServletRequestBuilder createMessage = post("/doc")
//				.content("{\"cid\": 1, \"firstName\": \"John\",    \"lastName\": \"Smiths\",    \"phone\": 8013334444,    \"email\": \"xxx@gmail.com\"}".getBytes());
				.param("cid", "12")
				.param("firstName", "In case you didn't know, Spring Rocks!")
		.param("lastName", "In case you didn't know, Spring Rocks!")
		.param("phone", "In case you didn't know, Spring Rocks!")
		.param("email", "In case you didn't know, Spring Rocks!");
			//mockMvc.perform(fileUpload("/doc").file("cid", "cid=1 firstName=John lastName=Smith phone=8013334444 email=xxx@gmail.com".getBytes("UTF-8")));
		mockMvc.perform(createMessage);
//		MockMultipartFile firstFile = new MockMultipartFile("obj.json", "obj.json", "application/json", "{\"json\":\"obj.json\"}".getBytes());
//		this.mockMvc.perform(MockMvcRequestBuilders.fileUpload("root"))
//		.andExpect(jsonPath("$.id").value(1));

		
	}
	
//	@Test
//	public void testUpdateContact() throws Exception{
//		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.id").value(1))
//		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
//		
//	}
//	
//	@Test
//	public void testGetContactID() throws Exception{
//		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.id").value(1))
//		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
//		
//	}
//	
//	@Test
//	public void testGetContact() throws Exception{
//		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.id").value(1))
//		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
//		
//	}
//	
//
//	@Test
//	public void testDeleteContact() throws Exception{
//		this.mockMvc.perform(get("/greeting?name=Jamie").accept(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$.id").value(1))
//		.andExpect(jsonPath("$.content").value("Hello, Jamie!"));
//		
//	}
	

	
}
