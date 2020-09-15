package view;

import control.ConnectionController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConnectionWindow extends Stage{
	
	
	//UI Elements
	private Scene scene;
	private Label labelInstrucciones;
	private ConnectionController control;
	
	
	public ConnectionWindow() {
		
		labelInstrucciones = new Label("Esperando un cliente...");
		
		VBox vBox = new VBox();
		vBox.getChildren().add(labelInstrucciones);
		scene = new Scene(vBox, 400,400);
		this.setScene(scene);
		
		control = new ConnectionController(this);
		
	}


	public Label getLabelInstrucciones() {
		return labelInstrucciones;
	}
	
	
	
	

}
