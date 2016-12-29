
package dataStorage;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "seat")
@Dependent
public class seat implements Serializable {

    private int id;
    private int categoryId;
    private boolean occupied;
    
    public seat() {
        //TODO
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
}
