
package drawing;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

@Named(value = "bean_success")
@Dependent
public class bean_success {

    public String message;
    
    public bean_success() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String type = (String) facesContext.getExternalContext().getRequestParameterMap().get("type");
        
        this.message = drawing.message.getMessage(type);
    }
    
    public String getMessage()
    {
        return this.message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    
}
