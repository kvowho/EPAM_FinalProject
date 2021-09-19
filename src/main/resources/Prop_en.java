import java.util.ListResourceBundle;

public class Prop_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

	static final Object[][] contents = { 
			{ "HelloMessage", "English Hellow" },
			{ "iStatus", "Status" },
			{ "iComments", "Comment" },
			{ "iCreated", "Created" },
			{ "iTotalAmount", "Total Amount" },
			{ "iProdName", "Product Name" },
			{ "iProdDescription", "Description" },
			{ "iProdStockNum", "Stock quantity" },
			{ "iProdInvNum", "Quantity" },
			{ "iProdPriceInInv", "Invoice price" },
			{ "OtherMessage", "Ciao." } 
	};

}
