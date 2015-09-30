package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.List;
import java.util.Collection;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	//private Collection<Contact> contacts = (Collection<Contact>) new List();

	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
	}
	
    @RequestMapping("/contact")
    public Contact contact(@RequestParam(value="cid", defaultValue="0") long cid) {
    	//Contact c1 = new Contact(cid);
    	//contacts.add(c1);
        return new Contact(cid);
    }
    
//    @RequestMapping("/contacts")
//	Collection<Contact> getContact(@RequestParam (value="targetCID", defaultValue="0")String targetCID) {
//		return contacts;
//	}
//    @RequestMapping(method = RequestMethod.GET)
//   	Collection<Contact> getContact(@RequestParam (value="cid", defaultValue="0")String cid) {
//   		return getContact(cid);
//   	}


}
