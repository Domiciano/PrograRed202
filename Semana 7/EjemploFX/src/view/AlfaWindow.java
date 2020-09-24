package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.AlfaController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlfaWindow extends Stage{
	
	//COMPONENTES
    private Button miButton;
    private Label miLabel;
    private AlfaController controller;
    
    public AlfaWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("alfawindow.fxml"));
    		Parent parent = loader.load();
    		
    		
    		miButton = (Button) loader.getNamespace().get("miButton");
    		miLabel = (Label) loader.getNamespace().get("miLabel");
    		
			Scene scene = new Scene(parent);
			this.setScene(scene);
			
			controller = new AlfaController(this);
    	}catch(IOException ex) {
    		ex.printStackTrace();
    		
    	}
    }
    
    public Stage getStage() {
    	return this;
    }

	public Button getMiButton() {
		return miButton;
	}

	public Label getMiLabel() {
		return miLabel;
	}


}