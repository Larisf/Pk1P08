/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

/**
 *
 * @author Bambi^
 */
public class EmptyFileException extends Exception{
	public EmptyFileException(){
		super();
	}
	public EmptyFileException(String message)
	{
		super(message);
	}
	
}
