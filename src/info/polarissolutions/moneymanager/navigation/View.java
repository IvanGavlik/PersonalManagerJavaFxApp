package info.polarissolutions.moneymanager.navigation;

public enum View { 
	ROOT("/view/root.fxml", 800, 600),
	LOGIN("/view/login.fxml", 330, 275),
	MONEY_MANAGER("/TODO", 300, 300);
	
	private String filePath;
	private int width;
	private int height; 
	
	private View(String fP,int w, int h) {
		filePath = fP;
		width = w;
		height = h;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
}
