
package buying;

import dataStorage.seat;
import java.util.ArrayList;
import java.util.Date;

public class bewerbung {

    private String id;
    private int stadionId;
    private String blockPosition;
    private String categoryName;
    private customer customer;
    private int numberOfseats;
    private Date date;
    private boolean accepted;
    
    public bewerbung(int stadionId, String blockPos, String catName, customer cust, int seats)
    {
        this.stadionId = stadionId;
        this.blockPosition = blockPos;
        this.categoryName = catName;
        this.customer = cust;
        this.numberOfseats = seats;
        this.id = utils.md5.toMd5("id" + System.currentTimeMillis());
        this.date = new Date();
        this.accepted = false;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStadionId() {
        return stadionId;
    }

    public void setStadionId(int stadionId) {
        this.stadionId = stadionId;
    }

    public String getBlockPosition() {
        return blockPosition;
    }

    public void setBlockPosition(String blockPosition) {
        this.blockPosition = blockPosition;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public int getNumberOfseats() {
        return numberOfseats;
    }

    public void setNumberOfseats(int numberOfseats) {
        this.numberOfseats = numberOfseats;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
 
    public transaction toTransaction()
    {        
        transaction trans = new transaction();
        ArrayList<seat> seats = new ArrayList<>();
            
        trans.setCustomer(customer);
        trans.setBlockPosition(blockPosition);
        trans.setCancelled(false);
        trans.setCategoryIndex(categoryName);
        trans.setDate(date);
        trans.setId(id);
        trans.setSeats(seats);
        trans.setStadionId(stadionId);
        
        return trans;
    }
    
}
