package info.polarissolutions.moneymanager.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class ViewFactory {
	
	
	public static BorderPane createRootPane() {
		try {
			 return FXMLLoader.load(ViewFactory.class.getResource(View.ROOT.getFilePath()));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public static Scene initRootScene(BorderPane root) {
		return new Scene(root, View.ROOT.getWidth(), View.ROOT.getHeight());
	}
	
	public static Parent createChildView(View view) {
		try {
			return FXMLLoader.load(ViewFactory.class.getResource(view.getFilePath()));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);	
		}
	}
}
