package liveguru;

public class ProductReviewPageUI {
	public static final String THOUGHT_TEXTBOX = "//textarea[@id = 'review_field']";
	public static final String SUMMARY_TEXTBOX = "//input[@id = 'summary_field']";
	public static final String NICKNAME_TEXTBOX = "//input[@id = 'nickname_field']";
	
	public static final String SUBMIT_REVIEW_BUTTON = "//button[@title = 'Submit Review']";
	
	public static final String DYNAMIC_ERROR_MESSAGE = "//label[text() = \"%s\"]/following-sibling::div[@class ='input-box']//div[@class = 'validation-advice']";
	
	public static final String SUCCESS_MESSAGE = "//li[@class ='success-msg']";
}

