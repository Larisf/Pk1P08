/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;
import java.util.Comparator;

public class Compare implements Comparator<Medium>{
    @Override
    public int compare(Medium a1 , Medium a2){
        return -1 * Double.compare(a1.getJahr(), a2.getJahr());
    }
}
