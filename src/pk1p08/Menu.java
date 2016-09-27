/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.Formatter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



/**
 *
 * @author Bambi^
 */
public class Menu 
{
/* Globale Variablen ---------------------------------------------------------------------------------------------------------------------------------------------*/
		private int Jahr;
		private String Objekt;
		private String Ort;
		private int Dauer;
		private int wert;
		private String EJahr;
		private String Laenge;
		private String Menu;
		private String Datei;
		private File Sicherung;
		private String safe = "C:\\Users\\Bambi^\\Pictures\\safe.ser";
		private File Safe = new File(safe);
		Medienverwaltung medium = new Medienverwaltung();
/* Konstruktoren ------------------------------------------------------------------------------------------------------------------------------------------------- */
	public Menu() 
	{
	}
	public Menu(String Objekt, String Ort, int Jahr)
	{
		this.Objekt = Objekt;
		this.Ort = Ort;
		this.Jahr = Jahr;	
	}
		public Menu(String Objekt, String Ort, int Jahr, int Dauer)
	{
		this.Objekt = Objekt;
		this.Ort = Ort;
		this.Jahr = Jahr;
		this.Dauer = Dauer;
	}
/* Set Methoden -------------------------------------------------------------------------------------------------------------------------------------------------- */
	private void setWahl(int wert)
	{
		this.wert = wert;
	}
	private void setEJahr(int Jahr)
	{
		this.Jahr = Jahr;
	}
	private void setLaenge(int Dauer)
	{
		this.Dauer = Dauer;
	}
	private void setDatei(String Datei)
	{
		this.Datei = Datei;
	}
/* Get Methoden -------------------------------------------------------------------------------------------------------------------------------------------------- */
	public int getJahr()
	{
		return Jahr;
	}
	public String getOA() //Ort Artist
	{
		return Ort;
	}
	public String getOT() //Objekt Titel
	{
		return Objekt;
	}
	public int getDauer()
	{
		return Dauer;
	}

	public String getDatei()
	{
		return Datei;
	}
	public int getWahl()
	{
		return wert;
	}
/* Funktion zum anlegen einer Audio Datei ------------------------------------------------------------------------------------------------------------------------ */
	private void setAudio()
	{
		try
		{
			Objekt = JOptionPane.showInputDialog(null,"Titel:", "Audio aufnehmen", JOptionPane.QUESTION_MESSAGE);
			if(Objekt != null)
			{
				Ort = JOptionPane.showInputDialog(null, Objekt + "\n" + "Artist:", "Audio aufnehmen", JOptionPane.QUESTION_MESSAGE);
				if(Ort != null)
				{
					EJahr = JOptionPane.showInputDialog(null, Objekt + " " + Ort + "\n" + "Erscheinungsjahr:", "Audio aufnehmen", JOptionPane.QUESTION_MESSAGE);
					if(EJahr != null)
					{
						setEJahr(Integer.parseInt(EJahr));
						Laenge = JOptionPane.showInputDialog(null, Objekt + " " + Ort + " " + EJahr + "\n" + "Länge(in Sekunden): ", "Audio aufnehmen", JOptionPane.QUESTION_MESSAGE);
						if(Laenge != null)
						{
							setLaenge(Integer.parseInt(Laenge));
							Menu Audio = new Menu(Objekt,Ort,Jahr, Dauer);
							medium.aufnehmen(new Audio(Audio.getOT(),Audio.getOA(),Audio.getJahr(),Audio.getDauer()));
						}
					}
				}
			}
		}
		catch(NumberFormatException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nBitte Gültige Zahl eingeben!");
				JOptionPane.showMessageDialog(null, f.toString());
			} 
		}
	}
/* Funktion zum anlegen eines Bildes ----------------------------------------------------------------------------------------------------------------------------- */
	private void setBild()
	{
		try
		{
			Objekt = JOptionPane.showInputDialog(null, "Name:","Bild aufnehmen", JOptionPane.QUESTION_MESSAGE);
			if(Objekt != null)
			{
				Ort = JOptionPane.showInputDialog(null, Objekt + "\n" + "Ort:","Bild aufnehmen", JOptionPane.QUESTION_MESSAGE);
				if(Ort != null)
				{
					EJahr = JOptionPane.showInputDialog(null,Objekt + " " + Ort + "\n" + "Erscheinungsjahr:","Bild aufnehmen", JOptionPane.QUESTION_MESSAGE);
					if (EJahr != null)
					{	
						setEJahr(Integer.parseInt(EJahr));
						Menu Bild = new Menu(Objekt,Ort,Jahr);
						medium.aufnehmen(new Bild(Bild.getOT(),Bild.getOA(),Bild.getJahr()));
					}
				}
			}
		}
		catch(NumberFormatException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nBitte Gültige Zahl eingeben!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		}
	}
/* Hilfsfunktion zum ermitteln des Durchschnittsjahres ----------------------------------------------------------------------------------------------------------- */
	private void getDurchschnittsjahr()
	{
		if(Double.isNaN(medium.berechneErscheinungsjahr()))
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKeine Medieneinträge vorhanden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
			else
				System.out.printf("Das Durchschnittsjahr ist: %.0f%n",medium.berechneErscheinungsjahr());
	}
/* Hilfsfunktion zum ermitteln der Medien ------------------------------------------------------------------------------------------------------------------------ */
	private void getMedien()
	{
		if(medium.zähleMedien() == 0)
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKeine Medieneinträge vorhanden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		else
			medium.zeigeMedien(System.out);
	}
/* Funktion zum anlegen der Medienliste -------------------------------------------------------------------------------------------------------------------------- */
	private void setMedienliste() throws EmptyFileException, IOException, ClassNotFoundException
	{
		Objekt = JOptionPane.showInputDialog(null,"Dateinamen eingeben:", "Mediendatei anlegen", JOptionPane.YES_NO_CANCEL_OPTION);
		if(Objekt == null)
			zeigeMenu();
		else
			setDatei(String.format(Objekt));
			File dateiName = new File("C:\\Users\\Bambi^\\Pictures\\" + Objekt + ".txt");
			Sicherung = new File(safe);
			try
			{
				if(Objekt.isEmpty())
					throw new EmptyFileException();
				else
					medium.erstelleMedienliste(dateiName);
					medium.erstelleSicherung(Sicherung);
			}
			catch(EmptyFileException e)
			{
				if(JOptionPane.showConfirmDialog(null,"Dateiname ist leer! Neuen Dateinamen eingeben?","Hinweis",JOptionPane.YES_OPTION)== JOptionPane.YES_NO_OPTION)
					setMedienliste();
			}
	}
/* Funktion zum löschen der Datei ---------------------------------------------------------------------------------------------------------------------- */
	private void loescheMedienliste() throws IOException, ClassNotFoundException
	{
		try
		{
			medium.delMedienliste(Safe);
		}
		catch (ClassNotFoundException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKlasse wurde nicht gefunden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		}
		catch (InvalidClassException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nFalsche Dateiversion!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		}
	}
/* Funktion zum importieren der Medienliste ---------------------------------------------------------------------------------------------------------------------- */
	private void importiereMedienliste() throws IOException, ClassNotFoundException
	{
		try
		{
			medium.getMedienliste(Safe);
			if(medium.zähleMedien() == 1) 
				try (Formatter f = new Formatter()) 
					{
						f.format("Medienliste mit " + medium.zähleMedien() + " Element erfolgreich importiert.");
						JOptionPane.showMessageDialog(null, f.toString());
					}
			else
				try (Formatter f = new Formatter()) 
				{
					f.format("Medienliste mit " + medium.zähleMedien() + " Elementen erfolgreich importiert.");
					JOptionPane.showMessageDialog(null, f.toString());
				}
		}
		catch (ClassNotFoundException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKlasse wurde nicht gefunden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		}
		catch (InvalidClassException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nFalsche Dateiversion!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
		}
	}
/* Funktion zum importieren der Medienliste ---------------------------------------------------------------------------------------------------------------------- */
/*	private void importiereMedienliste() throws EmptyFileException, IOException, ClassNotFoundException
	{
		Objekt = JOptionPane.showInputDialog(null,"Dateinamen eingeben:", "Mediendatei importieren", JOptionPane.YES_NO_CANCEL_OPTION);
		if(Objekt == null)
			zeigeMenu();
		else
			setDatei(String.format(Objekt));
			File dateiName = new File("C:\\Users\\Bambi^\\Pictures\\" + Objekt + ".ser");
			try
			{
				if(Objekt.isEmpty())
					throw new EmptyFileException();
				else
					medium.getMedienliste(dateiName);
					if(medium.zähleMedien() == 1) 
						try (Formatter f = new Formatter()) 
						{
							f.format("Medienliste mit " + medium.zähleMedien() + " Element erfolgreich importiert.");
							JOptionPane.showMessageDialog(null, f.toString());
						}
						else
							try (Formatter f = new Formatter()) 
							{
								f.format("Medienliste mit " + medium.zähleMedien() + " Elementen erfolgreich importiert.");
								JOptionPane.showMessageDialog(null, f.toString());
							}
			}
			catch(EmptyFileException e)
			{
				if(JOptionPane.showConfirmDialog(null,"Dateiname ist leer! Neuen Dateinamen eingeben?","Hinweis",JOptionPane.YES_OPTION)== JOptionPane.YES_NO_OPTION)
					importiereMedienliste();
			}
	}*/
/* Funktion zum erstellen des Menus ------------------------------------------------------------------------------------------------------------------------------ */
private void erstelleMenu() throws EmptyFileException, FileNotFoundException, IOException, ClassNotFoundException
	{ 
		try
		{
			while(true)
			{
				UIManager.put("OptionPane.okButtonText","Bestätigen");
				UIManager.put("OptionPane.cancelButtonText","Beenden");
				Menu = JOptionPane.showInputDialog(null
				, "										1. Audio aufnehmen\n"
				+ "										2. Bild Aufnehmen\n"
				+ "										3. Zeige alle Medien\n"
				+ "										4. Medienliste in Datei schreiben\n"
				+ "										5. Medienliste importieren\n"
				+ "										6. Zeige neues Medium\n"
				+ "										7. Lösche Mediendatei\n"
				+ "										8. Berechne Durchschnittsjahr\n"
				+ "										9. Beenden\n"
				, "										Medienverwaltung"
				,										JOptionPane.QUESTION_MESSAGE);
				setWahl(Integer.parseInt(Menu));
				switch(getWahl())
				{
					case 1: //Audio hinzufügen
						setAudio();
						break;
					case 2:  //Bild hinzufügen
						setBild();
						break;
					case 3: //Medien zeigen
						getMedien();
						break;
					case 4:  //Medienliste erstellen
						setMedienliste();
						break;
					case 5: //Medienliste importieren
						importiereMedienliste();
						break;
					case 6: //neustes Medium suchen
						medium.sucheNeuesMedium(System.out);
						break;
					case 7: //Datei loeschen
						loescheMedienliste();
						break;
					case 8: //Durchschnittsjahr ermitteln
						getDurchschnittsjahr();
						break;
					case 9: //Programm beenden
						System.out.printf("Exit\n");
						System.exit(0);
						break;
					default: 
						try (Formatter f = new Formatter()) 
						{
							f.format("Ungültige Zahl! Bitte geben sie eine Zahl zwischen 1-6 ein!");
							JOptionPane.showMessageDialog(null, f.toString());
						}
				}
			}
		}
		catch (NumberFormatException e)
		{
			if (Menu == null)
				System.out.printf("Exit%n");
			else
			{
				try (Formatter f = new Formatter()) 
				{
					f.format("Fehler:\nBitte Gültige Zahl eingeben!");
					JOptionPane.showMessageDialog(null, f.toString());
				}
					zeigeMenu();	
			}
		}
		catch (IndexOutOfBoundsException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKeine Medieneinträge vorhanden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
				zeigeMenu();
		}
		catch (FileNotFoundException e)
		{
			try (Formatter f = new Formatter()) 
			{
				f.format("Fehler:\nKeine Datei vorhanden!");
				JOptionPane.showMessageDialog(null, f.toString());
			}
				zeigeMenu();
		}
		
	}
/* Funktion zum Aufruf über die Main ----------------------------------------------------------------------------------------------------------------------------- */
	public void zeigeMenu() throws EmptyFileException, FileNotFoundException, IOException, ClassNotFoundException
	{
		erstelleMenu();
	}
}	

