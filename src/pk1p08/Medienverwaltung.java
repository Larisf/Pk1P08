
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Bambi^
 */
public class Medienverwaltung implements Serializable
{	
	public Iterator<Medium> iterator;
	private static final long serialVersionUID = 42l;
	private List<Medium> Medien = new LinkedList<>();
	public void aufnehmen(Medium m)
	{
		Medien.add(m);
	}
	public void zeigeMedien(OutputStream Stream)
	{
		Collections.sort(Medien, new Compare());
		for (Medium k : Medien)
			k.druckeDaten(Stream);
	}
	public int zähleMedien()
	{
		int i = 0;
		for(Medium k : Medien)
			i++;
		return i;
	}
	public OutputStream sucheNeuesMedium(OutputStream Stream)
	{
		Medium b = Medien.get(0);
		 for(Medium k : Medien)
			if(k.alter() < b.alter()) b = k;
				//System.out.printf("%n");
			//b.druckeDaten(Stream);
			return Stream;
			
			
	}
	public double berechneErscheinungsjahr()
	{
		double Summe = 0;
		for(Medium a: Medien) 
			Summe += a.getJahr();
		return Summe/Medien.size();	 
	}
	public void erstelleMedienliste(File DateiName) throws FileNotFoundException 
	{
		OutputStream Daten = new FileOutputStream(DateiName);
		Collections.sort(Medien, new Compare());
		for (Medium k : Medien)
			k.druckeDaten(Daten);
	}
	public void erstelleSicherung(File Sicherung) throws IOException
	{
		try(FileOutputStream fos = new FileOutputStream(Sicherung);
			ObjectOutputStream oos = new ObjectOutputStream(fos))
		{	
			oos.writeObject(Medien);
			oos.close();
		}
	}
	public  void getMedienliste(File Datei) throws IOException, ClassNotFoundException
	{
		try(FileInputStream fis = new FileInputStream(Datei);
			ObjectInputStream ois = new ObjectInputStream(fis))
		{
			int i = 1;
			Medien = (List<Medium>) ois.readObject();
			for (Medium k :Medien)
				k.setID(i++);
			ois.close();
		}
	}
}
	
