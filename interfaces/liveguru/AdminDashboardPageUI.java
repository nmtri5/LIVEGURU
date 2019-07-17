package liveguru;

public class AdminDashboardPageUI {
	public static final String DYNAMIC_ADMIN_MENU= "//span[text() = '%s']";
	public static final String DYNAMIC_ADMIN_SUBMENU= "//span[text() = '%s']/ancestor-or-self::a";
	
	public static final String ADMIN_MESSAGE_POPUP = "//div[@id = 'message-popup-window']";
	public static final String ADMIN_MESSAGE_POPUP_CLOSE_ICON = "//div[@id = 'message-popup-window']//a[@title = 'close']";
}
