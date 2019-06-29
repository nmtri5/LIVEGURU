package liveguru;

public class CheckoutPageUI {
	public static final String DYNAMIC_BILLING_INFORMATION_TEXTBOX = "//li[@id = 'opc-billing']//*[contains(@title, '%s')]";
	public static final String DYNAMIC_SHIPPING_INFORMATION_TEXTBOX = "//li[@id = 'opc-shipping']//*[contains(@title, '%s')]";
	
	public static final String DYNAMIC_CHECKOUT_CONTINUE_BUTTON = "//h2[text() = '%s']//ancestor-or-self::li//button";
	
	public static final String DYNAMIC_TAB_ACTIVE = "//h2[text() = '%s']//ancestor-or-self::li[contains(@class, 'active')]";
	
	public static final String DYNAMIC_PAYMENT_OPTION = "//input[@id = 'p_method_checkmo' and @title = '%s']";
	
	public static final String SUCCESS_PLACE_ORDER_MESSAGE = "//h2[@class = 'sub-title']";
	
	public static final String PLACE_ORDER_BUTTON = "//button[@title = 'Place Order']";
	
	public static final String ORDER_ID = "//p[text() = 'Your order # is: ']/a";
	
	public static final String DYNAMIC_SHIPPING_ADDRESS_OPTION = "//li[@class = 'control']/input[@title = '%s']";
}
