
package drawing;

import dataStorage.block;
import dataStorage.category;
import dataStorage.data;
import dataStorage.game;
import dataStorage.seat;
import dataStorage.stadium;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "bean_data")
@Dependent
public class bean_data {
    
    private game activeGame;
    private stadium activeStadium;
    private block activeBlock;
    private category activeCategory;
    private seat activeSeat;
    private int gamesSize;
    private boolean stadiumLoaded;
    private int numberOfOccupiedSeats;
    private String selectedSeatsToString;
    private int selectedSeatsSize;
    private String stadiumName;
    private String clearContext;
    private String email;
    private int numberOfPassportIds;
    
    public bean_data() {
        //TODO
    }

    
    public game getActiveGame() {
        return (game) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
    }

    public stadium getActiveStadium() {
        this.activeStadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
        return this.activeStadium;
    }
    
    public block getActiveBlock() {
        this.activeBlock = (block) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("block");
        return this.activeBlock;
    }

    public category getActiveCategory() {
        this.activeCategory = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
        return this.activeCategory;
    }
    
    public String getStadiumName()
    {
        if(activeStadium != null)
        {
            return this.activeStadium.getName();
        }
        else
        {
            return "no stadium selected";
        }
    }
    
    public String getClearContext()
    {
        cup.clearBlockContext();
        return "Stadion";
    }
/*
    public void setActiveCategory(category activeCategory) {
        data.setActiveCategory(activeCategory);
    }
    
    public int getGamesSize()
    {
        return data.getGamesSize();
    }
    
    public boolean getStadiumLoaded()
    {
        return data.getStadiumLoaded();
    }
    
    public int getNumberOfOccupiedSeats()
    {
        return data.getNumberOfOccupiedSeats();
    }
    */
    public String getSelectedSeatsToString()
    {
        ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
        if(seats != null)
        {
            if(seats.size() > 0)
            {
                StringBuilder sb = new StringBuilder();
                for(seat s : seats)
                {
                    sb.append(s.getId());
                    sb.append(", ");
                }
                return sb.toString();
            }
            else
            {
                return "no seats selected";
            }
        }
        else
        {
            return "seats object null";
        }
    }
    
    public int getSelectedSeatsSize()
    {
        ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
        if(seats != null)
        {
            return seats.size();
        }
        else
        {
            return -1;
        }
    }
    
    public String getEmail()
    {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
    }
     
    public int getNumberOfPassportIds()
    {
        ArrayList<Integer> ids = (ArrayList<Integer>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passportids");
        if(ids == null)
        {
            return -1;
        }
        else
        {
            return ids.size();
        }
    }
    public void addPassportId(int id)
    {
        ArrayList<Integer> ids = (ArrayList<Integer>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passportids");
        ids.add(id);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passportids", ids);
    }
}
