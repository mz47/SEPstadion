
package drawing;

import buying.Stornierung;
import dataStorage.log;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "bean_stornierung")
@Dependent
public class bean_stornierung {

    private String id;
    private String message;
    
    public bean_stornierung() {
    }
    
    public String getId()
    {
        
        return this.id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getMessage()
    {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String passedParameter = (String) facesContext.getExternalContext().getRequestParameterMap().get("rechnungsnummer");
        
        this.id = passedParameter;
        this.message = Stornierung.cancel(id);
        
        return this.message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
}
