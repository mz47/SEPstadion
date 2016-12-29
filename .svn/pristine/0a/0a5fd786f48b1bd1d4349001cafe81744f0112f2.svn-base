/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;
import buying.bewerbung;
import java.util.Comparator;

/**
 *
 * @author Philipp
 */
public class CustomComparator implements Comparator<bewerbung>{
    @Override
    public int compare(bewerbung b1, bewerbung b2){
        int comparison = 0;
        if (b1.getNumberOfseats()>b2.getNumberOfseats()){
            comparison=1;
        } else if (b1.getNumberOfseats()<b2.getNumberOfseats()){
        comparison=-1;
        }
        return comparison;
    }
}
