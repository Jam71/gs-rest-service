package hello;

import java.awt.List;
import java.util.Collection;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonCreator;

public class Contact {

	private final long cid;
	private final String firstName;
	private final String lastName;
	private final long phone;
	private final String email;

	public Contact(long cid, String firstName, String lastName, long phone, String email)
	{
		this.cid = cid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
//    public Contact(Map<String, Object> props) {
//        this.cid = (long) props.get("cid");
//        this.firstName = (String) props.get("firstName");
//        this.lastName = (String) props.get("lastName");
//        this.phone = (long) props.get("phone");
//        this.email = (String) props.get("email");
//    }

    public long getCId() {
        return cid;
    }
    
    public String getfName() {
        return firstName;
    }
    
    public String getlName() {
        return lastName;
    }

    public long getPhone() {
        return phone;
    }
    
    public String getEmail() {
        return email;
    }
    
}
