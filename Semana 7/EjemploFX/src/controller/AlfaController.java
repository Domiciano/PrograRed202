package controller;

import javafx.stage.Stage;
import view.AlfaWindow;
import view.BetaWindow;

public class AlfaController {

	private AlfaWindow alfaWindow;
	
	public AlfaController(AlfaWindow alfaWindow) {
		this.alfaWindow = alfaWindow;
		init();
	}
	
	public void init() {
		
		alfaWindow.getMiButton().setOnAction(
				e -> {
					alfaWindow.close();
					
					BetaWindow window = new BetaWindow();
				
					window.show();
					
					
					
				}
		);
		
	}

}
