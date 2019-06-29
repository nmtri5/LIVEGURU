package liveguru;

public class ProductListPageUI {

	public static final String DYNAMIC_PRODUCT_PRICE = "//a[text() = '%s']//ancestor-or-self::h2/following-sibling::div/span/span";
	public static final String DYNAMIC_ONSALE_PRODUCT_PRICE = "//a[text() = '%s']//ancestor-or-self::h2/following-sibling::div//p[@class ='special-price']//span[contains(@id, 'product-price')]";
	public static final String DYNAMIC_PRODUCT_NAME = "//h2[@class='product-name']/a[text() = '%s']";
	public static final String DYNAMIC_ADD_TO_CART = "//h2[@class = 'product-name']//a[text() = '%s']//ancestor-or-self::h2/following-sibling::div[@class='actions']/button";

	public static final String DYNAMIC_ADD_TO_COMPARE = "//a[text() = '%s']//ancestor-or-self::h2/following-sibling::div[@class = 'actions']//a[text() = 'Add to Compare']";
	public static final String DYNAMIC_ADD_TO_WISHLIST = "//a[text() = '%s']//ancestor-or-self::h2/following-sibling::div[@class = 'actions']//a[text() = 'Add to Wishlist']";
	
	public static final String ADD_TO_COMPARE_LIST = "//ol[@id = 'compare-items']//li/p";
	
	public static final String COMPARE_BUTTON = "//div[@class = 'col-right sidebar']//button[@title = 'Compare']";
	public static final String COMPARE_PRODUCT = "//table[@id='product_comparison']//h2[@class = 'product-name']/a";
}
