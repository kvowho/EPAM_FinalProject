import java.util.ListResourceBundle;

public class Prop_ru extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

	static final Object[][] contents = { 
			{ "HelloMessage", "Привет" },
			{ "iStatus", "Статус" },
			{ "iComments", "Комментарии" },
			{ "iCreated", "Дата создания" },
			{ "iTotalAmount", "Всего" },
			{ "iProdName", "Наименование" },
			{ "iProdDescription", "Описание" },
			{ "iProdStockNum", "Складской остаток" },
			{ "iProdInvNum", "Количество" },
			{ "iProdPriceInInv", "Цена по счету" },
			{ "OtherMessage", "Пока" } 
	};

}
