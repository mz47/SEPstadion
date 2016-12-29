
package drawing;

import javax.enterprise.context.Dependent;
import javax.faces.component.html.HtmlForm;
import javax.inject.Named;

@Named(value = "bean_games")
@Dependent
public class bean_games {

    private HtmlForm games;
    
    public bean_games() {
        
    }

    public HtmlForm getGames() {
        games = cup.drawGames();
        return games;
    }

    public void setGames(HtmlForm games) {
        this.games = games;
    }
 
}
