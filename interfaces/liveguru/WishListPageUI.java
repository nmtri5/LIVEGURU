package liveguru;

public class WishListPageUI {

	public static final String ADDED_SUCCESS_MESSAGE= "//li[@class = 'success-msg']//span";
	public static final String SHARE_WISHLIST_BUTTON = "//button[@title = 'Share Wishlist']";
	public static final String EMAIL_TEXTAREA = "//textarea[@id = 'email_address']";
	public static final String MESSAGE_TEXTAREA = "//textarea[@id = 'message']";
	
	public static final String SHARE_SUCCESS_MESSAGE = "//li[@class = 'success-msg']//span";
	
	public static final String DYNAMIC_ADD_PRODUCT_TO_CART = "//h3[@class = 'product-name']/a[text() = '%s']/ancestor-or-self::td/following-sibling::td//button[@title = 'Add to Cart']";
}
