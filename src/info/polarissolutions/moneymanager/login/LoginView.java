package info.polarissolutions.moneymanager.login;

import info.polarissolutions.moneymanager.navigation.Navigation;
import info.polarissolutions.moneymanager.navigation.View;
import info.polarissolutions.moneymanager.service.UserService;
import info.polarissolutions.moneymanager.service.UserServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public final class LoginView {
	
	@FXML private Text infoText;
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	
	private UserService userService;
	
	private LoginView(UserService userService) {
		this.userService = userService;
		
	}	
	
	public LoginView() {
		this(new UserServiceImpl());
	}
	
	// called on start 
	@FXML private void initialize() {
    }
	
	@FXML
	protected void signInAction(ActionEvent event) {
		
		if(userService.login(userNameField.getText(), passwordField.getText())) {
			Navigation.getInstance().navigate(View.MONEY_MANAGER);
		} else {
			infoText.setText("Wrong user name of password");
		}
		userNameField.setText("");
		passwordField.setText("");
    }
	
		
		
		
		
}
