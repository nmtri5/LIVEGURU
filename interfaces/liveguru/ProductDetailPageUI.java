package liveguru;

public class ProductDetailPageUI {
	public static final String PRODUCT_PRICE = "//div[@class = 'price-box']/span";
	public static final String PRODUCT_NAME = "//div[@class = 'product-name']/span";
	public static final String ADD_REVIEW = "//a[text()= 'Add Your Review']";
	public static final String PRODUCT_ONSALE = "//div[@class = 'price-box']/p[@class = 'old-price']";
	public static final String PRODUCT_SPECIAL_PRICE= "//div[@class = 'price-box']/p[@class = 'special-price']//span[contains(@id, 'product-price')]";
	
	public static final String DYNAMIC_PRODUCT_TABS = "//span[text() = '%s']";
	public static final String DYNAMIC_REVIEW_WITH_SPECIFIC_NICKNAME = "//a[contains(text(), '%s')]/ancestor-or-self::dt/following-sibling::dd//span[contains(text(), '%s')]/ancestor-or-self::dd[contains(text() ,'%s')]";
}	
