package info.polarissolutions.moneymanager.navigation;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class Navigation {
	
	private Stage primaryStage;
	private BorderPane rootPane;
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
	 * if stage is already set throw new RuntimeException
	 * @param pS
	 */
	public void setPrimaryStage(Stage pS) {
		if(primaryStage != null) {
			throw new RuntimeException("Primary Stage cound not be set again!");
		}
		primaryStage = pS;
		
		rootPane = ViewFactory.createRootPane();
		primaryStage.setScene(ViewFactory.initRootScene(rootPane));
	}
	
	/**
	 * set ChildView in center of root Panel 
	 * @param view
	 */
	public void navigate(View view) {
		if(primaryStage == null) {
			throw new RuntimeException("Stage is null");
		}
		rootPane.setLeft(null);
		rootPane.setCenter(ViewFactory.createChildView(view));
		rootPane.setRight(null);
		rootPane.setBottom(null);

	}
}
