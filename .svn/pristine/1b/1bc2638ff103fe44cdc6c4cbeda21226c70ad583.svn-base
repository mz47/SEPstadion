
package buying;

import dataStorage.block;
import dataStorage.category;
import dataStorage.god;
import dataStorage.log;
import dataStorage.seat;
import dataStorage.stadium;
import drawing.cup;
import javax.faces.context.FacesContext;

public abstract class Stornierung {
    
    public static String cancel(String id)
    {
        boolean success = false;
        
        for(transaction t : god.getTransactions())
        {
            if(t.getId().equals(id))
            {
                stadium s = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
                block b = (block) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("block");
                category c = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
                
                log.printLog("cancel", "trans.seats.size: " + t.getSeats().size());
                
                for(seat seat : t.getSeats())
                {
                    god.setOccupied(seat, false);
                    log.printLog("cancel", "seat: " + seat.getId() + " set occupied = false");
                }
                
                t.setCancelled(true);
                success = true;
                if(cup.EMAIL_ENABLED)
                {
                    email.email.sendCancelMail(t);
                }
            }
        }
        
        if(success)
        {
            return "Die Buchung wurde erfolgreich storniert. Zur bestätigung wurde eine Email versandt.<br /><br /><a href='index.xhtml'>Start</a>";
        }
        else
        {
            return "/Error.xhtml?faces-redirect=true&type=InvoiceIdNotFound";
        }
    }   
}
