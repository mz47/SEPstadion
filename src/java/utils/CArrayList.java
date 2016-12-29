
package utils;

import buying.bewerbung;
import java.util.Comparator;

public class CArrayList implements Comparator<bewerbung> {
    
    @Override
    public int compare(bewerbung arg0, bewerbung arg1)
    {
        int seats0 = ((bewerbung)arg0).getNumberOfseats();
        int seats1 = ((bewerbung)arg1).getNumberOfseats();

        if(seats0 > seats1)
        {
            return -1;
        }
        else if(seats0 < seats1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
}
