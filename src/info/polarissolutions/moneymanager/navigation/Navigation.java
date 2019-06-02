package info.polarissolutions.moneymanager.navigation;

import javafx.stage.Stage;

public final class Navigation {
	
	private Stage primaryStage;
	private static Navigation instance;
	
	private Navigation() {
	}
 	
	public static Navigation getInstance() {
		synchronized (Navigation.class) {
			if(instance == null) {
				instance = new Navigation();
			}
			return instance;
		}
	}
	
	/**
	 * set Stage of application, call only once when stating application
	 * if stage is already set method will not do update
	 * @param pS
	 */
	public void setPrimaryStage(Stage pS) {
		if(primaryStage == null) {
			primaryStage = pS;
		}
	}
	
	/**
	 * set curent view
	 * @param view
	 */
	public void navigate(View view) {
		if(primaryStage == null) {
			throw new RuntimeException("Stage is null");
		}
		primaryStage.setScene(ViewFactory.createScene(view));
	}
}
