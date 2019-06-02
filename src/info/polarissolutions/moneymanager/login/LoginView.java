package info.polarissolutions.moneymanager.login;

import info.polarissolutions.moneymanager.navigation.Navigation;
import info.polarissolutions.moneymanager.navigation.View;
import info.polarissolutions.moneymanager.scene.MoneyManagerView;
import info.polarissolutions.moneymanager.service.UserService;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public final class LoginView implements MoneyManagerView {
	
	private UserService userService;
	private VBox vBox;
	
	
	public LoginView(UserService userService) {
		this.userService = userService;
		
		vBox = new VBox(); 
		vBox.setSpacing(10);
		
		Label title = new Label("Login");
		
		TextField name = new TextField();
		name.setPromptText("insert name");	
		
		PasswordField password = new PasswordField();
		password.setPromptText("insert password");
		
		
		Button login = new Button("Login");
		login.setOnAction(el -> {
			if(userService.login(name.getText(), password.getText())); {
				Navigation.getInstance().navigate(View.MONEY_MANAGER);
			} 
			name.setText("");
			password.setText("");

		});
		
		
		vBox.getChildren().addAll(title, name, password, login);
	}
	
	public VBox getView() {
		return vBox;
	}
}
