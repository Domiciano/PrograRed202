package view;

import java.io.IOException;

import controller.AlfaController;
import controller.BetaController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BetaWindow extends Stage{

	//VARIABLE PRINCIPAL
	private Stage stage;
	
    private Label titleLabel;

    private Button closeBtn;
    
    private BetaController controller;
    
    public BetaWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("betawindow.fxml"));
    		Parent parent = loader.load();
    		
    		titleLabel = (Label) loader.getNamespace().get("titleLabel");
    		closeBtn = (Button) loader.getNamespace().get("closeBtn");
    		
			Scene scene = new Scene(parent);
			this.setScene(scene);
			
			controller = new BetaController(this);
    	}catch(IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public Stage getStage() {
    	return stage;
    }

	public Label getTitleLabel() {
		return titleLabel;
	}


	public Button getCloseBtn() {
		return closeBtn;
	}
	
	public void closeWindow() {
		stage.close();
	}
    
    
}
