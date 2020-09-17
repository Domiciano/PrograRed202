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
	private TextField ipTF;
	private TextField portTF;
	private Button btnConnect;
	
	private ConnectionController control;
	
	
	public ConnectionWindow() {
		
		btnConnect = new Button("Conectar");
		portTF = new TextField("5000");
		ipTF = new TextField("127.0.0.1");
		labelInstrucciones = new Label("Por favor ingrese la direccion IP del servidor y el puerto\npara establecer la conexion");
		
		VBox vBox = new VBox();
		vBox.getChildren().add(labelInstrucciones);
		vBox.getChildren().add(ipTF);
		vBox.getChildren().add(portTF);
		vBox.getChildren().add(btnConnect);
		
		scene = new Scene(vBox, 400,400);
		this.setScene(scene);
		control = new ConnectionController(this);
		
	}


	//Permitiendo acceso al control
	public TextField getIpTF() {
		return ipTF;
	}


	public TextField getPortTF() {
		return portTF;
	}


	public Button getBtnConnect() {
		return btnConnect;
	}
	
	
	
	

}
