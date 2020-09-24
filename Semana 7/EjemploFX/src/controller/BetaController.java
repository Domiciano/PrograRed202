package controller;

import view.AlfaWindow;
import view.BetaWindow;

public class BetaController {
	
	private BetaWindow betaWindow;

	public BetaController(BetaWindow betaWindow) {
		this.betaWindow = betaWindow;
		init();
	}

	private void init() {
		betaWindow.getCloseBtn().setOnAction(
				event ->{
					betaWindow.close();
					
					AlfaWindow window = new AlfaWindow();
					window.show();
				}
		);
		
	}

}
