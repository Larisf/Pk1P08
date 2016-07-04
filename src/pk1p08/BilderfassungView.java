/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1p08;

import java.io.OutputStream;
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
public class BilderfassungView extends Stage {
	private String ortb;
	private int aufnahmeJahrb;
	private String titelb;
	
	BilderfassungView(Stage stage)   {
		showBildErfassungDialog(stage);
	}
	private void showBildErfassungDialog(Stage PrimaryStage){
		System.out.println("Bild");
		Stage dialog = new Stage();
		GridPane gp = new GridPane();
		gp.setPadding(new Insets(10.0, 20.0, 10.0, 20.0));
		gp.setVgap(10);
		dialog.initOwner(PrimaryStage);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.setTitle("Bilderfassung");
		TextField titel = new TextField();
		TextField ort = new TextField();
		TextField aufnahmejahr = new TextField();
		Label titela = new Label("Titel: ");
		Label orta = new Label("Ort: ");
		Label aufnahmejahra = new Label("Aufnahmejahr: ");
		Button neu = new Button();
		neu.setText("neu");
		Button abbrechen = new Button();
		abbrechen.setText("abbrechen");
		abbrechen.onActionProperty();
		gp.addRow(0, titela, titel);
		gp.addRow(1, orta, ort);
		gp.addRow(2, aufnahmejahra, aufnahmejahr);
		gp.addRow(4, neu, abbrechen);
		Scene sc = new Scene(gp, 600, 200);
		dialog.setScene(sc);
		dialog.show();
	}
}
