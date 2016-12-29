
package drawing;

import dataStorage.block;
import dataStorage.category;
import dataStorage.game;
import dataStorage.stadium;
import javax.enterprise.context.Dependent;
import javax.faces.component.html.HtmlForm;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "bean_block")
@Dependent
public class bean_block {

    private HtmlForm seats;
    private String position;
    private String price;

    public bean_block() {
        
    }
    
    public HtmlForm getSeats() {
        
        //return cup.drawSeats();
        return null;
    }
    
    public void setSeats(HtmlForm seats)
    {
        this.seats = seats;
    }
    
    public String getPosition()
    {
        StringBuilder sb = new StringBuilder();
        stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
        category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
        block block = (block) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("block");
        
        sb.append(stadium.getName());
        sb.append(" >> ");
        sb.append(category.getName());
        sb.append(" >> ");
        sb.append(block.getName());
        sb.append(" (");
        sb.append(block.getPos());
        sb.append(")");
        return sb.toString();
    }
    
    public String getPrice()
    {
        game game = (game) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
        category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
        
        return game.getPricing() * category.getPrice() + " € (" + category.getPrice() + "€ x " + game.getPricing() + ")";
    }

}
