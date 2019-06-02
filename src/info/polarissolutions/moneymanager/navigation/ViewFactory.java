package info.polarissolutions.moneymanager.navigation;

import java.io.IOException;

import info.polarissolutions.moneymanager.login.LoginView;
import info.polarissolutions.moneymanager.money.MoneyView;
import info.polarissolutions.moneymanager.scene.MoneyManagerView;
import info.polarissolutions.moneymanager.service.MoneyService;
import info.polarissolutions.moneymanager.service.MoneyServiceImpl;
import info.polarissolutions.moneymanager.service.UserService;
import info.polarissolutions.moneymanager.service.UserServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ViewFactory {
	
	public static Scene createScene(View view) {
		try {
			return createSceneUtil(view);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);	
		}
	}
	
	private static Scene createSceneUtil(View view) throws IOException {
		MoneyManagerView moneyManagerView = null;
		
		switch (view) {
		case LOGIN:
			Parent root = FXMLLoader.load(ViewFactory.class.getResource(view.getFileName()));
		    return new Scene(root, view.getWidth(), view.getHeight()); 	
			
		case MONEY_MANAGER:
			MoneyService ms = new MoneyServiceImpl();
			moneyManagerView = new MoneyView(ms);
			return new Scene(moneyManagerView.getView(), 
					view.getWidth(), view.getHeight());
			
		default:
			throw new RuntimeException("view not found " + view.name());
		}
		
	}
}
