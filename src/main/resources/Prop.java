import java.util.ListResourceBundle;

public class Prop extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

	static final Object[][] contents = { 
			{ "HelloMessage", "Buon giorno, world!" }, 
			{ "OtherMessage", "Ciao." } 
	};

}
