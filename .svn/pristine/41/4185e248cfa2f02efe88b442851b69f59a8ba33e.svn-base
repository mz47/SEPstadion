
package dataStorage;

import java.util.ArrayList;

public class data
{

    //private static ArrayList<game> games;
    //private static stadium stadium;
    private game activeGame;
    private stadium activeStadium;
    private block activeBlock;
    private category activeCategory;
    private ArrayList<seat> selectedSeats;
    
    // in god ausgelagert
    
    /*public static ArrayList<game> getGames() {
        return games;
    }

    public static void setGames(ArrayList<game> games) {
        data.games = games;
    }
    
    public static int getGamesSize()
    {
        if(games != null)
        {
            return games.size();
        }
        else
        {
            return -1;
        }
    }

    public static stadium getStadium() {
        return stadium;
    }

    public static void setStadium(stadium stadium) {
        data.stadium = stadium;
    }
    
    public static boolean getStadiumLoaded()
    {
        if(stadium != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }*/

    public game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(game activeGame) {
        this.activeGame = activeGame;
    }

    public stadium getActiveStadium() {
        return activeStadium;
    }

    public void setActiveStadium(stadium activeStadium) {
        this.activeStadium = activeStadium;
    }

    public block getActiveBlock() {
        return activeBlock;
    }

    public void setActiveBlock(block activeBlock) {
        this.activeBlock = activeBlock;
    }

    public category getActiveCategory() {
        return activeCategory;
    }

    public void setActiveCategory(category activeCategory) {
        this.activeCategory = activeCategory;
    }

    public ArrayList<seat> getSelectedSeat() {
        return selectedSeats;
    }

    public void setSelectedSeats(ArrayList<seat> seats) {
        this.selectedSeats = seats;
    }
    
    // in god ausgelagert
    
    /*
    public static int getNumberOfOccupiedSeats()
    {
        if(stadium != null)
        {
            int counter = 0;
            for(block b : stadium.getBlocks())
            {
                for(seat s_0 : b.getCat_0().getSeats())
                {
                    if(s_0.isOccupied())
                    {
                        counter++;
                    }
                }
                for(seat s_1 : b.getCat_1().getSeats())
                {
                    if(s_1.isOccupied())
                    {
                        counter++;
                    }
                }
                for(seat s_2 : b.getCat_2().getSeats())
                {
                    if(s_2.isOccupied())
                    {
                        counter++;
                    }
                }
            }
            return counter;
        }
        else
        {
            return -1;
        }
    }
    */
    public void addSelectedSeat(seat seat)
    {
        if(seat != null)
        {
            selectedSeats.add(seat);
        }
    }
    
    public String getSelectedSeatsToString()
    {
        StringBuilder sb = new StringBuilder();
        if(selectedSeats != null)
        {
            for(seat s : selectedSeats)
            {
                sb.append(s.getId());
                sb.append(", ");
            }
            return sb.toString();
        }
        else
        {
            return "no seats";
        }
    }
    
}
