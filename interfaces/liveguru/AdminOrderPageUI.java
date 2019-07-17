package liveguru;

public class AdminOrderPageUI {

	public static final String ADMIN_SEARCH_STATUS_DROPDOWN = "//select[@name = 'status']";
	public static final String ADMIN_SEARCH_STATUS_BUTTON = "//button[@title = 'Search']";
	
	public static final String ADMIN_FIRST_RECORD = "(//input[@name = 'order_ids'])[1]";
	
	public static final String ADMIN_ACTIONS = "//label[text() = 'Actions']/following-sibling::select";
	public static final String ADMIN_ACTIONS_SUBMIT = "//button[@title = 'Submit']";
	public static final String ADMIN_PAGINATION_DROPDOWN = "//select[@name ='limit']";
	public static final String ADMIN_DISPLAYED_ROWS = "//table[@class = 'data']//tbody/tr";
	public static final String DYNAMIC_MASS_ACTION_LINK = "//table[@class = 'massaction']//a[text() = '%s']";
	public static final String ITEMS_SELECTED_MESSAGE = "//table[@class = 'massaction']//td";
	public static final String ADMIN_MASSACTION_COUNT = "//strong[@id = 'sales_order_grid_massaction-count']";
	public static final String ADMIN_ALL_CHECKBOXES = "//input[@type='checkbox' and @name = 'order_ids']";
	
}
