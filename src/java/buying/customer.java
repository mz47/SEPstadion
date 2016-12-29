
package buying;

import java.util.ArrayList;

public class customer {

    private String email;
    private String passportId;
    private ArrayList<String> ids;

    public customer()
    {
        
    }
    
    public customer(String email, String passportId)
    {
        this.email = email;
        this.passportId = passportId;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
    
    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }
    
}
