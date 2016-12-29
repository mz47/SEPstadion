
package drawing;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

@Named(value = "bean_error")
@Dependent
public class bean_error {

    public String message;
    
    public bean_error() {
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
