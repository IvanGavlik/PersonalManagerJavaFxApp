package info.polarissolutions.moneymanager.navigation;

import info.polarissolutions.moneymanager.login.LoginView;
import info.polarissolutions.moneymanager.money.MoneyView;
import info.polarissolutions.moneymanager.scene.MoneyManagerView;
import info.polarissolutions.moneymanager.service.MoneyService;
import info.polarissolutions.moneymanager.service.MoneyServiceImpl;
import info.polarissolutions.moneymanager.service.UserService;
import info.polarissolutions.moneymanager.service.UserServiceImpl;
import javafx.scene.Scene;

public class ViewFactory {
	
	public static Scene createScene(View view) {
		
		MoneyManagerView moneyManagerView = null;
		
		switch (view) {
		case LOGIN:
			UserService us = new UserServiceImpl(); 
			moneyManagerView = new LoginView(us);
			return new Scene(moneyManagerView.getView(), 
					view.getWidth(), view.getHeight());
			
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
