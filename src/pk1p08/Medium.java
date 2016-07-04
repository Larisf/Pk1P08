/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

import java.io.OutputStream;
import java.io.Serializable;


/**
 *
 * @author Bambi^
 */
public abstract class Medium implements Serializable {
    private int id;
    private static int nextId;
    private String titel;
    private int Jahr;
    
    Medium(String titel, int Jahr)
    {
        this.titel = titel;
        this.Jahr = Jahr;
        this.id = nextId++;
    } 
    public abstract int alter();
    public abstract void druckeDaten(OutputStream Stream);
    private void setJahr(int Jahr)
    {
      this.Jahr = Jahr;
    }
    private void setTitel(String titel)
    {
        this.titel = titel;
    }
	public void setID(int id)
	{
		this.nextId = id;
	}
    public int getId()
    {
        return this.id;
    }
    public int getJahr()
    {
        return this.Jahr;
    }
    public String getTitel()
    {
        return this.titel;
    }
}
