
package drawing;

import dataStorage.category;
import dataStorage.game;
import dataStorage.log;
import dataStorage.seat;
import java.util.ArrayList;
import javax.enterprise.context.Dependent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "bean_buyseats")
@Dependent
public class bean_buyseats {

    private HtmlPanelGrid passports;
    private String message;
    private String price;
    
    public bean_buyseats() {
    }
    
    public HtmlPanelGrid getPassports() {
        //passports = cup.drawPassportInput();
        return passports;
    }

    public void setPassports(HtmlPanelGrid passports) {
        this.passports = passports;
    }
    
    public String getMessage()
    {
        return this.message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public String validate()
    {
        ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
        if(seats.size() > 0)
        {
            this.message = "blabla";
            return "BuySeats";
        }
        else
        {
            this.message = "test";
            return "Block";
        }
    }
    public String getPrice()
    {
        game game = (game) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
        category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
        ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
        double priceTotal = game.getPricing() * category.getPrice() * seats.size();
        return (double)Math.round(priceTotal * 100) / 100 + " €";
    }

}
