
package login;

import dataStorage.log;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "bean_login")
@Dependent
public class bean_login {

    private String user;
    private String password;
    
    public bean_login() {
        
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = "test";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = "pass";
    }
    
    public void login()
    {
        log.printLog("login", "user: " + this.user + ", pass: " + this.password);
        //return "";
    }

}
