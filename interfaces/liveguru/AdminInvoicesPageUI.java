package liveguru;

public class AdminInvoicesPageUI {

	public static final String INVOICES_LIST = "//table[@id = 'sales_invoice_grid_table']//tbody//tr//td[2]";
	public static final String INVOICE_DATE_LIST = "//table[@id = 'sales_invoice_grid_table']//tbody//tr//td[3]";
	public static final String DYNAMIC_HEADINGS = "//tr[@class = 'headings']//span[text() = '%s']/ancestor-or-self::a";
	public static final String ORDER_LIST = "//table[@id = 'sales_invoice_grid_table']//tbody//tr//td[4]";
	public static final String BILL_TO_NAME_LIST = "//table[@id = 'sales_invoice_grid_table']//tbody//tr//td[6]";
	
}
