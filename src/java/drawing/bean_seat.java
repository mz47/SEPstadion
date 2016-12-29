package drawing;

import javax.enterprise.context.Dependent;
import javax.inject.Named;


@Named(value = "bean_seat")
@Dependent
public class bean_seat {

    private int id;
    
    public bean_seat() {
        
    }
    
    public int getId()
    {
        return this.id;
    }
    
}
