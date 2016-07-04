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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Bambi^
 */
public class AudioerfassungView extends Stage {
	AudioerfassungView(Bild bild, Stage stage){
		
	}

	AudioerfassungView(Stage stage) {
		showAudioErfassungDialog(stage);
	}
		private void showAudioErfassungDialog(Stage PrimaryStage){
		System.out.println("Audio");
		Stage dialog = new Stage();
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10.0, 20.0, 10.0, 20.0));
		gp.setVgap(10);
		dialog.initOwner(PrimaryStage);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Audioerfassung");
		TextField artist = new TextField();
		TextField titel = new TextField();
		TextField ejahr = new TextField();
		TextField laenge = new TextField();
		Label artista = new Label("Artist: ");
		Label titela = new Label("Titel: ");
		Label ejahra = new Label("Erscheinungsjahr: ");
		Label laengea = new Label("Länge: ");
		Button neu = new Button();
		neu.setText("neu");
		Button abbrechen = new Button();
		abbrechen.setText("abbrechen");
		abbrechen.onActionProperty();
		gp.addRow(0, artista, artist);
		gp.addRow(1, titela, titel);
		gp.addRow(2, ejahra, ejahr);
		gp.addRow(3, laengea, laenge);
		gp.addRow(4, neu, abbrechen);
		Scene sc = new Scene(gp, 600, 225);
		dialog.setScene(sc);
		dialog.show();	}

}
