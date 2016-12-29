
package drawing;

import dataStorage.god;
import dataStorage.log;
import java.net.InetAddress;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named(value = "bean_god")
@Dependent
public class bean_god {
    
    private int numberOfOccupiedSeats;
    private int gameSize;
    private int stadiumsSize;
    private boolean stadiumLoaded;
    private String transactions;
    private int numberOfTransactions;
    private int numberOfBewerbungen;
    private String bewerbungen;
    private String ip;
    
    public bean_god() {
    }

    public int getGameSize() {
        return god.getGameSize();
    }

    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }
    
    public int getStadiumsSize()
    {
        return god.getStadiumsSize();
    }
    
    public int getNumberOfOccupiedSeats() {
        return god.getNumberOfOccupiedSeats();
    }

    public void setNumberOfOccupiedSeats(int numberOfOccupiedSeats) {
        this.numberOfOccupiedSeats = numberOfOccupiedSeats;
    }

    public boolean isStadiumLoaded() {
        return god.getStadiumLoaded();
    }

    public void setStadiumLoaded(boolean stadiumLoaded) {
        this.stadiumLoaded = stadiumLoaded;
    }
    
    public String getTransactions()
    {
        return god.getAllTransactionsToString();
    }
    
    public int getNumberOfTransactions()
    {
        if(god.getTransactions() == null)
        {
            return -1;
        }
        else
        {
            return god.getTransactions().size();
        }
    }
    
    public int getNumberOfBewerbungen()
    {
        return god.getNumberOfBewerbungen();
    }
    
    public String getBewerbungen()
    {
        log.printLog("getBewerbungen", god.getAllBewerbungenToString());
        return god.getAllBewerbungenToString();
    }
    public void setBewerbungen(String bewerbungen)
    {
        this.bewerbungen = bewerbungen;
    }
    public String getIp()
    {
        return god.getIp();
    }
    
}