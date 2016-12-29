
package dataStorage;

import drawing.cup;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "category")
@Dependent
public class category implements Serializable {

    private String name;
    private int numberOfSeats;
    private double price; 
    private ArrayList<seat> seats;
    
    public category() {
        
    }
    
    public category(String name, int numberOfSeats, double price)
    {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        seats = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<seat> seats) {
        this.seats = seats;
    }
    public ArrayList<seat> getSeats(int start, int end)
    {
        ArrayList<seat> arr = new ArrayList<>();
        if(seats != null)
            {
            for(int i = start; i <= end; i++)
            {
                arr.add(seats.get(i));
            }
        }
        return arr;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int NumberOfSeats) {
        this.numberOfSeats = NumberOfSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public seat getSeat(int index)
    {
        return this.seats.get(index);
    }
    
    public int getNumberOfFreeSeats()
    {
        int counter = 0;
        if(this.seats != null)
        { 
            for(int i = 0; i < this.seats.size(); i++)
            {
                if(seats.get(i).isOccupied() == false)
                {
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public boolean areSeatsFree(int start, int end)
    {
        boolean success = false;
        for(int i = start; i <= end; i++)
        {
            if(this.getSeat(i).isOccupied() == false)
            {
                success = true;
            }
            else
            {
                success = false;
            }
        }
        return success;
    }
    
    public void occupySeats(int start, int end)
    {
        for(int i = start; i <= end; i++)
        {
            this.getSeat(i).setOccupied(true);
        }
    }
    public int getFirstFreeSeat()
    {
        for(int i = 0; i < this.seats.size(); i++)
        {
            if(this.seats.get(i).isOccupied() == false)
            {
                return i;
            }
        }
        return -1;
    }
    public int getFirstFreeSeat(int rowIndex)
    {
        int row = rowIndex * cup.SEATS_IN_ROW;
        for(int i = row; i < this.seats.size(); i++)
        {
            if(this.seats.get(i).isOccupied() == false)
            {
                return i;
            }
        }
        return -1;
    }
    
    
    
}
