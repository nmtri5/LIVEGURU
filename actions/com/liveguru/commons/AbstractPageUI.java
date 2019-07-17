package com.liveguru.commons;

public class AbstractPageUI {
	// LINKS AT HOMEPAGE
	public static final String DYNAMIC_LINK_GENERAL = "//div[@class='links']//a[text() ='%s']";
	
	//NAVIGATOR
	public static final String DYNAMIC_LINK_NAVIGATION = "//nav[@id = 'nav']//a[text() = '%s']";
	
	// SIDEMENU LINKS
	public static final String DYNAMIC_LINK_SIDEMENU = "//div[@class = 'block-content']//a[text() = '%s']";
	
	// TITLE
	public static final String DYNAMIC_TITLE = "//div[@class = 'page-title']//h1[text() = 'Create an Account']";
	
	// TEXTBOX
	public static final String DYNAMIC_TEXTBOX_EDIT_ACCOUNT = "//ul[@class= 'form-list']//label[text() = '%s']/following-sibling::div/input";
	
	// BUTTON
	public static final String DYNAMIC_BUTTON = "//div[@class = 'buttons-set']//span[text() = '%s']";

	public static final String DYNAMIC_LINK = "//a[text()='%s']";

	
	/******************* ADMIN *******************/
	
	public static final String DYNAMIC_ADMIN_BUTTON = "//button//span[text() = '%s']";
	
	public static final String DYNAMIC_ADMIN_PAGE_TITLE = "//div[@id = 'anchor-content']//h3";

	public static final String ADMIN_LOADING_ICON = "//div[@id = 'loading-mask']";
	
	public static final String ADMIN_SYSTEM_MESSAGE = "//ul[@class='messages']//span";

}
