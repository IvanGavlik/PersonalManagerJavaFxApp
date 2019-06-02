package info.polarissolutions.moneymanager.app;

import info.polarissolutions.moneymanager.navigation.Navigation;
import info.polarissolutions.moneymanager.navigation.View;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Solution extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Personal Manager");
		primaryStage.getIcons().add(new Image("/img/icon.png"));
		Navigation.getInstance().setPrimaryStage(primaryStage);
		Navigation.getInstance().navigate(View.LOGIN);
		primaryStage.show();
	}

}
