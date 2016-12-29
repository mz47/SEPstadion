
package drawing;

import javax.enterprise.context.Dependent;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlPanelGrid;
import javax.inject.Named;

@Named(value = "bean_cup")
@Dependent
public class bean_cup {

    private String startUp;
    private String selectGame;
    private String selectCategory;
    private String selectSeat;
    private String checkout;
    private HtmlForm gamesForm;
    private HtmlForm seatsForm;
    private HtmlPanelGrid passportGrid;
    private String buySeats;
    private String categoryName;
    private String categoryLoad;
    private String bewerbungen;
    
    public bean_cup() {
    }
    
    public String startUp()
    {
        return cup.startUp();
    }
    public String selectGame(int gameId, int stadiumId)
    {
        return cup.selectGame(gameId, stadiumId);
    }
    public String selectCategory(String blockPosition, int categoryIndex)
    {
        return cup.selectCategory(blockPosition, categoryIndex);
    }
    public String selectSeat(int index)
    {
        return cup.selectSeat(index);
    }
    public String getBuySeats()
    {
        return cup.buySeats();
    }
    public String getCategoryName(String pos, int index)
    {
        return cup.getCategoryName(pos, index);
    }
    public String getCategoryLoad(String pos, int index)
    {
        return cup.getCategoryLoad(pos, index);
    }
    public String checkout()
    {
        return cup.checkout();
    }
    public HtmlForm getGamesForm()
    {
        return cup.drawGames();
    }
    public void setGamesForm(HtmlForm form)
    {
        this.gamesForm = form;
    }
    public HtmlForm getSeatsForm()
    {
        return cup.drawSeats();
    }
    public void setSeatsForm(HtmlForm form)
    {
        this.seatsForm = form;
    }
    public void setPassportGrid(HtmlPanelGrid grid)
    {
        this.passportGrid = grid;
    }
    public String ko_phase()
    {
        return cup.kophase();
        //return cup.kophase();
    }
    
}
