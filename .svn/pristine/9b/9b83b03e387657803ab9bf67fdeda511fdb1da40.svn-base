
package dataStorage;

import buying.transaction;

public abstract class log {
 
    public static void printLog(String method, String message)
    {
        System.out.println("DEBUG: @ " + method + ": " + message);
    }
    public static void printException(Exception ex)
    {
        System.out.println("EXCEPTION: @ " + ex.getClass().getName() + ", " + ex.getMessage());
    }
    public static void printTransaction(transaction t)
    {
        System.out.println("transaction id: " + t.getId());
        System.out.println("transaction stadium id: " + t.getStadionId());
        System.out.println("transaction date: " + t.getDate());
        System.out.println("transaction customer email: " + t.getCustomer().getEmail());
        System.out.println("transaction customer ids: " + t.getCustomer().getIds().toString());
        System.out.println("transaction block position: " + t.getBlockPosition());
        System.out.println("transaction category index: " + t.getCategoryIndex());
        System.out.println("transaction seats: " + t.getSeats().toString());
    }
}
