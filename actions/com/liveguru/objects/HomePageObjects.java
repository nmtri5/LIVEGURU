package com.liveguru.objects;

import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;

import liveguru.HomePageUI;

public class HomePageObjects extends AbstractPage{
	WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
}
