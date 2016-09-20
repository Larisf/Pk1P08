/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bambi^
 */
public class Stage extends Application {
	@Override
	public void start(javafx.stage.Stage primaryStage) {
		BorderPane bp  = new BorderPane();
		VBox vb = new VBox();
		vb.setPadding(new Insets(10.0,20.0,10.0,20.0));
		vb.setSpacing(10.0);
		Button bild = new Button("Bilderfassung");
		Button audio = new Button("Audioerfassung");		
		vb.getChildren().addAll(bild, audio);
		bp.setLeft(vb);		
		bild.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				BilderfassungView bild = new BilderfassungView(primaryStage);
			}
		});
		audio.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				AudioerfassungView audio = new AudioerfassungView(primaryStage);
			}
		});
		
		Scene szene = new Scene(bp,500,600);
		primaryStage.setTitle("Medienverwaltung");
		primaryStage.setScene(szene);
		primaryStage.show();    
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}

