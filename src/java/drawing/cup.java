package drawing;

import buying.bewerbung;
import buying.customer;
import buying.transaction;
import dataStorage.block;
import dataStorage.category;
import dataStorage.game;
import dataStorage.god;
import dataStorage.log;
import dataStorage.seat;
import dataStorage.stadium;
import dataStorage.wrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.el.MethodExpression;
import javax.enterprise.context.Dependent;
import javax.faces.application.Application;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import login.auth;
import utils.CArrayList;

@Named(value = "cup")
@Dependent
public abstract class cup {

    public static final int SEATS_IN_ROW = 20;
    public static final boolean EMAIL_ENABLED = true;
    private static final String STYLE_OCCUPIED = "occupied";
    private static final String STYLE_SELECTED = "selected";
    private static final String STYLE_FREE = "free";

    public cup() {
        
    }

    public static String startUp() {
        try
        {
            if(auth.isAuth())
            {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("game", null);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("stadium", null);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("block", null);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("category", null);

                god.setStadiums(wrapper.getStadiums());
                god.setGames(wrapper.getGames());
                god.setSeats(new ArrayList<>());
                god.setTransactions(new ArrayList<>());
                god.setBewerbungen(new ArrayList<>());
            }
            
            return "index";
        }
        catch (Exception ex) {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static void clearSeatsContext() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("seats", new ArrayList<>());
    }

    public static void clearBlockContext() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("block");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("category");
        clearSeatsContext();
    }

    public static void clearGameContext() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("game");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("stadium");
        clearSeatsContext();
        clearBlockContext();
    }

    public static void clearCustomerContext() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", "");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passportids", new ArrayList<>());
    }

    public static String selectCategory(String blockPosition, int categoryIndex) {
        try
        {
            clearBlockContext();

            game game = (game) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("game");
            stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");

            block block = stadium.getBlock(blockPosition);
            category category = block.getCategory(categoryIndex);

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("block", block);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("category", category);

            if (game.getType().equals("Gruppenphase")) {
                return "Block";
            } else {
                return "Bewerbung.xhtml";
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static String selectSeat(int index) {
        try
        {
            ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");

            category c = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");

            log.printLog("selectseat", "index: " + index + ", numberofseats: " + c.getNumberOfSeats());

            seat s = c.getSeat(index);
            //s.setOccupied(true);
            //endgültige reservierung        
            //god.addSeat(s);
            if (seats.contains(s)) {
                seats.remove(s);
            } else {
                seats.add(s);
            }
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().replace("seats", seats);

            return "Block";
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static String selectGame(int gameId, int stadiumId) {
        try
        {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", null);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("seats", new ArrayList<>());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passportids", new ArrayList<>());

            game game = god.getGames().get(gameId - 1);
            stadium stadium = god.getStadiums().get(stadiumId - 1);

            clearBlockContext();

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("game", game);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("stadium", stadium);

            return "Stadion";
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static HtmlForm drawGames() {
        try {
            clearGameContext();

            ArrayList<game> games = god.getGames();
            Application app = FacesContext.getCurrentInstance().getApplication();
            HtmlForm form = (HtmlForm) app.createComponent(HtmlForm.COMPONENT_TYPE);

            if (games.isEmpty() == false) {
                for (game g : games) {
                    HtmlCommandLink link = (HtmlCommandLink) app.createComponent(HtmlCommandLink.COMPONENT_TYPE);
                    HtmlOutputText newline = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);

                    link.setValue(g.getDate() + ": " + g.getTeam1() + " vs. " + g.getTeam2() + ": " + g.getType() + " (StadionID: " + g.getStadiumId() + ")");
                    link.setActionExpression(createMethodExpression("#{bean_cup.selectGame(" + g.getId() + ", " + g.getStadiumId() + ")}", String.class));
                    link.setId("game_" + g.getId());

                    newline.setValue("<br /><br />");
                    newline.setEscape(false);
                    newline.setId("newline_" + g.getId());

                    form.getChildren().add(link);
                    form.getChildren().add(newline);
                }
            } else {
                HtmlOutputText nogames = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);
                nogames.setValue("Keine Spiele gefunden.");
                form.getChildren().add(nogames);
            }
            form.setId("form_games");
            return form;
        } catch (Exception ex)
        {
            log.printException(ex);
            return null;
        }
    }

    public static String getCategoryName(String pos, int index)
    {
        try
            {
            stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
            block block = stadium.getBlock(pos);
            return block.getCategory(index).getName();
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "Fehler";
        }
    }

    public static String getCategoryLoad(String pos, int index)
    {
        try
            {
            stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
            block block = stadium.getBlock(pos);
            category cat = block.getCategory(index);

            int occupiedSeats = 0;

            for (seat s : cat.getSeats()) {
                if (s.isOccupied()) {
                    occupiedSeats++;
                }
            }

            return "<div style='font-size:12px;text-decoration:none;'>Belegt: " + occupiedSeats + " von " + cat.getNumberOfSeats() + "</div>";
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "Fehler";
        }
    }

    public static HtmlForm drawSeats()
    {
        try
        {
            ArrayList<seat> selectedSeats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
            category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");

            int seats = category.getNumberOfSeats();
            Application app = FacesContext.getCurrentInstance().getApplication();
            HtmlForm form = (HtmlForm) app.createComponent(HtmlForm.COMPONENT_TYPE);
            form.setId("form_seats");
            HtmlOutputText back = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);
            back.setValue("<p><a href='Stadion.xhtml'>Zurück</a></p>");
            back.setEscape(false);
            back.setId("back");
            form.getChildren().add(back);

            if (seats == 0)
            {
                HtmlOutputText noSeats = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);
                noSeats.setValue("Keine Sitzplätze in dieser Kategorie gefunden.<br />Bitte wählen Sie eine andere Kategorie.");
                noSeats.setId("noSeats");
                noSeats.setEscape(false);
                form.getChildren().add(noSeats);
            }
            else
            {
                String style = STYLE_FREE;
                for (int i = 0; i < seats; i++)
                {
                    HtmlCommandLink link = (HtmlCommandLink) app.createComponent(HtmlCommandLink.COMPONENT_TYPE);
                    link.setValue(i);

                    if (category.getSeat(i).isOccupied() == true)
                    {
                        style = STYLE_OCCUPIED;
                        link.setDisabled(true);
                    }
                    else
                    {
                        if (selectedSeats.size() > 0 && selectedSeats.contains(category.getSeat(i)))
                        {
                            style = STYLE_SELECTED;
                        }
                        else
                        {
                            style = STYLE_FREE;
                        }
                    }

                    link.setActionExpression(createMethodExpression("#{bean_cup.selectSeat(" + i + ")}", String.class));
                    link.setId("seat_" + i);

                    HtmlOutputText openDiv = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);
                    HtmlOutputText closeDiv = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);

                    openDiv.setValue("<div class='seat' id='" + style + "'>");
                    closeDiv.setValue("</div>");
                    openDiv.setEscape(false);
                    closeDiv.setEscape(false);

                    if (i % SEATS_IN_ROW == 0)
                    {
                        HtmlOutputText clear = (HtmlOutputText) app.createComponent(HtmlOutputText.COMPONENT_TYPE);
                        clear.setValue("<div class='clear'></div>");
                        clear.setId("clear_" + i);
                        clear.setEscape(false);
                        form.getChildren().add(clear);
                    }

                    form.getChildren().add(openDiv);
                    form.getChildren().add(link);
                    form.getChildren().add(closeDiv);
                }
            }
            return form;
        }
        catch (Exception ex)
        {
            log.printException(ex);
            return null;
        }
    }

    public static String checkout()
    {
        try
            {
            ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
            stadium current_stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
            stadium god_stadium = god.getStadiums().get(Integer.parseInt(current_stadium.getId()) - 1);
            block current_block = (block) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("block");
            block god_block = god_stadium.getBlock(current_block.getPos());
            category current_category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");
            category god_category = god_block.getCategory(current_category.getName());

            String customer_email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
            ArrayList<String> ids = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passportids");

            if (seats.size() == ids.size())
            {
                if (seats.size() > 0)
                {
                    for (seat s : seats)
                    {
                        if (god_category.getSeats().contains(s))
                        {
                            god.setOccupied(s, true);
                        }
                    }
                    ArrayList<seat> transactionSeats = new ArrayList<>();
                    transactionSeats.addAll(seats);

                    customer cust = new customer();
                    cust.setEmail(customer_email);
                    cust.setIds(ids);
                    transaction trans = new transaction(Integer.parseInt(current_stadium.getId()), current_block.getPos(), current_category.getName(), cust, transactionSeats);
                    god.addTransaction(trans);
                    log.printLog("checkout", "seats.size: " + seats.size());
                    if(EMAIL_ENABLED)
                    {
                        email.email.sendCheckoutMail(trans);
                    }
                    seats.clear();
                    return "/Success.xhtml?faces-redirect=true&type=seatsBought";
                }
                else
                {
                    return "/Error.xhtml?faces-redirect=true&type=noSeatsSelected";
                }
            }
            else
            {
                if(seats.size() == 0)
                {
                    return "/Error.xhtml?faces-redirect=true&type=seatsOccupied";
                }
                else
                {
                    return "/Error.xhtml?faces-redirect=true&type=passportIdError";
                }
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static String kophase()
    {
        try
        {
            if(auth.isAuth())
            {
                ArrayList<bewerbung> hasSeen = god.getBewerbungenHasSeen();
                ArrayList<bewerbung> hasNotSeen = god.getBewerbungenHasNotSeen();

                log.printLog("einsortieren", "hasSeen: " + hasSeen.size());
                log.printLog("einsortieren", "hasNotSeen: " + hasNotSeen.size());

                log.printLog("einsortieren", "hasNotSeen not sorted: " + hasNotSeen.get(0).getId());

                Collections.sort(hasSeen, new CArrayList());
                Collections.sort(hasNotSeen, new CArrayList());

                log.printLog("einsortieren", "hasNotSeen sorted: " + hasNotSeen.get(0).getId());

                for(bewerbung bw : hasNotSeen)
                {
                    takePlace(bw);
                }

                for(bewerbung bw : hasSeen)
                {
                    takePlace(bw);
                }

                god.toggleGameType();
                return "/Success.xhtml?faces-redirect=true&type=deadline";
            }
            else
            {
                return "index";
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }
    
    public static void takePlace(bewerbung bw)
    {
        try
        {
            log.printLog("einsortieren", "current bewerbung id: " + bw.getId());

            if(bw.isAccepted() == false)
            {
                log.printLog("einsortieren", "accepted = false");

                stadium stadium = god.getStadiums().get(bw.getStadionId() - 1);
                block block = stadium.getBlock(bw.getBlockPosition());
                category cat = block.getCategory(bw.getCategoryName());
                log.printLog("einsortieren", "category number of free seats: " + cat.getNumberOfFreeSeats());

                int startIndex = cat.getFirstFreeSeat();
                int lastIndex = (bw.getNumberOfseats() - 1) + startIndex;

                if(cat.getNumberOfSeats() < bw.getNumberOfseats() || cat.getNumberOfFreeSeats() < bw.getNumberOfseats() || lastIndex >= cat.getNumberOfSeats())
                {
                    log.printLog("einsortieren", "stadion voll, zu wenig plätze insgesammt");
                    if(EMAIL_ENABLED)
                    {
                        //email.email.sendBewerbungNotAcceptedMail(bw.toTransaction());
                    }
                }
                else
                {
                    for(int i = startIndex; i <= lastIndex; i++)
                    {
                        if(i > 0 && i % SEATS_IN_ROW == 0)
                        {
                            log.printLog("einsortieren", bw.getId() + " würde getrennt werden, startIndex: " + startIndex + ", lastIndex: " + lastIndex + ", i: " + i);
                            startIndex = cat.getFirstFreeSeat((i / 10) - 1);
                            lastIndex = (bw.getNumberOfseats() - 1) + startIndex;
                        }
                        else
                        {
                            log.printLog("einsortieren", "nix muss getrennt werden");
                        }
                    }

                    log.printLog("einsortieren", "bewerbung number of seats: " + bw.getNumberOfseats());
                    log.printLog("einsortieren", "first free seat index: " + startIndex);
                    log.printLog("einsortieren", "last seat index: " + lastIndex);

                    if(lastIndex < cat.getNumberOfSeats() && cat.areSeatsFree(startIndex, lastIndex)  == true)
                    {   
                        log.printLog("einsortieren", "seats range free");

                        cat.occupySeats(startIndex, lastIndex);

                        log.printLog("einsortieren", "sorted in");
                        bw.setAccepted(true);

                        log.printLog("einsortieren", "transaction added");
                        transaction trans = bw.toTransaction();
                        trans.setSeats(cat.getSeats(startIndex, lastIndex));
                        log.printLog("einsortieren", "seats list created from " + startIndex + " to " + lastIndex + ", size: " + trans.getSeats().size() + ", content: " + trans.getSeats().toString());

                        //log.printTransaction(trans);
                        god.addTransaction(trans);
                        if(EMAIL_ENABLED)
                        {
                            email.email.sendBewerbungAcceptedMail(trans);
                        }
                    }
                    else
                    {
                        log.printLog("einsortieren", "nicht genug freie plätze vorhanden");
                        if(EMAIL_ENABLED)
                        {
                            //email.email.sendBewerbungNotAcceptedMail(bw.toTransaction());
                        }
                    }
                }
            }
            else
            {
                log.printLog("einsortieren", "accepted = true, skipped");
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
        }
    }

    public static String bewerben()
    {
        try
        {
            //ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
            stadium stadium = (stadium) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stadium");
            block block = (block) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("block");
            category category = (category) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("category");

            ArrayList<String> ids = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passportids");
            int numberOfSeats = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("numberOfSeats");
            String customer_email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");

            if (numberOfSeats != ids.size())
            {
                return "/Error.xhtml?faces-redirect=true&type=passportIdError";
            }
            else if(numberOfSeats > category.getNumberOfSeats())
            {
                return "/Error.xhtml?faces-redirect=true&type=tooManySeats";
            }
            else if(god.hasSeen(ids))
            {
                return "/Error.xhtml?faces-redirect=true&type=hasSeen";
            }
            else
            {
                customer bewerber = new customer();
                bewerber.setEmail(customer_email);
                bewerber.setIds(ids);
                bewerbung bewerbung = new bewerbung(Integer.parseInt(stadium.getId()), block.getPos(), category.getName(), bewerber, numberOfSeats);
                god.addBewerbung(bewerbung);
                if(EMAIL_ENABLED)
                {
                    email.email.sendBewerbungsMail(bewerbung);
                }
                return "/Success.xhtml?faces-redirect=true&type=beworben";
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static String buySeats()
    {
        try
        {
            ArrayList<seat> seats = (ArrayList<seat>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("seats");
            if (seats.size() > 0)
            {
                return "BuySeats";
            }
            else
            {
                return "/Error.xhtml?faces-redirect=true&type=noSeatsSelected";
            }
        }
        catch(Exception ex)
        {
            log.printException(ex);
            return "/Error.xhtml?faces-redirect=true&type=exception";
        }
    }

    public static void addPassportId(String id)
    {
        try
        {
            String[] arrIds = id.split("Stop|\n");

            ArrayList<String> ids = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("passportids");

            ids.addAll(Arrays.asList(arrIds));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passportids", ids);
        }
        catch(Exception ex)
        {
            log.printException(ex);
        }
    }

    private static MethodExpression createMethodExpression(String expression, Class<?> returnType)
    {
        FacesContext context = FacesContext.getCurrentInstance();
        MethodExpression me = context.getApplication().getExpressionFactory().createMethodExpression(context.getELContext(), expression, returnType, new Class[0]);
        return me;
    }

}
