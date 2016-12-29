
package drawing;

import dataStorage.category;
import dataStorage.game;
import dataStorage.stadium;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "bean_stadium")
@Dependent
public class bean_stadium {
    
    private String position;
    
    
    public bean_stadium() {
    }
    
    public String getPosition()
    {
        stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
        return stadium.getName();
    }
    
    
    
}
