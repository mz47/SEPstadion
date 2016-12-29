
package drawing;

import dataStorage.category;
import dataStorage.game;
import dataStorage.log;
import dataStorage.seat;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

@Named(value = "bean_bewerbung")
@Dependent
public class bean_bewerbung {

    private int numberOfSeats;
    private String email;
    private String passport;
    private String price;
    
    public bean_bewerbung() {
        this.numberOfSeats = 1;
    }
    
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("numberOfSeats", numberOfSeats);
        this.numberOfSeats = numberOfSeats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", email);
    }

    public String getPassport() {
        
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
        cup.addPassportId(passport);
    }
    
    public String bewerben()
    {
        return cup.bewerben();
    }
    
    public String getPrice()
    {
        game game = (game) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
        category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
        double priceTotal = game.getPricing() * category.getPrice();
        return (double)Math.round(priceTotal * 100) / 100 + " €";
    }

}
