package com.liveguru.objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;

import com.liveguru.commons.AbstractPage;
import com.liveguru.commons.AbstractPageUI;

import liveguru.AdminInvoicesPageUI;

public class AdminInvoicePageObjects extends AbstractPage {

	WebDriver driver;

	public AdminInvoicePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public List<String> getInvoicesList() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		List<String> invoiceList = new ArrayList<String>();
		
		invoiceList = getTextInListOfElement(driver, AdminInvoicesPageUI.INVOICES_LIST);
		return invoiceList;
	}
	
	public List<String> getInvoiceDateList() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		List<String> invoiceList = new ArrayList<String>();
		
		invoiceList = getTextInListOfElement(driver, AdminInvoicesPageUI.INVOICE_DATE_LIST);
		return invoiceList;
	}
	
	public List<String> getOrderList() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		List<String> invoiceList = new ArrayList<String>();
		
		invoiceList = getTextInListOfElement(driver, AdminInvoicesPageUI.ORDER_LIST);
		return invoiceList;
	}
	
	public List<String> getBillToNameList() {
		waitForElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_ICON);
		List<String> invoiceList = new ArrayList<String>();

		invoiceList = getTextInListOfElement(driver, AdminInvoicesPageUI.BILL_TO_NAME_LIST);
		return invoiceList;
	}

	public void clickToAnyHeadings(String heading) {
		waitForElementVisible(driver, AdminInvoicesPageUI.DYNAMIC_HEADINGS, heading);
		clickToElement(driver, AdminInvoicesPageUI.DYNAMIC_HEADINGS, heading);
	}

	public boolean isSortingCorrectly(String heading, List<String> actualList) {
		List<String> expectedList = new ArrayList<String>();
		List<Date> dateList = new ArrayList<Date>();
		expectedList.addAll(actualList);
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy h:mm:ss a");

		switch (heading) {
		case "Invoice Date":
		case "Order Date":
			for (String date : expectedList) {
				Date d1;
				try {
					d1 = formatter.parse(date);
					dateList.add(d1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (getAttributeValue(driver, AdminInvoicesPageUI.DYNAMIC_HEADINGS, "title", heading).equals("desc")) {
				Collections.sort(dateList);
				expectedList.clear();
				for (Date dat : dateList) {
					expectedList.add(dat.toString());
				}
				return actualList.equals(expectedList);
			} else {
				Collections.sort(dateList, Collections.reverseOrder());
				expectedList.clear();
				for (Date dat : dateList) {
					expectedList.add(dat.toString());
				}
				return actualList.equals(expectedList);
			}
		case "Bill to Name":
			if (getAttributeValue(driver, AdminInvoicesPageUI.DYNAMIC_HEADINGS, "title", heading).equals("desc")) {
				Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
				return actualList.equals(expectedList);
			} else {
				Collections.sort(expectedList, String.CASE_INSENSITIVE_ORDER);
				Collections.reverse(expectedList);
				return actualList.equals(expectedList);
			}
		default:
			if (getAttributeValue(driver, AdminInvoicesPageUI.DYNAMIC_HEADINGS, "title", heading).equals("desc")) {
				Collections.sort(expectedList);
				return actualList.equals(expectedList);
			} else {
				Collections.sort(expectedList, Collections.reverseOrder());
				return actualList.equals(expectedList);
			}
		}

	}

}
