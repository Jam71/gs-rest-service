package hello;

import java.awt.List;
import java.util.Collection;

public class Contact {

	private final long cid;
	private final String firstName;
	private final String lastName;
	private final long phone;
	private final String email;


    public Contact(long cid, String fName, String lName, long phone, String email) {
        this.cid = cid;
        this.firstName = fName;
        this.lastName = lName;
        this.phone = phone;
        this.email = email;
    }

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
