/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Bambi^
 */
public class Audio extends Medium implements Serializable {
   private String interpret;
   private int dauer;
   private int Jahr;
   LocalDate now = LocalDate.now();
   Audio(String titel, String interpret, int Jahr, int dauer)
   {
       super(titel,Jahr);
       this.interpret = interpret;
       this.dauer = dauer;
	   this.Jahr = Jahr;
   }
   private void setInterpret(String interpret)
   {
       this.interpret = interpret;
   }
   private void setDauer(int dauer)
   {
       this.dauer = dauer;
   }
   public String getInterpret()
   {
       return interpret;
   }
   public int getDauer()
   {
       return dauer;
   }

    @Override
    public int alter() 
    {
        return now.getYear() - Jahr;
    }
    @Override
    public void druckeDaten(OutputStream Stream) 
    {
		PrintStream out = new PrintStream(Stream, true);
		out.printf("ID = %d \"%s\" von %s aus %d Spieldauer: %d Sekunden. Alter: %d Jahre%n",super.getId(),super.getTitel(),interpret,super.getJahr(),getDauer(),alter()).toString();
	}
}
