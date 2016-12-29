
package drawing;

public abstract class message
{
    
    public static String getMessage(String message)
    {
        String output;
        switch (message)
        {    
            case "seatsBought":
                output = "Die Sitzplätze wurden erfolgreich reserviert. Zur Bestätigung wurde eine Email versandt.";
                break;
            case "beworben":
                output = "Die Bewerbung wurde erfolgreich gespeichert. Bei einem Zuspruch erhalten Sie eine Email.";
                break;
            case "cancelled":
                output = "Ihre Buchung wurde erfolgreich storniert. Zur Bestätigung wurde eine Email versandt.";
                break;
            case "deadline":
                output = "Die Bewerbungsphase wurde erfolgreich beendet. Die restlichen Plätze sind nun wieder verfügbar.";
                break;
            case "logout":
                output = "Sie haben sich erfolgreich abgemeldet.";
                break;
            case "passportIdError":
                output = "Anzahl Pass-IDs und ausgewählte Plätze stimmen nicht überein.";
                cup.clearCustomerContext();
                break;
            case "noSeatsSelected":
                output = "Bitte mindestens einen Sitzplatz auswählen.";
                break;
            case "auth":
                output = "Benutzername und/oder Passwort falsch.";
                break;
            case "InvoiceIdNotFound":
                output = "Es wurde keine Buchung mit der angegebenen Rechnungsnummer gefunden. Bitte überprüfen Sie Diese nocheinmal.";
                break;
            case "tooManySeats":
                output = "Anzahl der Sitzplätze ist höher als die Anzahl von verfügbaren Sitzplätzen.";
                break;
            case "hasSeen":
                output = "Pro Spiel ist leider nur eine Bewerbung möglich.";
                break;
            case "exception":
                output = "Schwerwiegender Fehler. Bitte zur Startseite zurückkehren.";
                break;
            case "seatsOccupied":
                output = "Die ausgewählen Sitzplätze wurden in der Zwischenzeit bereits gebucht. Bitte ändern Sie ihre Auswahl.";
                break;
            default:
                output = "Kritischer Fehler!";
        }
        return output;
    }   
}
            
