package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	//private Set contactsCID = new HashSet();
	private List<Contact> contacts = new ArrayList<Contact>();	

	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue=""
    		+ "") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
	}
	
	 @RequestMapping(method = RequestMethod.POST, value = "/doc")
	    public String createContact(@RequestBody Contact c1) {
//	    	contacts.add(c1);
//	    	return  c1;
		 return "success";
	    } 
//	 @RequestMapping(method = RequestMethod.POST)
//	    public String createContact2(@RequestBody Contact c1) {
////	    	contacts.add(c1);
////	    	return  c1;
//		 return "success";
//	    } 
//	 @RequestMapping(method = RequestMethod.POST, value = "/doc")
//	    public String createContact(@RequestBody String c1) {
////	    	contacts.add(c1);
////	    	return  c1;
//		 return "success";
//	    }
	 
    @RequestMapping(method = RequestMethod.PUT , value = "/contacts/{cid}")
    public Contact updateContact(@PathVariable long cid, @RequestBody Contact contactObj) {
    	// Contact c1 = new Contact(cid);
    	// Iterate contacts list and if cid exist, delete the old one and update the new one
    	for(Iterator<Contact> i = contacts.iterator(); i.hasNext(); )
    	{
    		Contact item = i.next();
    		if(item.getCId() == cid)
    		{
    			//! I remember I can't change object inside iterator, need review on this part
    			contacts.remove(item);
    			contacts.add(contactObj);
    			return contactObj;
    		}
    	}
    	// If not exist, add it to the contacts list
    	contacts.add(contactObj);
    	return  contactObj;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/contacts")
   	Collection<Contact> getContactID() {
       	
       		return contacts;
       	
   	}
    
    @RequestMapping(method = RequestMethod.GET, value = "/contacts/{cid}")
	Collection<Contact> getContact(@PathVariable long cid) {
    	Collection<Contact> tmp = new ArrayList<Contact>();
		
    	for(Iterator<Contact> i = contacts.iterator(); i.hasNext(); )
    	{
    		Contact item = i.next();
    		if(item.getCId() == cid)
    		{
    			// Check out container wrapper later...
    			tmp.add(item);
    			return tmp;
			}
    	}

    	return tmp;
	}
    
  //! This should not be get, should be push
    @RequestMapping(method = RequestMethod.DELETE ,value = "/contact/{cid}")
    public Collection<Contact> deleteContact(@PathVariable long cid) {
    	// Iterate contacts list and if cid exist, delete the old one and update the new one
    	for(Iterator<Contact> i = contacts.iterator(); i.hasNext(); )
    	{
    		Contact item = i.next();
    		if(item.getCId() == cid)
    		{
    			//! I remember I can't change object inside iterator, need review on this part
    			contacts.remove(item);
    			// Need to print out a message that this object is removed, but since this is REST, I should wrap the message to the object return and right not I am not familiar with how to use wrapper yet. 
    			return contacts;
    		}
    	}
    	return contacts;
    }
//    // This is not working because of null pointer exception, I might have to change the multipart file to make it works.
//    @RequestMapping(value="/upload", method=RequestMethod.POST)
//    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
//    		@RequestBody MultipartFile file)
//    {
//    	if(!file.isEmpty())
//    	{
//    		try{
//    			byte[] bytes = file.getBytes();
//    			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
//    			stream.write(bytes);
//    			stream.close();
//    			return "You succesfully uploaded "+ name + "!";
//    		} catch(Exception e){
//    			return "You failed to upload "+ name+" => "+e.getMessage();
//    		}	
//    		
//    	}else{
//    		return "You failed to upload "+ name + " because the file was empty.";
//    	}
//    }
//    @RequestMapping(method = RequestMethod.GET)
//   	Collection<Contact> getContact(@RequestParam (value="cid", defaultValue="0")String cid) {
//   		return getContact(cid);
//   	}


}

