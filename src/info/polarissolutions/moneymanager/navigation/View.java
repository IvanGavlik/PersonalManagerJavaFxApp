package info.polarissolutions.moneymanager.navigation;

public enum View { 
	LOGIN("/view/login.fxml", 330, 275),
	MONEY_MANAGER("", 610, 390);
	
	private String fileName;
	private int width;
	private int height; 
	
	private View(String fN,int w, int h) {
		fileName = fN;
		width = w;
		height = h;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
}
