package liveguru;

public class CartDetailPageUI {

	// Coupon
	public static final String COUPON_TEXTBOX = "//input[@id = 'coupon_code']";
	public static final String APPLY_COUPON_BUTTON = "//button[@title = 'Apply']";
	public static final String GRAND_PRICE_VALUE = "//td[@class = 'a-right']//span[@class ='price']";
	public static final String APPLY_COUPON_SUCCESS = "//li[@class = 'success-msg']//span";
	
	// Prices
	public static final String SUBTOTAL_VALUE = "//td[contains(text(), 'Subtotal')]/following-sibling::td/span";
	public static final String DISCOUNT_VALUE = "//td[contains(text(), 'Discount')]/following-sibling::td/span";
	public static final String SHIPPING_VALUE = "//td[contains(text(), 'Shipping')]/following-sibling::td/span";
	
	// Product in cart
	public static final String DYNAMIC_ITEM_IN_CART = "//h2[@class = 'product-name']/a[text() = '%s']";
	public static final String DYNAMIC_ITEM_SKU = "//table[@id = 'shopping-cart-table']//h2[@class = 'product-name']/a[text() = '%s']/ancestor-or-self::h2/following-sibling::div";
	
	// Quantity textbox
	public static final String DYNAMIC_QUANTITY_TEXT_BOX = "//input[@type = 'text' and @data-cart-item-id= '%s']";
	public static final String DYNAMIC_UPDATE_QUANTITY_BUTTON = "//input[@type = 'text' and @data-cart-item-id= '%s']/following-sibling::button";
	public static final String DYNAMIC_ERROR_MESSAGE = "//table[@id = 'shopping-cart-table']//h2[@class = 'product-name']/a[text() = '%s']/ancestor-or-self::h2/following-sibling::p[@class = 'item-msg error']";
	
	// Shipping information
	public static final String COUNTRY_DROPDOWN = "//select[@name = 'country_id']";
	public static final String STATE_DROPDOWN = "//select[@name = 'region_id']";
	public static final String STATE_TEXTBOX = "//input[@id= 'region']";
	public static final String ZIPCODE_TEXTBOX = "//input[@id= 'postcode']";
	public static final String ESTIMATE_BUTTON = "//button[@title= 'Estimate']";
	public static final String SHIPPING_RATE = "//label[@for= 's_method_flatrate_flatrate']";
	public static final String DYNAMIC_SHIPPING_RATE_RADIO = "//label[contains(text(), '%s')]/preceding-sibling::input[@id= 's_method_flatrate_flatrate']";
	public static final String UPDATE_TOTAL_BUTTON = "//button[@title = 'Update Total']";
	public static final String PROCEED_TO_CHECKOUT_BUTTON = "//div[@class = 'cart-totals']//button[@title = 'Proceed to Checkout']";
}
