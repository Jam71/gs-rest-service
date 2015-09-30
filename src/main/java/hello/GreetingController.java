package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	//private Set contactsCID = new HashSet();
	private List<Contact> contacts = new ArrayList<Contact>();	

	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
	}
	
	// This should not be get, should be push
    @RequestMapping("/contact")
    public Contact contact(@RequestParam(value="cid", defaultValue="0") long cid) {
    	Contact c1 = new Contact(cid);
    	// Iterate contacts list and if cid exist, delete the old one and update the new one
    	for(Iterator<Contact> i = contacts.iterator(); i.hasNext(); )
    	{
    		Contact item = i.next();
    		if(item.getCId() == cid)
    		{
    			//! I remember I can't change object inside iterator, need review on this part
    			contacts.remove(item);
    			contacts.add(c1);
    			return c1;
    		}
    	}
    	// If not exist, add it to the contacts list
    	contacts.add(c1);
    	return  c1;
    }
    
    @RequestMapping("/contacts")
	Collection<Contact> getContact(@RequestParam (value="targetCID", defaultValue="0")String targetCID) {
		
    	return contacts;
	}
//    @RequestMapping(method = RequestMethod.GET)
//   	Collection<Contact> getContact(@RequestParam (value="cid", defaultValue="0")String cid) {
//   		return getContact(cid);
//   	}


}
