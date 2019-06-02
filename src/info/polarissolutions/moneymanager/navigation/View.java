package info.polarissolutions.moneymanager.navigation;

public enum View {
	LOGIN(200, 200), MONEY_MANAGER(610, 390);
	
	private int width;
	private int height;
	
	private View(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
}
