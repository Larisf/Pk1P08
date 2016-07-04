/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Bambi^
 */
public class Bild extends Medium implements Serializable {
    private String ort;
	private int Jahr;
	LocalDate now = LocalDate.now();
    Bild(String titel, String ort, int Jahr)
    {
        super(titel,Jahr);
        this.ort = ort;
		this.Jahr = Jahr;
    }    
    private void setOrt(String ort)
    {
        this.ort = ort;
    }
    public String getOrt()
    {
        return ort;
    }
    @Override
    public int alter() 
    {
        return now.getYear() - Jahr;
    }
    @Override
    public void druckeDaten(OutputStream Stream) 
    {
		PrintWriter out = new PrintWriter(Stream, true);
		out.printf("ID = %d \"%s\" aufgenommen im Jahr %d in %s Alter: %d Jahre%n",super.getId(),super.getTitel(),super.getJahr(),ort,alter());
    }    
}
